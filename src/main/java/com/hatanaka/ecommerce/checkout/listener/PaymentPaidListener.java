package com.hatanaka.ecommerce.checkout.listener;

import com.hatanaka.ecommerce.checkout.entity.CheckoutEntity;
import com.hatanaka.ecommerce.checkout.service.CheckoutService;
import com.hatanaka.ecommerce.checkout.streaming.PaymentPaidSink;
import com.hatanaka.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component // detecta os beans, o @Bean cria o objeto e deixa disponível para todas as outras classes utilizarem ele 

@RequiredArgsConstructor // gera um construtor com 1 parâmetro para cada campo que requer tratamento especial

public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {

        // atualiza o status do Service, um evento é criado com o código que vira String, vai checar a entidade e o status vai estar aprovado
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
