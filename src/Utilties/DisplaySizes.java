package Utilties;

/**
 * Created by dontf on 6/24/2018.
 */
public class DisplaySizes {

    private static final float imageHeight = 0.25f;
    private static final float imageWidth = 0.4f;


    public static int getProportionalImageHeight (javafx.stage.Window window) {
        return (int) (window.getHeight() * imageHeight);
    }

    public static int getProportionalImageWidth (javafx.stage.Window window) {
        return (int) (window.getWidth() * imageWidth);
    }
}
