package hello.order.controller;

import hello.order.PurchasingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private PurchasingOrderService purchasingOrderService;

    @RequestMapping("/order")
    public String order() {
        purchasingOrderService.purchaseOrder();
        return "Purchasing order";
    }
}
