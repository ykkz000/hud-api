package llj2003.hudapi.gui.widget;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.Iterator;

/**
 * Basic interface for containers
 *
 * @author llj2003
 * @param <T> Type of the objects contained
 */
@Environment(EnvType.CLIENT)
public interface Container<T> {
    /**
     * Add Object to the container
     *
     * @param t Object
     */
    void add(T t);

    /**
     * Return size of the container
     *
     * @return Size of the container
     */
    int size();

    /**
     * Get specific Object
     *
     * @param i Index
     * @return Object
     */
    T get(int i);

    /**
     * Remove specific Object
     *
     * @param i Index
     */
    void remove(int i);

    /**
     * Remove specific Object
     *
     * @param t Object
     */
    void remove(T t);

    /**
     * Get iterator
     *
     * @return Iterator
     */
    Iterator<T> iterator();
}
