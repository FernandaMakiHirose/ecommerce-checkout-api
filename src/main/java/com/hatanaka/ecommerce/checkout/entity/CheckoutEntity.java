package com.hatanaka.ecommerce.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

// as entidades são objetos para representar uma tabela de base de dados

@Entity // para entender que é uma entidade

@Audited
@EntityListeners(AuditingEntityListener.class)

// constrói um objeto sem instanciar 
@Builder

@Data // cria um Getter, Setter, Construtor, ToString, EqualsAndHashCode
@NoArgsConstructor // caso não tenha nenhum argumento vai criar um construtor
@AllArgsConstructor // os construtores vão existir em tempo de compilação
public class CheckoutEntity {

    @Id 
    @GeneratedValue // indica que o id vai ser gerado pelo provedor de persistência, é adicionado logo após o id
    private Long id;

    @Column // informa a configuração da coluna da tabela
    private String code;

    @Column
    @Enumerated(value = EnumType.STRING) // transforma o valor em string
    private Status status; // status do checkout

    @Column
    private Boolean saveAddress;

    @Column
    private Boolean saveInformation;

    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    private ShippingEntity shipping;

    @OneToMany(mappedBy = "checkout", cascade = CascadeType.ALL)
    private List<CheckoutItemEntity> items;

    public enum Status {
        CREATED,
        APPROVED
    }
}
