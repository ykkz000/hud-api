package llj2003.hudapi.gui;

/**
 * Color
 *
 * @author llj2003
 */
public class Color {
    private float red;
    private float green;
    private float blue;
    private float alpha;

    /**
     * Initialize
     *
     * @param red   Red value 0~255
     * @param green Green value 0~255
     * @param blue  Blue value 0~255
     * @param alpha Alpha value 0~255
     */
    public Color(int red, int green, int blue, int alpha) {
        this((float) red / 255.0F,
                (float) green / 255.0F,
                (float) blue / 255.0F,
                (float) alpha / 255.0F);
    }

    /**
     * Initialize
     *
     * @param red   Red 0~1
     * @param green Green 0~1
     * @param blue  Blue 0~1
     * @param alpha Alpha 0~1
     */
    public Color(float red, float green, float blue, float alpha) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        setAlpha(alpha);
    }

    /**
     * Get red
     *
     * @return Red
     */
    public float getRed() {
        return red;
    }

    /**
     * Set red
     *
     * @param red Red
     */
    private void setRed(float red) {
        this.red = Math.min(Math.max(red, 0.0F), 1.0F);
    }

    /**
     * Get green
     *
     * @return Green
     */
    public float getGreen() {
        return green;
    }

    /**
     * Set green
     *
     * @param green Green
     */
    private void setGreen(float green) {
        this.green = Math.min(Math.max(green, 0.0F), 1.0F);
    }

    /**
     * Get blue
     *
     * @return Blue
     */
    public float getBlue() {
        return blue;
    }

    /**
     * Set blue
     *
     * @param blue Blue
     */
    private void setBlue(float blue) {
        this.blue = Math.min(Math.max(blue, 0.0F), 1.0F);
    }

    /**
     * Get alpha
     *
     * @return Alpha
     */
    public float getAlpha() {
        return alpha;
    }

    /**
     * Set alpha
     *
     * @param alpha Alpha
     */
    public void setAlpha(float alpha) {
        this.alpha = Math.min(Math.max(alpha, 0.0F), 1.0F);
    }

    /**
     * To integer
     *
     * @return integer
     */
    public int toInt() {
        return ((int) (this.blue * 0xFF)) +
                (((int) (this.green * 0xFF)) << 8) +
                (((int) (this.red * 0xFF)) << 16) +
                (((int) (this.alpha * 0xFF)) << 24);
    }

    /**
     * From integer
     *
     * @param color integer
     * @return Color
     */
    public static Color fromInt(int color) {
        int blue = color & 0xFF;
        int green = (color >> 8) & 0xFF;
        int red = (color >> 16) & 0xFF;
        int alpha = (color >> 24) & 0xFF;
        return new Color(red, green, blue, alpha);
    }
}
