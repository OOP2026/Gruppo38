package exceptions;

public class MissingTeacherException extends RuntimeException {
    public MissingTeacherException(String message) {
        super(message);
    }
}
