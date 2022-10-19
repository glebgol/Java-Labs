import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static String GetJavaFileWithoutComments(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        StringBuilder fileString = new StringBuilder();
        while (sc.hasNext()) {
            fileString.append(sc.nextLine()).append('\n');
        }
        StringBuilder resultFile = new StringBuilder();
        var charArray = fileString.toString().toCharArray();

        StringCondition condition = StringCondition.Start;
        for (char c : charArray) {
            switch (condition) {
                case Start:
                    if(c == '"'){
                        resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    else if (c == '/'){
                        condition = StringCondition.CommentBegin;
                    }
                    else {
                        resultFile.append(c);
                        condition = StringCondition.Start;
                    }
                    break;
                case StringBody:
                    if(c == '"'){
                        resultFile.append(c);
                        condition = StringCondition.StringEnd;
                    }
                    else if(c == '\\'){
                        resultFile.append(c);
                        condition = StringCondition.SpecSymbol;
                    }
                    else {
                        resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    break;
                case SpecSymbol:
                    resultFile.append(c);
                    condition = StringCondition.StringBody;
                    break;
                case StringEnd:
                    if(c == '"'){
                        resultFile.append(c);
                        condition = StringCondition.StringBody;
                    }
                    else {
                        resultFile.append(c);
                        condition = StringCondition.Start;
                    }
                    break;
                case CommentBegin:
                    if (c == '/') {
                        condition = StringCondition.CommentEnd;
                    }
                    else if (c == '*') {
                        condition = StringCondition.CommentLines;
                    }
                    break;
                case CommentToEnd:
                    if (c == '\n') {
                        resultFile.append(c);
                        condition = StringCondition.Start;
                    }
                    else {
                        condition = StringCondition.CommentToEnd;
                    }
                case CommentLines:
                    if (c == '*') {
                        condition = StringCondition.CommentEnd;
                    }
                    else {
                        condition = StringCondition.CommentLines;
                    }
                    break;
                case CommentEnd:
                    if (c == '\n') {
                        condition = StringCondition.Start;
                    }
                    else {
                        condition = StringCondition.CommentEnd;
                    }
                    break;
            }
        }
        return resultFile.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(GetJavaFileWithoutComments("file.txt"));
        }
        catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}