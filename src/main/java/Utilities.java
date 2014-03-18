/**
 * Created by john on 06/02/14.
 * Utility methods that do not fit cleanly into existing classes.
 */
public class Utilities {
    /**
     * Method to get the full name of a file (path included) without its extension.
     * @param filename the full file name e.g /var/etc/a.txt or C:/kebabs.bsh.
     * @return the full name minus the extension.
     */
    public static String getFilenameWithoutExtention(String filename) {
        return filename.split("\\.[^\\.]+$")[0];
    }

}
