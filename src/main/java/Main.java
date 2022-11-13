package convinience_store.src.main.java;

import convinience_store.src.main.java.enums.*;
import convinience_store.src.main.java.exceptions.*;
import convinience_store.src.main.java.models.Cashier;
import convinience_store.src.main.java.models.Customer;
import convinience_store.src.main.java.models.Store;
import convinience_store.src.main.java.services.CashierService;
import convinience_store.src.main.java.services.CustomerService;
import convinience_store.src.main.java.services.ManagerService;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws OutOfStockException, EnterValidQuantityException, InsufficientFundsException, NotEnoughQuantityException, ProductNotAvailableException {
        Store store = new Store();

        Customer alima = new Customer(1,"Alima", Gender.FEMALE,9000.00);
        Customer abdulllahi = new Customer(2,"Abdulllahi", Gender.MALE,100000.00);
        Customer faith = new Customer(3,"Faith", Gender.FEMALE,30000.00);
        Customer ite = new Customer(4,"Ite", Gender.FEMALE,40000.00);
        Customer mercy = new Customer(5,"Mercy", Gender.FEMALE,50000.00);
        Customer caleb = new Customer(6,"Caleb", Gender.MALE,80000.00);

        CustomerService alimaService = new CustomerService(alima);
        CustomerService abdulService = new CustomerService(abdulllahi);
        CustomerService faithService = new CustomerService(faith);
        CustomerService iteService = new CustomerService(ite);
        CustomerService mercyService = new CustomerService(mercy);
        CustomerService calebService = new CustomerService(caleb);

        Store.allCustomersQueue.add(alima);
        Store.allCustomersQueue.add(abdulllahi);
        Store.allCustomersQueue.add(faith);
        Store.allCustomersQueue.add(ite);
        Store.allCustomersQueue.add(mercy);
        Store.allCustomersQueue.add(caleb);

        alimaService.buyProduct("Noodles", 1);
        abdulService.buyProduct("Rice", 9);
        faithService.buyProduct("Spaghetti", 4);
        iteService.buyProduct("Palm Oil", 3);
        mercyService.buyProduct("Macaroni", 4);
        calebService.buyProduct("Semovita", 9);

        Cashier cashier = new Cashier();
        CashierService cashierService = new CashierService(cashier);

        cashierService.sellToQueue(Store.allCustomersQueue);

        System.out.println("___________________");
        System.out.println( alima.getCart());
        System.out.println( alima.getWallet());
        System.out.println( alima.getQuantity());
        System.out.println("___________________");

        System.out.println("___________________");
        System.out.println("___________________");
        System.out.println(cashierService.issueReceipt(alima));
//       cashierService.issueReceipt(abdulllahi);
//       cashierService.issueReceipt(alima);
        System.out.println("___________________");
        System.out.println("___________________");
        System.out.println("Alima's remaining balance is " + alima.getWallet());

//        Applicant applicant = new Applicant(2,"Abdul",Gender.MALE,"ndgs@", Qualification.MSC,26);
//        ManagerService managerService = new ManagerService();
//        System.out.println(managerService.hire(applicant));
    }
}
