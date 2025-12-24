package exception;

public class OrderCannotBeAssignedException extends RuntimeException {
    public OrderCannotBeAssignedException(String msg) {
        super(msg);
    }
}