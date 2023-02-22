package llj2003.hudapi.exception;
public class KeyNotItemException extends Exception{
    public KeyNotItemException(String key) {
        super(String.format("Key \"%s\" not an item", key));
    }
}
