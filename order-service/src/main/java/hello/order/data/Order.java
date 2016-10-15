package hello.order.data;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private User customer;
    private List<Item> items;

    public Order(int id, User customer) {
        this.id = id;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public User getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer.toString() +
                '}';
    }
}
