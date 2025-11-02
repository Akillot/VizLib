package lib;

import static lib.VizAppearance.*;
import static lib.VizText.*;

public final class VizDisplay {
    private VizDisplay() {}

    private static VizConfig cfg = new VizConfig();

    public static void setConfig(VizConfig c) {
        cfg = c != null ? c : new VizConfig();
        VizText.setConfig(cfg);
    }

    public static VizConfig getConfig() { return cfg; }

    public static void displayLogo(int alignment, String[] logo) {
        String[] colors = getColorsForLogo();
        for (int i = 0; i < logo.length; i++) {
            String colored = colors[i % colors.length] + logo[i] + RESET;
            message(colored, cfg.layoutColor, alignment, cfg.defaultDelay, System.out::print);
        }
    }

    public static void clearTerminal() {
        try {
            String os = System.getProperty("os.name");
            if (os != null && os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            message("Error executing action", cfg.rejectionColor, cfg.defaultTextAlignment, cfg.defaultDelay, System.out::print);
            message("Status: " + getColor(cfg.rejectionColor) + "x",
                    cfg.layoutColor, cfg.defaultTextAlignment, cfg.defaultDelay, System.out::print);
        }
    }

    private static String[] getColorsForLogo() {
        return new String[]{
                getColor(cfg.color1), getColor(cfg.color2),
                getColor(cfg.color3), getColor(cfg.color4),
                getColor(cfg.color5), getColor(cfg.color6)
        };
    }
}
