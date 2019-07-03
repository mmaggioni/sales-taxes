package utils;

import java.math.BigDecimal;

public class Utils {

    public static BigDecimal roundToTheNearest5Cent(BigDecimal num) {
        BigDecimal divided = num.divide(BigDecimal.valueOf(0.05), 0, BigDecimal.ROUND_UP);
        return divided.multiply(BigDecimal.valueOf(0.05));
    }
}
