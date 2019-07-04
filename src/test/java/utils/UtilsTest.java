package utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void roundToTheNearest5Cent() {

        BigDecimal num = BigDecimal.valueOf(12.47);
        assert Utils.roundToTheNearest5Cent(num).compareTo(BigDecimal.valueOf(12.50)) == 0;


        num = BigDecimal.valueOf(01.04);
        assert Utils.roundToTheNearest5Cent(num).compareTo(BigDecimal.valueOf(01.05)) == 0;

        num = BigDecimal.valueOf(2.101);
        assert Utils.roundToTheNearest5Cent(num).compareTo(BigDecimal.valueOf(2.10)) == 0;

        num = BigDecimal.valueOf(2.11);
        assert Utils.roundToTheNearest5Cent(num).compareTo(BigDecimal.valueOf(2.15)) == 0;

    }
}