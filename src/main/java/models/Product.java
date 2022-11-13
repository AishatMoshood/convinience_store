package convinience_store.src.main.java.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Product {

    private Integer id;
    private String name;
    private Double price;
    private Integer quantity;
    private String productNo;
    private String desc;
}
