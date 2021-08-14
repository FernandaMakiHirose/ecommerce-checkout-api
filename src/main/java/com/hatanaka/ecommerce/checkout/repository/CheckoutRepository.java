package com.hatanaka.ecommerce.checkout.repository;

import com.hatanaka.ecommerce.checkout.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// o repository acessa a entidade na base de dados

@Repository // diz que é um repository

// acessa o repository do JPA, passa a entidade e o tipo do id
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {

    Optional<CheckoutEntity> findByCode(String code);
}
