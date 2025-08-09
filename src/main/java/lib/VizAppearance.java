package lib;

import java.util.Random;

public final class VizAppearance {
    private VizAppearance() {}

    public static final String RESET = "\033[0m";
    public static final String UNDERLINE = "\033[4m";

    public static final int DEFAULT_BORDER_WIDTH = 62;

    public static String getColorText(String text, int color) {
        if (color < 0 || color > 255)
            throw new IllegalArgumentException("Color code must be between 0 and 255");
        return getColor(color) + text + RESET;
    }

    public static String getColor(int code) { return "\033[38;5;" + code + "m"; }
    public static String getBackColor(int code) { return "\033[48;5;" + code + "m"; }

    public static String getRandomColor() {
        return getColor(new Random().nextInt(256));
    }

    public static String getRandomBackColor() {
        return getBackColor(new Random().nextInt(256));
    }

    public static String getRangedRandomColor(int origin, int bound) {
        int code = 0;
        if (origin < bound && bound <= 256 && bound >= 0 && origin > 0)
            code = new Random().nextInt(origin, bound);
        return getColor(code);
    }

    public static String getRangedRandomBackColor(int origin, int bound) {
        int code = 0;
        if (origin < bound && bound <= 256 && bound >= 0 && origin > 0)
            code = new Random().nextInt(origin, bound);
        return getBackColor(code);
    }
}
