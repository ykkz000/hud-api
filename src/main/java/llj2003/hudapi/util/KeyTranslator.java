package llj2003.hudapi.util;

import llj2003.hudapi.exception.KeyNotItemException;
import llj2003.hudapi.exception.NotKeyException;
import net.minecraft.util.Identifier;

/**
 * Key translator
 *
 * @author llj2003
 */
public class KeyTranslator {
    /**
     * Check whether a string is a key
     *
     * @param key String
     * @return true means yes
     */
    public static boolean isKey(String key) {
        return key.matches("[a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+");
    }

    /**
     * Check whether a string is a key of an item
     *
     * @param key String
     * @return true means yes
     */
    public static boolean isItemKey(String key) {
        return key.matches("item\\.[a-zA-Z0-9_]+\\.[a-zA-Z0-9_]+");
    }

    /**
     * Translate a string to an Identifier
     *
     * @param key String
     * @return Identifier
     * @throws NotKeyException The string is not a key
     */
    public static Identifier keyToId(String key) throws NotKeyException {
        if (!isKey(key)) {
            throw new NotKeyException(key);
        }
        String[] splitKey = key.split("\\.", 3);
        return new Identifier(splitKey[1], splitKey[2]);
    }

    /**
     * Translate a string to an Identifier
     *
     * @param key String
     * @return Identifier
     * @throws NotKeyException     The string is not a key
     * @throws KeyNotItemException The string is not a key of an item
     */
    public static Identifier keyToItemId(String key) throws NotKeyException, KeyNotItemException {
        if (!isKey(key)) {
            throw new NotKeyException(key);
        }
        if (!isItemKey(key)) {
            throw new KeyNotItemException(key);
        }
        return keyToId(key);
    }
}
