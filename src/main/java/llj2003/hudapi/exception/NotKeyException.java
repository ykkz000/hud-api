package llj2003.hudapi.exception;
public class NotKeyException extends Exception{
    public NotKeyException(String key) {
        super(String.format("String \"%s\" not a key", key));
    }
}
