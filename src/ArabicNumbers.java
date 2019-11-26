import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ArabicNumbers implements Calculator {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    public void calc() {
        System.out.println("Please insert the operation: ");
        int sum = 0;

        try {
            for (String s : reader.readLine().split(" ")) {
                if (Character.isDigit(s.charAt(0)))
                    sum = sum + Integer.parseInt(s);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        System.out.println(sum);

    }
}
