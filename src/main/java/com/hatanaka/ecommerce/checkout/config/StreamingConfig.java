package com.hatanaka.ecommerce.checkout.config;

import com.hatanaka.ecommerce.checkout.streaming.CheckoutCreatedSource;
import com.hatanaka.ecommerce.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = { // necessário adicionar, passando a interface
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
