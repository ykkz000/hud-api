package ykkz000.hudapi.exception;

/**
 * This exception indicates that you use a string that is not a key
 *
 * @author ykkz000
 */
public class NotKeyException extends Exception{
    public NotKeyException(String key) {
        super(String.format("String \"%s\" not a key", key));
    }
}
