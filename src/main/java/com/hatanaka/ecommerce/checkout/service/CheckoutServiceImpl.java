package com.hatanaka.ecommerce.checkout.service;

import com.hatanaka.ecommerce.checkout.entity.CheckoutEntity;
import com.hatanaka.ecommerce.checkout.entity.CheckoutItemEntity;
import com.hatanaka.ecommerce.checkout.entity.ShippingEntity;
import com.hatanaka.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.hatanaka.ecommerce.checkout.repository.CheckoutRepository;
import com.hatanaka.ecommerce.checkout.resource.checkout.CheckoutRequest;
import com.hatanaka.ecommerce.checkout.streaming.CheckoutCreatedSource;
import com.hatanaka.ecommerce.checkout.util.UUIDUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

// para poder ocorrer a implementação é necessário atribuir esse valor
@Service

// cria um construtor para todos os atributos que estão como final, não é uma boa prática colocar o @Autowired no atributo da classe
@RequiredArgsConstructor
@Slf4j

// essa classe implementa a outra classe java dessa mesma pasta
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource; // injeta o Source
    private final UUIDUtil uuidUtil;

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        log.info("M=create, checkoutRequest={}", checkoutRequest);
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(uuidUtil.createUUID().toString())

                // cria o status do checkout 
                .status(CheckoutEntity.Status.CREATED) 

                // salva o endereço
                .saveAddress(checkoutRequest.getSaveAddress())

                // salva as informações
                .saveInformation(checkoutRequest.getSaveInfo())

                // faz um estado de solicitação e passa os dados
                .shipping(ShippingEntity.builder()
                                  .address(checkoutRequest.getAddress())
                                  .complement(checkoutRequest.getComplement())
                                  .country(checkoutRequest.getCountry())
                                  .state(checkoutRequest.getState())
                                  .cep(checkoutRequest.getCep())
                                  .build())
                .build();

        // adiciona os itens e pega os produtos
        checkoutEntity.setItems(checkoutRequest.getProducts()
                                        .stream()
                                        .map(product -> CheckoutItemEntity.builder()
                                                .checkout(checkoutEntity)
                                                .product(product)
                                                .build())
                                        .collect(Collectors.toList()));

        // salva todas as entidades
        final CheckoutEntity entity = checkoutRepository.save(checkoutEntity);

        // gera um novo estado de solicitação
        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus(entity.getStatus().name())
                .build();

        // passa o output para pegar o tópico virtual e enviar, recebe uma mensagem, passa o evento faz um build
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());
        return Optional.of(entity);
    }

    // o método vai ser sobrescrito
    @Override

    // atualiza o status 
    public Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status) {

        // checa a entidade no repository pelo código, se der erro gera um novo estado de solicitação
        final CheckoutEntity checkoutEntity = checkoutRepository.findByCode(checkoutCode).orElse(CheckoutEntity.builder().build());

        // estado aprovado
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVED);

        // salva a entidade
        return Optional.of(checkoutRepository.save(checkoutEntity));
    }
}
