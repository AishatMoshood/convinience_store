package convinience_store.src.main.java.models;

import convinience_store.src.main.java.enums.Gender;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public abstract class Person {

    private Integer id;
    private String name;
    private Gender gender;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
