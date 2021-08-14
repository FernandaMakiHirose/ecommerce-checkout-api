package com.hatanaka.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CheckoutCreatedSource {

    // tópico virtual 
    String OUTPUT = "checkout-created-output";

    @Output(OUTPUT)
    MessageChannel output();
}
