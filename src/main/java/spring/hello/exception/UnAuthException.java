package spring.hello.exception;

/**
 * @author xinufo
 *
 */
public class UnAuthException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public UnAuthException() {
        super();
    }

    public UnAuthException(String message) {
        super(message);
    }

}
