import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the string with numbers: ");

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println("Sum of numbers using try/catch: " + SumOfString.GetSumOfNumbers(str));
        System.out.println("Sum of numbers using regex: " + SumOfString.GetSumOfNumbersRegEx(str));
    }
}
