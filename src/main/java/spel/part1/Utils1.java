package spel.part1;

/**
 * Created by tomasz on 26.10.14.
 */
public class Utils1 {

    public static String reverseString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            result.append(s.charAt(i));
        }
        return result.toString();
    }
}
