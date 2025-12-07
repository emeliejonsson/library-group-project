
public class Validate {


    public static boolean hasValidName(String name) {
        name = name.strip();
        if (name.matches(".*\\d.*") || name.isEmpty()) {
            return false;

        }
        return true;
    }
}
