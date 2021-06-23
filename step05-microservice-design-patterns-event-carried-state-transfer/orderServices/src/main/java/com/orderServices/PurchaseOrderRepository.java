package com.orderServices;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrder, Long>{

}
