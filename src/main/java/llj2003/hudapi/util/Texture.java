package llj2003.hudapi.util;

import llj2003.hudapi.exception.KeyNotItemException;
import llj2003.hudapi.exception.NotKeyException;
import net.minecraft.util.Identifier;

/**
 * Describe id and region of a texture
 *
 * @author llj2003
 */
public class Texture {
    private Identifier id;
    private Dimension size;

    /**
     * Initialize
     *
     * @param id   Id
     * @param size Dimension of the texture
     */
    public Texture(Identifier id, Dimension size) {
        this.id = id;
        this.size = size;
    }

    /**
     * Get texture id
     *
     * @return Texture id
     */
    public Identifier getId() {
        return id;
    }

    /**
     * Set texture id
     *
     * @param id Texture id
     * @return This
     */
    public Texture setId(Identifier id) {
        this.id = id;
        return this;
    }

    /**
     * Get texture size
     *
     * @return Size
     */
    public Dimension getSize() {
        return size;
    }

    /**
     * Set texture size
     *
     * @param size Size
     * @return This
     */
    public Texture setSize(Dimension size) {
        this.size = size;
        return this;
    }

    /**
     * Create Texture from Item
     *
     * @param key Item key
     * @return Texture
     * @throws NotKeyException     key not a key
     * @throws KeyNotItemException key not an item
     */
    public static Texture fromItem(String key) throws NotKeyException, KeyNotItemException {
        return fromItem(key, new Dimension(16, 16));
    }

    /**
     * Create Texture from Item
     *
     * @param key  Item key
     * @param size Texture size
     * @return Texture
     * @throws NotKeyException     key not a key
     * @throws KeyNotItemException key not an item
     */
    public static Texture fromItem(String key, Dimension size) throws NotKeyException, KeyNotItemException {
        return new Texture(KeyTranslator.keyToItemTextureId(key), size);
    }
}
