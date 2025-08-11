package lib;

import java.util.function.Consumer;

import static lib.VizAppearance.*;

public final class VizText {
    private VizText() {}

    private static VizConfig cfg = new VizConfig();

    public static void setConfig(VizConfig c) { cfg = c != null ? c : new VizConfig(); }
    public static VizConfig getConfig() { return cfg; }

    public static String alignment(int widthOfElement) {
        int fullWidth = DEFAULT_BORDER_WIDTH + 2;
        int oneSide = (fullWidth - widthOfElement) / 2;
        return " ".repeat(Math.max(0, oneSide));
    }

    public static String capitalizeMessage(String input) {
        if (input == null || input.isEmpty()) return input;
        return input.substring(0,1).toUpperCase() + input.substring(1).toLowerCase();
    }

    public static void slowMotionText(int delay, int alignment, boolean isUnderlineActive,
                                      String mainText, String additionalText) {
        String formatted = alignment(alignment)
                + (isUnderlineActive ? UNDERLINE : "")
                + mainText + RESET + additionalText;

        for (char ch : formatted.toCharArray()) {
            System.out.print(ch);
            if (delay > 0) {
                try { Thread.sleep(delay); } catch (InterruptedException ignored) {
                    message("Error, try again", cfg.rejectionColor, cfg.defaultTextAlignment,
                            cfg.defaultDelay, System.out::println);
                    break;
                }
            }
        }
        System.out.print("");
    }

    public static void message(String text, int color,
                               int alignment, int delay, Consumer<String> printMethod) {
        String colored = getColorText(text, color);
        String aligned = alignment(alignment) + colored;

        StringBuilder sb = new StringBuilder();
        for (char ch : aligned.toCharArray()) {
            sb.append(ch);
            if (delay > 0) {
                try { Thread.sleep(delay); } catch (InterruptedException ignored) { return; }
            }
        }
        printMethod.accept(sb.toString());
        insertControlChars('n', 1);
    }

    public static void insertControlChars(char modifier, int amount) {
        if (amount < 0) {
            message("Error, number of modifiers is less than 0.",
                    getConfig().layoutColor, getConfig().defaultTextAlignment,
                    getConfig().defaultDelay, System.out::println);
            return;
        }
        String out = switch (modifier) {
            case 'n' -> "\n";
            case 't' -> "\t";
            case 'b' -> "\b";
            case 'r' -> "\r";
            case '\\' -> "\\";
            default -> "\\" + modifier;
        };
        for (int i = 0; i < amount; i++) System.out.print(out);
    }
}
