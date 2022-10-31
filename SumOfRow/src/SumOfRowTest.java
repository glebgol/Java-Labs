import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.NumberFormat;

class SumOfRowTest {

    @ParameterizedTest
    @ValueSource(doubles = { -1, 1, Double.MAX_VALUE, -Double.MAX_VALUE})
    public void SumOfRow_IllegalArgument_ThrowsIllegalArgumentException(double number) {
        int precision = 1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> SumOfRow.GetSumOfRow(number, precision));
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0})
    public void SumOfRow_IllegalPrecision_ThrowsIllegalArgumentException(int precision) {
        double number = 0.5;
        Assertions.assertThrows(IllegalArgumentException.class, () -> SumOfRow.GetSumOfRow(number, precision));
    }

    @ParameterizedTest
    @ValueSource(doubles = { -0.5, 0.5, 0.3, -0.2, 0.75, 0.8})
    public void SumOfRow_ValidParameters_ReturnsRightResult(double number) {
        // Arrange
        int precision = 4;
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(precision);
        double expectedValue = Math.sqrt(1 + number);
        var expectedFormattedString = formatter.format(expectedValue);

        // Act
        double result = SumOfRow.GetSumOfRow(number, precision);
        var resultFormattedString = formatter.format(result);

        // Assert
        Assertions.assertEquals(resultFormattedString, expectedFormattedString);
    }
}