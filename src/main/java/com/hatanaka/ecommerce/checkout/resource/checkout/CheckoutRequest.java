package com.hatanaka.ecommerce.checkout.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data // cria um Getter, Setter, Construtor, ToString, EqualsAndHashCode
@AllArgsConstructor // os construtores vão existir em tempo de compilação
@NoArgsConstructor // caso não tenha nenhum argumento vai criar um construtor

// por ser um request precisa implementar o Serializable 
public class CheckoutRequest implements Serializable {

    // cria os objetos do frontend
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String complement;
    private String country;
    private String state;
    private String cep;
    private Boolean saveAddress;
    private Boolean saveInfo;
    private String paymentMethod;
    private String cardName;
    private String cardNumber;
    private String cardDate;
    private String cardCvv;
    private List<String> products;
}

