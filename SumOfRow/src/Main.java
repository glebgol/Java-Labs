import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
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

                System.out.println(formatter.format(SumOfRow.GetSumOfRow(num, k)));
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