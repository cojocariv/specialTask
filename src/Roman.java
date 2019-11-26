import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Roman implements Calculator{


    public static int romanToArabic(String nm) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = {1000, 500, 100, 50, 10, 5, 1};
        String symbols = "MDCLXVI";

        String roman = null;

        roman = nm;

        roman = roman.toUpperCase();

        if (roman.matches(".*[0-9].*") || !roman.matches("[M|D|C|L|X|V|I]*")) {
            System.out.println("Impossible to convert. Wrong roman numeral");
        }

        int i = 0;

        int current = 0;
        int previous = 0;
        int arabic = 0;

        while (i < roman.length()) {

            char letter = roman.charAt(i);

            switch (letter) {
                case ('I'):
                    current = 1;
                    break;
                case ('V'):
                    current = 5;
                    break;
                case ('X'):
                    current = 10;
                    break;
                case ('L'):
                    current = 50;
                    break;
                case ('C'):
                    current = 100;
                    break;
                case ('D'):
                    current = 500;
                    break;
                case ('M'):
                    current = 1000;
                    break;
            }

            if (current > previous) {

                arabic += current - (previous * 2);
            } else {

                arabic += current;
            }

            previous = current;

            i += 1;

        }
        return arabic;

        /*

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

        */
    }


    @Override
    public void calc() {
        System.out.println("Please insert the operation: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        try {
            for (String s:reader.readLine().split(" ")){
//                int temp = romanToArabic(s);
                if (Character.isDigit(s.charAt(0)))
                    sum = sum + Integer.parseInt(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(RomanNumber.toRoman(sum));

    }
}