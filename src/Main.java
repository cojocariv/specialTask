import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Choose arabic or roman calculator: ");

        String s = reader.readLine();
        Calculator calculator;
        Roman roman;
        if (s.equalsIgnoreCase("arabic")) {
            calculator = new ArabicNumbers();
            calculator.calc();
        } else if (s.equalsIgnoreCase("roman")) {
            roman = new Roman();
            roman.calc();
        }
    }
}
