package com.hatanaka.ecommerce.checkout.resource.checkout;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// representa o contrato de saída, foi adicionado nesse arquivo para que o dado não seja exposto 

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckoutResponse implements Serializable {

    private String code;
}
