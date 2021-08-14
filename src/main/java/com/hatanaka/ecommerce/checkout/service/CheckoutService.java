package com.hatanaka.ecommerce.checkout.service;

import com.hatanaka.ecommerce.checkout.entity.CheckoutEntity;
import com.hatanaka.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    // passa p CheckoutEntity que cria o CheckoutRequest
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    // faz a atualização do status
    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
