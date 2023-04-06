package llj2003.hudapi.exception;

/**
 * This exception indicates that you use a key that do not reference an item
 *
 * @author llj2003
 */
public class KeyNotItemException extends Exception{
    public KeyNotItemException(String key) {
        super(String.format("Key \"%s\" not an item", key));
    }
}
