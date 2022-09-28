import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static boolean IsOdd(Integer[] line) {
        for (var x : line) {
            if (x % 2 == 0) {
                return false;
            }
        }
        return true;
    }
    private static int SumOfAbsElements(Integer[] arr) {
        int sumOfAbsElements = 0;
        for (var x : arr) {
            sumOfAbsElements += Math.abs(x);
        }
        return sumOfAbsElements;
    }

    public static Integer[] FindLine(Integer[][] matrix) {
        int sumOfAbsElements = 0;
        Integer[] line = null;
        for (int i = 0; i < matrix.length; i++) {
            if (IsOdd(matrix[i]) && SumOfAbsElements(matrix[i]) >= sumOfAbsElements) {
                sumOfAbsElements = SumOfAbsElements(matrix[i]);
                line = matrix[i];
            }
        }
        return line;
    }

    public static void main(String[] args) {
        String fileName = "input.txt";
        File file = new File(fileName);
        try (Scanner sc = new Scanner(file)) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            Integer[][] matrix = new Integer[height][width];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            var line = FindLine(matrix);
            if (line != null) {
                for (var x : line) {
                    System.out.print(x + " ");
                }
            }
            else {
                System.out.println("Нет такой строки!");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}