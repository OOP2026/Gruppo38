package exceptions;

public class MissingStudentException extends RuntimeException {
    public MissingStudentException(String message) {
        super(message);
    }
}
