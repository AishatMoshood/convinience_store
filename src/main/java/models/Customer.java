package convinience_store.src.main.java.models;

import convinience_store.src.main.java.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString

public class Customer extends Person {

    private Double wallet;
    private Integer quantity = 0;
    private List<Product> cart = new ArrayList<>();

    public Customer(Integer id, String name, Gender gender, Double wallet) {
        super(id, name, gender);
        this.wallet = wallet;
    }
}
