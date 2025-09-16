package customexception;

public class InvalidDiscountException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidDiscountException(String msg) {
		super(msg);
	}
}
