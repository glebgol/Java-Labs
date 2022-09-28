import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static int CountOfColumnFromDifferentNumbers(Integer[][] matrix) {
        HashSet<Integer> numbersOfColumn = new HashSet<>();
        int height = matrix.length;
        int count = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                numbersOfColumn.add(matrix[j][i]);
            }
            if (numbersOfColumn.size() == height) {
                count++;
            }
            numbersOfColumn.clear();
        }
        return count;
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
            System.out.print("Количество столбцов заданной матрицы, которые составлены из попарно различных чисел: ");
            System.out.println(CountOfColumnFromDifferentNumbers(matrix));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}