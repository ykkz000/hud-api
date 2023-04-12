package ykkz000.hudapi.gui;

import ykkz000.hudapi.util.Dimension;
import ykkz000.hudapi.util.Region;
import ykkz000.hudapi.util.Texture;
import net.minecraft.util.Identifier;

public class DefaultTextures {
    public static Texture BAR_TEXTURES = new Texture(
            new Identifier("textures/gui/bars.png"),
            new Dimension(256, 256));

    public static Region[] BAR_REGION = new Region[] {
            new Region(0, 0, 182, 5),
            new Region(0, 5, 182, 5),
            new Region(0, 10, 182, 5),
            new Region(0, 15, 182, 5),
            new Region(0, 20, 182, 5),
            new Region(0, 25, 182, 5),
            new Region(0, 30, 182, 5),
            new Region(0, 35, 182, 5),
            new Region(0, 40, 182, 5),
            new Region(0, 45, 182, 5),
            new Region(0, 50, 182, 5),
            new Region(0, 55, 182, 5),
            new Region(0, 60, 182, 5),
            new Region(0, 65, 182, 5),
    };
}
