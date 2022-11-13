package convinience_store.src.main.java.models;

import convinience_store.src.main.java.enums.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Applicant extends Person {
    private String email;
    private Qualification qualification;
    private Integer age;

//    public Applicant() {
//    }

    public Applicant(Integer id, String name, Gender gender, String email, Qualification qualification, Integer age) {
        super(id, name, gender);
        this.email = email;
        this.qualification = qualification;
        this.age = age;
    }

    public Applicant(Integer id, String name, String email, Qualification qualification, Integer age) {
        super(id, name);
        this.email = email;
        this.qualification = qualification;
        this.age = age;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public Qualification getQualification() {
//        return qualification;
//    }
//
//    public void setQualification(Qualification qualification) {
//        this.qualification = qualification;
//    }
//
//    public Integer getAge() {
//        return age;
//    }
//
//    public void setAge(Integer age) {
//        this.age = age;
//    }
//
//    @Override
//   public String toString() {
//       return "Applicant{" +
//               "email='" + email + '\'' +
//              ", qualification=" + qualification +
//             ", age=" + age +
//                "} " + super.toString();
//    }

}
