package convinience_store.src.main.java.exceptions;

public class OutOfStockException extends NoSuchFieldException {
    public OutOfStockException(String message){
        super(message);
    }
}
