package com.orderServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PurchaseOrderService {

    public List<PurchaseOrder> getPurchaseOrders();

    public void createPurchaseOrder(PurchaseOrder purchaseOrder);

}


@Service
class PurchaseOrderServiceImpl implements PurchaseOrderService {

    
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    
    @Override
    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);        
    }
    
}