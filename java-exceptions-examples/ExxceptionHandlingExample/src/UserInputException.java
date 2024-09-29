
public class UserInputException extends RuntimeException{
	
	private String message;

	public UserInputException(String message) {
		super();
		this.message = message;
	}

	public UserInputException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}
	
	

}
