package convinience_store.src.main.java.interfaces;

import convinience_store.src.main.java.models.Customer;

import java.util.Collection;
import java.util.List;

public interface CashierInterface {
    Double issueReceipt(Customer customer);

    String sell(Customer customer);

    void sellToQueue(Collection<Customer> customers);
}
