import org.junit.jupiter.api.function.Executable;

public class SumOfRow {
    public static double GetSumOfRow(double x, int k) {
        if (x >= 1 || x <= -1) {
            throw new IllegalArgumentException("Argument x should be in (-1, 1)!");
        }
        else if (k <= 0) {
            throw new IllegalArgumentException("Argument k should be natural number!");
        }
        double e = Math.pow(10, -(k + 2));
        double sum = 1;
        double element = 0.5 * x;
        int r = 1;
        while (true) {
            sum += element;
            element = -1 * element * x * (double) r / (r + 3);
            r += 2;
            if (Math.abs(element) <= e) {
                break;
            }
        }
        return sum;
    }
}
