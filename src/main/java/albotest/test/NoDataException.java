package albotest.test;

/**
 * Handling of exceptions when the requested data is not found
 */
public class NoDataException extends RuntimeException {

    public NoDataException(String nameHero) {
        super("Data not found by nameHero:" + nameHero);
    }

}
