package ykkz000.hudapi.exception;

/**
 * This exception indicates that you use a key that do not reference an item
 *
 * @author ykkz000
 */
public class KeyNotItemException extends Exception{
    public KeyNotItemException(String key) {
        super(String.format("Key \"%s\" not an item", key));
    }
}
