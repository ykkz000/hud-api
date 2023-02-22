package llj2003.hudapi.util;

public class Dimension {
    private int width;
    private int height;

    /**
     * Initialization
     *
     * @param width Width
     * @param height Height
     */
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Get Width
     *
     * @return Width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Set Width
     *
     * @param width Width
     * @return This
     */
    public Dimension setWidth(int width) {
        this.width = width;
        return this;
    }

    /**
     * Get height
     * @return Height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set height
     *
     * @param height Height
     * @return This
     */
    public Dimension setHeight(int height) {
        this.height = height;
        return this;
    }

    /**
     * Translate to Region
     *
     * @return Region
     */
    public Region toRegion() {
        return new Region(0, 0, width, height);
    }

    /**
     * Copy to a new Dimension
     *
     * @return New Dimension with the same attributes
     */
    public Dimension copy() {
        return new Dimension(width, height);
    }
}
