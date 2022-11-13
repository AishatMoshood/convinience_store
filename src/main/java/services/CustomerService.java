package convinience_store.src.main.java.services;
import convinience_store.src.main.java.models.*;
import convinience_store.src.main.java.exceptions.*;
import convinience_store.src.main.java.interfaces.CustomerInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class CustomerService implements CustomerInterface {
    private Customer customer;

    public CustomerService(Customer customer) {
        this.customer = customer;
    }

    List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> buyProduct(String productName, int quantity) throws InsufficientFundsException, NotEnoughQuantityException, OutOfStockException, EnterValidQuantityException, ProductNotAvailableException {
        Store.readProducts("week-three/src/main/resources/products.csv");
        Store store = new Store();
        Double productPrice = 0.0;

        int count = 0;

        for(int i =0; i<store.getFromAvailableProductsList().size(); i++) {
            if(store.getFromAvailableProductsList().get(i).getName().equals(productName)) {
                count ++;
            }
        }
        if ( count < 1) throw new ProductNotAvailableException("Product not available");

        for(int i =0; i<store.getFromAvailableProductsList().size(); i++){

            if(store.getFromAvailableProductsList().get(i).getName().equals(productName)) {
                if (quantity <= 0) {
                    throw new EnterValidQuantityException("Please enter a valid quantity from one upwards");
                } else if (store.getFromAvailableProductsList().get(i).getQuantity() == 0) {
                    throw new OutOfStockException(store.getFromAvailableProductsList().get(i).getName() + " out of stock");
                } else if (store.getFromAvailableProductsList().get(i).getQuantity() >= quantity) {
                    if (customer.getWallet() >= store.getFromAvailableProductsList().get(i).getPrice() * quantity) {
                        System.out.println(store.getFromAvailableProductsList().get(i).getName() + " added to cart successfully");

                        allProducts.add(new Product(store.getFromAvailableProductsList().get(i).getId(),
                                store.getFromAvailableProductsList().get(i).getName(),
                                store.getFromAvailableProductsList().get(i).getPrice(),
                                quantity, store.getFromAvailableProductsList().get(i).getProductNo(),
                                store.getFromAvailableProductsList().get(i).getDesc()));

                        customer.setCart(allProducts);

                        customer.setQuantity(customer.getQuantity() + quantity);

                        store.getFromAvailableProductsList().get(i).setQuantity(store.getFromAvailableProductsList().get(i).getQuantity() - quantity);

                        productPrice += store.getFromAvailableProductsList().get(i).getPrice();

                        customer.setWallet(customer.getWallet() - productPrice * quantity);
                        break;
                    } else {
                        throw new InsufficientFundsException("Sorry you do not have enough money to purchase this quantity of " + store.getFromAvailableProductsList().get(i).getName());
                    }
                } else {
                    throw new NotEnoughQuantityException("Sorry the quantity you requested is more than what we have");
                }
            }
        }

        return customer.getCart();
    }
}
