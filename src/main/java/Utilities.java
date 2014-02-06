/**
 * Created by john on 06/02/14.
 */
public class Utilities {
    public static String getFilenameWithoutExtention(String filename) {
        return filename.split("\\.[^\\.]+$")[0];
    }
}
