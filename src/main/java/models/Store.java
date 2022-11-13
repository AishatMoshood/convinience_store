package convinience_store.src.main.java.models;

import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@NoArgsConstructor

public class Store {
       private static List<Product> availableProductsList = new ArrayList<>();
       public static Queue<Customer> allCustomersQueue = new LinkedList<>();

       public Store(List<Product> availableProductsList) {
              this.availableProductsList = availableProductsList;
       }

       public void addToAvailableProductsList(Product product) {
              availableProductsList.add(product);
       }
       public List<Product> getFromAvailableProductsList() {
              return availableProductsList;
       }

       public static void readProducts(String fileName) {
              fileName = "/Users/decagon/Desktop/A/week-three/src/main/resources/products.csv";

              try (BufferedReader br = new BufferedReader(
                      new FileReader(fileName, StandardCharsets.UTF_8))) {

                     String line;
                     while ((line = br.readLine()) != null) {

                            String[] values = line.split(",");

                            if(values[0].equals("Product Id")) continue;

                            Integer productId = Integer.parseInt(values[0]);
                            String productName = values[1];
                            Double  productPrice = Double.parseDouble(values[2]);
                            Integer productQuantity = Integer.parseInt(values[3]);
                            String productNumber = values[4];
                            String productDescription = values[5];

                            availableProductsList.add(new Product(productId, productName, productPrice, productQuantity,
                                    productNumber, productDescription));

                     }
              } catch (IOException e){
                     throw new RuntimeException(e);
              }

       }
}
