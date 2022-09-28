import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static double GetSumOfRow(double x, int k) {
        if (x >= 1 || x <= -1) {
            throw new IllegalArgumentException("Argument x should be in (-1, 1)!");
        }
        else if (k <= 0) {
            throw new IllegalArgumentException("Argument k should be natural number!");
        }
        double e = Math.pow(10, -(k + 1));
        double sum = 1;
        double element = 0.5 * x;
        int r = 1;
        while (true) {
            sum += element;
            element = -1 * element * x * (double) r / (r + 3);
            r += 2;
            if (Math.abs(element) < e) {
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";

        NumberFormat formatter = NumberFormat.getNumberInstance();
        formatter.setMaximumFractionDigits(5);

        while (true) {
            try {
                System.out.println("Enter the number int (-1, 1): ");
                str = in.next();
                double num = Double.parseDouble(str);

                System.out.println("Введите точность: ");
                str = in.next();
                int k = Integer.parseInt(str);

                System.out.println(formatter.format(GetSumOfRow(num, k)));
                System.out.println(formatter.format(Math.sqrt(1 + num)));
            } catch (NumberFormatException ex) {
                System.out.println(str + " is not a number!");
                return;
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
    }
}