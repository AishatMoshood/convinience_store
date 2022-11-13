package convinience_store.src.main.java.models;

import convinience_store.src.main.java.enums.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Cashier extends Staff {
    public Cashier(Integer id, String name, Gender gender, String qualification) {
        super(id, name, gender, qualification);
    }
}
