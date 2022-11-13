package convinience_store.src.main.java.exceptions;

public class ProductNotAvailableException extends NoSuchFieldException {
    public ProductNotAvailableException(String message){
        super(message);
    }
}
