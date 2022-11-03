import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    @ArgumentsSource(ArgumentProviderForSumOfRow.class)
    public void SumOfRow_ValidParameters_ReturnsRightResult(ArgumentProviderForSumOfRow.Argument argument) {
        // Arrange
        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(argument.precision);
        var expectedValue = new BigDecimal(Math.sqrt(1 + argument.argument));
        var expectedRoundedValue = expectedValue.setScale(argument.precision, RoundingMode.DOWN);

        // Act
        var resultValue = new BigDecimal(SumOfRow.GetSumOfRow(argument.argument, argument.precision));
        var resultRoundedValue = resultValue.setScale(argument.precision, RoundingMode.DOWN);

        // Assert
        Assertions.assertEquals(expectedRoundedValue, resultRoundedValue);
    }
}