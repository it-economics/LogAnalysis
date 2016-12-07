package hello.order.controller;

import hello.order.PurchasingOrderService;
import hello.order.RandomPurchasingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private RandomPurchasingOrderService purchasingOrderService;

    @RequestMapping("/order")
    public String order() {
        purchasingOrderService.purchaseOrder();
        return "Purchasing order";
    }
}
