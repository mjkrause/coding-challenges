import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        fillPosition1();
        fillPosition2();
        fillPosition3();
        fillPosition4();

        int i;
        String r;

        i = 10;
        r = integerToRoman(i);
        System.out.println("Roman Number: " + r);

        i = 3;
        r = integerToRoman(i);
        System.out.println("Roman Number: " + r);

        i = 58;
        r = integerToRoman(i);
        System.out.println("Roman Number: " + r);

        i = 1994;
        r = integerToRoman(i);
        System.out.println("Roman Number: " + r);

    }

    private static String integerToRoman(int num) {
        String r = String.valueOf((Integer) num);
        int numDigits = getLengthOfInteger(num);

        System.out.println("numDigits: " + numDigits);

        int number;
        String romanNumber = "";
        int position = numDigits - 1;
        int c = 0;
        while (c < numDigits) {
            number = Integer.parseInt(Character.toString(r.charAt(c)));

            if (position == 3 && number != 0) {
                romanNumber = romanNumber.concat(getPosition4.get(number));
            } else if (position == 2 && number != 0) {
                romanNumber = romanNumber.concat(getPosition3.get(number));
            } else if (position == 1 && number != 0) {
                romanNumber = romanNumber.concat(getPosition2.get(number));
            } else if (position == 0 && number != 0){
                romanNumber = romanNumber.concat(getPosition1.get(number));
            }

            c++;
            position--;
        }

        return romanNumber;
    }


    private static final HashMap<Integer, String> getPosition1 = new HashMap<>();

    private static void fillPosition1() {
        getPosition1.put(1, "I");
        getPosition1.put(2, "II");
        getPosition1.put(3, "III");
        getPosition1.put(4, "IV");
        getPosition1.put(5, "V");
        getPosition1.put(6, "VI");
        getPosition1.put(7, "VII");
        getPosition1.put(8, "VIII");
        getPosition1.put(9, "IX");
    }

    private static final HashMap<Integer, String> getPosition2 = new HashMap<>();

    private static void fillPosition2() {
        getPosition2.put(1, "X");
        getPosition2.put(2, "XX");
        getPosition2.put(3, "XXX");
        getPosition2.put(4, "XL");
        getPosition2.put(5, "L");
        getPosition2.put(6, "LX");
        getPosition2.put(7, "LXX");
        getPosition2.put(8, "LXXX");
        getPosition2.put(9, "XC");
    }

    private static final HashMap<Integer, String> getPosition3 = new HashMap<>();

    private static void fillPosition3() {
        getPosition3.put(1, "C");
        getPosition3.put(2, "CC");
        getPosition3.put(3, "CCC");
        getPosition3.put(4, "CD");
        getPosition3.put(5, "D");
        getPosition3.put(6, "DC");
        getPosition3.put(7, "DCC");
        getPosition3.put(8, "DCCC");
        getPosition3.put(9, "CM");
    }

    private static final HashMap<Integer, String> getPosition4 = new HashMap<>();

    private static void fillPosition4() {
        getPosition4.put(1, "M");
        getPosition4.put(2, "MM");
        getPosition4.put(3, "MMM");
    }

    /**
     *
     * @param number
     * @return length: the length of number; e.g., if number = 29, it returns 2
     */
    private static int getLengthOfInteger(int number) {

        if (number > 999) {
            return 4;
        } else if (number > 99) {
            return 3;
        } else if (number > 9) {
            return 2;
        } else {
            return 1;
        }
    }
}