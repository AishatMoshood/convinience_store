package convinience_store.src.main.java.interfaces;

import convinience_store.src.main.java.models.*;
import convinience_store.src.main.java.exceptions.*;

import java.util.List;

public interface CustomerInterface {
    List<Product> buyProduct(String productName, int quantity) throws InsufficientFundsException,
            NotEnoughQuantityException, OutOfStockException, EnterValidQuantityException, ProductNotAvailableException;
}

