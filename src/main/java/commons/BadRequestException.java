package commons;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message); // super()를 정의해주어야 한다
    }
}
