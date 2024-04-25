package soft.pegas.vocabularychieftain.common.utils;

public class StringUtils {
    
    public static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
