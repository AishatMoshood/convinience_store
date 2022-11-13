package convinience_store.src.main.java.services;

import convinience_store.src.main.java.models.Applicant;
import convinience_store.src.main.java.models.Manager;
import convinience_store.src.main.java.interfaces.ManagerInterface;

import java.util.function.Predicate;

import static convinience_store.src.main.java.enums.Qualification.HND;

public class ManagerService implements ManagerInterface {
    private Manager manager;

    @Override
    public String hire(Applicant applicant) {
        Predicate<Applicant> qualificationPredicate = app -> app.getQualification().equals(HND);

        if(!qualificationPredicate.test(applicant)){
            return "Congratulations " + applicant.getName() + " you're hired";
        }

        return "Sorry, you do not meet the requirements";
    }
}
