import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class SumOfRowTest {

    @ParameterizedTest
    @ValueSource(doubles = { -1, 1, Double.MAX_VALUE, -Double.MAX_VALUE})
    public void SumOfRow_IllegalArgument_ThrowsIllegalArgumentException(double number) {
        int precision = 1;
        assertThrows(IllegalArgumentException.class, () -> SumOfRow.GetSumOfRow(number, precision));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0})
    public void SumOfRow_IllegalPrecision_ThrowsIllegalArgumentException(int precision) {
        double number = 0.5;
        assertThrows(IllegalArgumentException.class, () -> SumOfRow.GetSumOfRow(number, precision));
    }
}