package convinience_store.src.main.java.exceptions;

public class InsufficientFundsException extends NoSuchFieldException{
    public InsufficientFundsException(String message){
        super(message);
    }
}
