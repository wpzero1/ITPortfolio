package exception;

public class InexistentException extends Exception {
	public InexistentException() {
		super("미 존재하는 데이터입니다.");
	}
	public InexistentException(String message) {
		super(message +" : 미존재하는 데이터입니다.");
	}
}
