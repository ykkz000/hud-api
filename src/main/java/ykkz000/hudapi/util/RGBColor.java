package ykkz000.hudapi.util;

import lombok.Data;

/**
 * RGBColor Util
 *
 * @author ykkz000
 */
@SuppressWarnings("unused")
@Data
public class RGBColor {
    private final int red;
    private final int green;
    private final int blue;
    private final int alpha;

    /**
     * Create {@link RGBColor} with specified RGBA
     *
     * @param red   Red value
     * @param green Green value
     * @param blue  Blue value
     * @param alpha Alpha value
     */
    private RGBColor(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    /**
     * Translate to an integer which describes RGB
     *
     * @return the integer which describes RGB
     */
    public int toRGBA() {
        return blue + (this.green << 8) + (this.red << 16) + (this.alpha << 24);
    }

    /**
     * From integer which describes RGB
     *
     * @param rgba the integer which describes RGB
     * @return {@link RGBColor}
     */
    public static RGBColor fromRGBA(int rgba) {
        int blue = rgba & 0xFF;
        int green = (rgba >> 8) & 0xFF;
        int red = (rgba >> 16) & 0xFF;
        int alpha = (rgba >> 24) & 0xFF;
        return RGBColor.of(red, green, blue, alpha);
    }

    /**
     * Get color instance
     *
     * @param red   Red value
     * @param green Green value
     * @param blue  Blue value
     * @return {@link RGBColor} instance
     */
    public static RGBColor of(float red, float green, float blue) {
        return RGBColor.of((int) (red * 255), (int) (green * 255), (int) (blue * 255));
    }

    /**
     * Get color instance
     *
     * @param red   Red value
     * @param green Green value
     * @param blue  Blue value
     * @param alpha Alpha value
     * @return {@link RGBColor} instance
     */
    public static RGBColor of(float red, float green, float blue, float alpha) {
        return RGBColor.of((int) (red * 255), (int) (green * 255), (int) (blue * 255), (int) (alpha * 255));
    }

    /**
     * Get color instance
     *
     * @param red   Red value
     * @param green Green value
     * @param blue  Blue value
     * @return {@link RGBColor} instance
     */
    public static RGBColor of(int red, int green, int blue) {
        return RGBColor.of(red, green, blue, 255);
    }

    /**
     * Get color instance
     *
     * @param red   Red value
     * @param green Green value
     * @param blue  Blue value
     * @param alpha Alpha value
     * @return {@link RGBColor} instance
     */
    public static RGBColor of(int red, int green, int blue, int alpha) {
        return new RGBColor(red, green, blue, alpha);
    }
}
