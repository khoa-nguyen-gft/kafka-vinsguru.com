package com.orderServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    
    @Autowired
    private PurchaseOrderService purchaseOrderService;
    
    
    @GetMapping("/")
    public List<PurchaseOrder> getAllOrder() {
        return purchaseOrderService.getPurchaseOrders();
    }
    
    @PostMapping("/create")
    public void createOrder(@RequestBody PurchaseOrder purchaseOrder) {
        purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }
}
