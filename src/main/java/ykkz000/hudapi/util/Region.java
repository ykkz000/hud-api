package ykkz000.hudapi.util;

/**
 * Describe a region
 *
 * @author ykkz000
 */
public class Region {
    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Initialize the region
     *
     * @param x      X coordinate of top-left
     * @param y      Y coordinate of top-left
     * @param width  Width of the widget
     * @param height Height of the widget
     */
    public Region(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Get X coordinate of top-left
     *
     * @return X coordinate of top-left
     */
    public int getX() {
        return x;
    }

    /**
     * Set X coordinate of top-left
     *
     * @param x X coordinate of top-left
     * @return This
     */
    public Region setX(int x) {
        this.x = x;
        return this;
    }

    /**
     * Get Y coordinate of top-left
     *
     * @return Y coordinate of top-left
     */
    public int getY() {
        return y;
    }

    /**
     * Set Y coordinate of top-left
     *
     * @param y Y coordinate of top-left
     * @return This
     */
    public Region setY(int y) {
        this.y = y;
        return this;
    }

    /**
     * Get width of the widget
     *
     * @return Width of the widget
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set width of the widget
     *
     * @param width Width of the widget
     * @return This
     */
    public Region setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * Get height of the widget
     *
     * @return Height of the widget
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set height of the widget
     *
     * @param height Height of the widget
     * @return This
     */
    public Region setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * Translate to Dimension
     *
     * @return Dimension
     */
    public Dimension toDimension() {
        return new Dimension(width, height);
    }

    /**
     * Copy to a new Region
     *
     * @return New Region with the same attributes
     */
    public Region copy() {
        return new Region(x, y, width, height);
    }
}
