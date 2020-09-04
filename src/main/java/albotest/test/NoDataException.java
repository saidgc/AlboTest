package albotest.test;

/**
 * Handling of exceptions when the requested data is not found
 */
public class NoDataException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoDataException(String name) {
        super("Not found:" + name);
    }

}
