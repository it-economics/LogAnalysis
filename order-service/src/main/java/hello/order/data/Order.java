package hello.order.data;

/**
 * Created by fdorau on 14.10.2016.
 */
public class Order {

    private int id;
    private Customer customer;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
