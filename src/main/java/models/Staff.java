package convinience_store.src.main.java.models;

import convinience_store.src.main.java.enums.Gender;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public abstract class Staff extends Person {

    private String qualification;

    public Staff(Integer id, String name, Gender gender, String qualification) {
        super(id, name, gender);
        this.qualification = qualification;
    }
}
