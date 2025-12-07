
import java.util.Random;

public class IdGenerator {

    public static String generateID() {
        int length = 10;
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        int slump;
        for (int i = 0; i < length; i++) {
            slump = random.nextInt(10);
            sb.append(slump);
        }
        return sb.toString();
    }
}
