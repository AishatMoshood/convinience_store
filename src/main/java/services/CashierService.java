package convinience_store.src.main.java.services;

import convinience_store.src.main.java.interfaces.CashierInterface;
import convinience_store.src.main.java.models.*;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class CashierService implements CashierInterface {
    private Cashier cashier;
    public CashierService(Cashier cashier) {
        this.cashier = cashier;
    }

    public String sell(Customer customer){
        int i = 0, j = 0;
        double totalPrice = Stream.of(customer.getCart().get(i++)).map(Product::getPrice).reduce(Double::sum).get();
        int totalQuantity = Stream.of(customer.getCart().get(j++)).map(x->x.getQuantity()).reduce((a,b)-> a + b).get();
        return customer.getName() + ", your total balance is " + "N"+(totalPrice * totalQuantity);
    }

    public void sellToQueue(Collection<Customer> customers) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        int count = Store.allCustomersQueue.size();
        for (int i = 0; i < count; i++) {
            Customer nextCustomer = Store.allCustomersQueue.poll();
            executorService.execute(() -> {
                System.out.println(nextCustomer.getName() + " is being attended to on thread " + Thread.currentThread().getName());
                sell(nextCustomer);
                System.out.println("Done selling");
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
        System.out.println("Finished");
    }

    @Override
    public Double issueReceipt(Customer customer) {
        Double total = 0d;

        Predicate<Customer> customerPredicate = customer1 -> customer1.getQuantity().equals(0);

        if(!customerPredicate.test(customer)){
            System.out.println("****  RECEIPT  ****");
            System.out.printf("%-9s %-10s %-8s %-11s%n", "Item name", "Unit price", "Quantity", "Total price(N)");
            for (Product product: customer.getCart()) {
                System.out.printf("%-9s %-10.2f %-8d %-11.2f%n", product.getName(), product.getPrice(), product.getQuantity(), product.getQuantity() * product.getPrice());
                total+= (product.getPrice() * product.getQuantity());
                customer.setQuantity(0);
                customer.setCart(null);
            }
            System.out.printf("%n%s \t\t\t\t\t%.2f%n","Total bill", total);
            System.out.println("*****************************************");
        } else {
            System.out.println(customer.getName() + " hasn't bought a product");
        }
        return total;
    }
}
