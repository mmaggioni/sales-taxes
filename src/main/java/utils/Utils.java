package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Utils {

    public static BigDecimal roundToTheNearest5Cent(BigDecimal num) {

        // todo
        // 2.101 should be considered 2.10 or 2.11?
        // i decided to round it to 2.10, otherwise the result will be 2.15
        num = num.setScale(2, RoundingMode.HALF_UP);

        BigDecimal divided = num.divide(BigDecimal.valueOf(0.05), 0, BigDecimal.ROUND_UP);
        return divided.multiply(BigDecimal.valueOf(0.05));
    }
}
