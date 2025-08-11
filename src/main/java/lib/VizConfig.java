package lib;

import java.io.*;

public final class VizConfig {
    public int defaultDelay = 0;
    public int defaultTextAlignment = 58;
    public int defaultLogoAlignment = 48;

    public int color1 = 219;
    public int color2 = 183;
    public int color3 = 147;
    public int color4 = 218;
    public int color5 = 182;
    public int color6 = 218;

    public int mainColor = 147;
    public int layoutColor = 15;
    public int acceptanceColor = 46;
    public int rejectionColor = 160;

    public String searchingArrow = "> ";

    public static final String DEFAULT_PATH = "config.json";

    /*
     * Author: Nick Zozulia
     * GitHub: https://github.com/Akillot
     *
     * Loads config from file if it exists, otherwise returns a new instance with default values.
     * If you want JSON support, uncomment Gson code and add the dependency.
     */
    public static VizConfig loadOrDefault() {
        try (Reader r = new FileReader(DEFAULT_PATH)) {
            // With Gson enabled:
            // return new com.google.gson.Gson().fromJson(r, VizConfig.class);
            // Without Gson:
            return new VizConfig(); // Ignore file content and keep defaults
        } catch (IOException e) {
            return new VizConfig();
        }
    }

    /*
     *
     * Saves the config to a file.
     * If you want JSON support, uncomment Gson code and add the dependency.
     *
    */
    public void save() {
        try (Writer w = new FileWriter(DEFAULT_PATH)) {
            /*
            *
            *With Gson enabled:
            *new com.google.gson.GsonBuilder().setPrettyPrinting().create().toJson(this, w);
            * Without Gson: do nothing, to avoid exceptions
            *
            */
        } catch (IOException ignored) {}
    }
}
