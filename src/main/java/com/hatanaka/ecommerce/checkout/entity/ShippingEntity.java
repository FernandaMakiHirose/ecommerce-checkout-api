package com.hatanaka.ecommerce.checkout.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

// as entidades são objetos para representar uma tabela de base de dados

@Entity // indica que é uma entidade
@Audited // para cada entidade @Audited, será criada uma tabela, que conterá o histórico das alterações realizadas na entidade
@EntityListeners(AuditingEntityListener.class)
@Builder // produz APIs de construtor complexas para suas classes
@Data // cria um Getter, Setter, Construtor, ToString, EqualsAndHashCode
@NoArgsConstructor // caso não tenha nenhum argumento vai criar um construtor
@AllArgsConstructor // os construtores vão existir em tempo de compilação
public class ShippingEntity {

    @Id
    @GeneratedValue // indica que o id vai ser gerado pelo provedor de persistência, é adicionado logo após o id
    private Long id;

    @Column
    private String address;

    @Column
    private String complement;

    @Column
    private String country;

    @Column
    private String state;

    @Column
    private String cep;

    @OneToOne(mappedBy = "shipping")
    private CheckoutEntity checkout;
}
