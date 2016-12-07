package hello.order;

import hello.order.data.Item;
import hello.order.data.User;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RandomPurchasingOrderService extends PurchasingOrderService {

    @Autowired
    private
    DataFactory dataFactory;

    public void purchaseOrder() {

        if(getDataFactory().chance(80)) {
             /* do normal business things: create an order for a new user */
            try {

                // create and save a new random user
                User customer = createRandomUser();
                userService.saveUser(customer);

                // add some items to the order and purchase it
                int customersOrderId = orderService.createNewOrder(customer);

                // allways have two items
                int itemId = 0;
                orderService.addItemToOrder(customersOrderId, customer, new Item(++itemId, "Item" + itemId)); // item1
                orderService.addItemToOrder(customersOrderId, customer, new Item(++itemId, "Item" + itemId)); // item2

                // but sometimes more items are also good
                while (getDataFactory().chance(50)) {
                    orderService.addItemToOrder(customersOrderId, customer, new Item(++itemId, "Item" + itemId)); // itemX
                }

                orderService.purchaseOrder(customersOrderId, customer);

            } catch (Exception e) {
                log.error("Error in order task", e);
            }

            userService.clearUsers();
            orderService.clearOrders();
        } else {
            /* sometimes create an order for john doe */
            super.purchaseOrder();
        }
    }

    private User createRandomUser()  {
        String firstName = getDataFactory().getFirstName();
        String lastName = getDataFactory().getLastName();
        String userName = firstName + lastName;
        return createUser(userName, firstName, lastName);
    }

    public DataFactory getDataFactory() {
        return dataFactory;
    }

    public void setDataFactory(DataFactory dataFactory) {
        this.dataFactory = dataFactory;
    }
}
