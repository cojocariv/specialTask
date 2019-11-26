import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Roman implements Calculator{


    public static int romanToArabic(String nm) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = {1000, 500, 100, 50, 10, 5, 1};
        String symbols = "MDCLXVI";


        final int MAX = 3999;
        String roman = null;
//        try {
        roman = nm;
//            roman = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            reader.close(); // don't want a resource leak
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        roman = roman.toUpperCase();

        if (roman.matches(".*[0-9].*") || !roman.matches("[M|D|C|L|X|V|I]*")) {
            System.out.println("Impossible to convert. Wrong roman numeral");
        }

        int i = 0; // position in the Roman string

        int current = 0; // the current Roman numeral character to Arabic
        // conversion

        int previous = 0; // start previous at zero, that way when
        // current is greater than previous in the first
        // run, nothing will be subtracted from current

        int arabic = 0; // Arabic numeral equivalent of the part of the string
        // that has been converted so far

        while (i < roman.length()) {

            char letter = roman.charAt(i); // letter at the current position in
            // the string

            // switch statement is easier to read than if - else if - else
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
                // subtract previous * 2 because previous was added to arabic
                // once already
                arabic += current - (previous * 2);
            } else {
                // if current is less than or equal to previous then add it to
                // arabic
                arabic += current;
            }

            previous = current; // set previous equal to current to check
            // for less-than on next iteration

            i += 1; // move on to next position in the string

        } // end while

        // print the Arabic conversion after the loop is done

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