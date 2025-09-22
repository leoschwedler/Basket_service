package com.schwedlermobile.basketservice.repository;

import com.schwedlermobile.basketservice.model.BasketEntity;
import com.schwedlermobile.basketservice.model.Status;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BasketRepository extends MongoRepository<BasketEntity, String> {

    Optional<BasketEntity> findByClientAndStatus(Long client, Status status);
}
