package llj2003.hudapi.exception;

/**
 * This exception indicates that you use a string that is not a key
 *
 * @author llj2003
 */
public class NotKeyException extends Exception{
    public NotKeyException(String key) {
        super(String.format("String \"%s\" not a key", key));
    }
}
