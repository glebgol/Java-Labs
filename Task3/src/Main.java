import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int FindMax(Integer[] arr) {
        Integer max = Integer.MIN_VALUE;
        for (var x : arr) {
            if (x >= max) {
                max = x;
            }
        }
        return max;
    }
    public static void SortByMaxInLines(Integer[][] matrix) {
        Arrays.sort(matrix, (a, b) -> {
            return Integer.compare(FindMax(a), FindMax(b));
        });
    }
    public static void main(String[] args) {
        String fileName = "input.txt";
        String output = "output.txt";
        File file = new File(fileName);
        File file2 = new File(output);

        try (Scanner sc = new Scanner(file)) {
            int height = sc.nextInt();
            int width = sc.nextInt();
            Integer[][] matrix = new Integer[height][width];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            SortByMaxInLines(matrix);

            try (FileWriter fw = new FileWriter(output)) {
                for (Integer[] integers : matrix) {
                    for (Integer integer : integers) {
                        fw.write(integer + " ");
                    }
                    fw.write("\n");
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}