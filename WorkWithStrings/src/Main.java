import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void ChangeWordsInWithLength(Scanner in, int length, String replaceString, String nameOfOutputFile)  {
        in.reset();
        try (FileWriter fileWriter = new FileWriter(nameOfOutputFile)) {
            String line = in.nextLine();
            while (line != "") {
                StringBuilder stringBuilder = new StringBuilder();
                StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
                while (stringTokenizer.hasMoreTokens()) {
                    String token = stringTokenizer.nextToken();
                    if (token.length() == length) {
                        stringBuilder.append(replaceString).append(" ");
                    }
                    else if (token.length() == length + 1 && token.endsWith(".")){
                        stringBuilder.append(replaceString).append(".");
                    }
                    else if (token.length() == length + 1 && token.endsWith(",")){
                        stringBuilder.append(replaceString).append(",");
                    }
                    else {
                        stringBuilder.append(token).append(" ");
                    }
                }
                line = in.nextLine();
                fileWriter.write(stringBuilder.toString());
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String fileNameOutput = "output.txt";

        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку-замену: ");
        String replaceString = in.nextLine();
        System.out.print("Введите длину строки, которые нужно заменить: ");
        int length = in.nextInt();
        in.nextLine();
        System.out.println("Введите текст (признак конца текста - пустая строка)");
        ChangeWordsInWithLength(in, length, replaceString, fileNameOutput);
    }
}