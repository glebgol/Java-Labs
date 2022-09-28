import java.util.StringTokenizer;

public class SumOfString {
    public static double GetSumOfNumbers(String line) {
        StringTokenizer st = new StringTokenizer(line, " \t\n\r,");
        double sum = 0;
        while(st.hasMoreTokens()){
            double num = 0;
            try {
                num = Double.parseDouble(st.nextToken());
                sum += num;
            } catch (NumberFormatException ignored) {}
        }
        return sum;
    }
    public static double GetSumOfNumbersRegEx(String line) {
        StringTokenizer st = new StringTokenizer(line, " \t\n\r,");
        double sum = 0;
        while(st.hasMoreTokens()){
            String el = st.nextToken();
            if (el.matches("(^-|^\\+)?[0-9]+((\\.)?[0-9]*(e[0-9]+)?)?$")) {
                double num = Double.parseDouble(el);
                sum += num;
            }
        }
        return sum;
    }
}
