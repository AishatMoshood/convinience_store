package convinience_store.src.main.java.models;

import convinience_store.src.main.java.enums.Gender;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Manager extends Staff {
    public Manager(Integer id, String name, Gender gender, String qualification) {
        super(id, name, gender, qualification);
    }

}
