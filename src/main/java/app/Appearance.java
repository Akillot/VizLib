package app;

import java.util.Random;

public class Appearance {

    /*
    *
    * Work with ANSI Colors
    *
    */

    public static final String RESET = "\033[0m";
    public static final String UNDERLINE = "\033[4m";

    public static String getColorText(String text, int color) {
        if (color < 0 || color > 255) throw new IllegalArgumentException("Color code must be between 0 and 255");
        return getColor(color) + text + RESET;
    }

    public static String getColor(int colorCode) {return "\033[38;5;" + colorCode + "m";}
    public static String getBackColor(int colorCode) {return "\033[48;5;" + colorCode + "m";}

    public static String getRandomColor() {
        Random rand = new Random();
        int colorCode = rand.nextInt(256);
        return getColor(colorCode);
    }

    public static String getRangedRandomBackColor(int origin, int bound) {
        Random rand = new Random();
        int colorCode = 0;
        if (origin < bound && bound <= 256 && bound >= 0 && origin > 0) colorCode = rand.nextInt(origin, bound);
        return getBackColor(colorCode);
    }

    public static String getRangedRandomColor(int origin, int bound) {
        Random rand = new Random();
        int colorCode = 0;
        if (origin < bound && bound <= 256 && bound >= 0 && origin > 0) colorCode = rand.nextInt(origin, bound);
        return getColor(colorCode);
    }

    public static String getRandomBackColor() {
        Random rand = new Random();
        int colorCode = rand.nextInt(256);
        return getBackColor(colorCode);
    }
}