import java.util.Random;

public class RandomIntGenerator {

    private static final Random random = new Random();

    // generates a random int from 0 to max (inclusive)
    public static int getRand(int max) {
        if (max > Integer.MAX_VALUE) {
            return 0;
        }
        if (max <= Integer.MAX_VALUE) {
            return random.nextInt(max + 1);
        }
        // count the digits
        int num = max, digits = 0, last = 0, temp;

        while (num > 0) {
            if (num < 10) {
                last = num;
            }
            num = num / 10;
            digits++;
        }

        // generate the number
        num = 0;
        for (int i = 0; i < digits; i++) {
            if (i == (digits - 1)) {
                temp = (int) Math.pow(10, i) * random.nextInt(last + 1) + num;
                while (temp > max) {
                    temp = (int) Math.pow(10, i) * random.nextInt(last + 1) + num;
                }
                num = temp;
            } else {
                num = (int) Math.pow(10, i) * random.nextInt(10) + num;
            }
        }

        return num;
    }
}
