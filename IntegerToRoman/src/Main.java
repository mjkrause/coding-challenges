import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        romanNumbers();

        int i = 29;
        String r = integerToRoman(i);
        //System.out.println(getLengthOfInteger(i));
        System.out.println("Roman Number: " + r);

    }

    private static String integerToRoman(int i) {
        String r = String.valueOf((Integer) i);
        int numDigits = r.length() - 1;
        System.out.println("String of input: " + r);
        System.out.println("numDigits: " + numDigits);
        System.out.println("charAt(0): " + r.charAt(numDigits));

        int num;
        //Stack<Integer> tempStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        //stack.push((Integer) 0);
        int c = 0;
        while (c < numDigits) {
            //tempStack.empty();
            num = r.charAt(c);
            if (num == 5) {
                stack.push("V");
            } else if (num > 5) {
                stack.push("X");
                num = num - 5;  // num is larger than 5, so we need to establish the remainder
                getItoIV(num, stack, 0);

            }

            c++;
        }

        return "XXIX";
    }

    /**
     * 
     * @param i
     * @param stack
     * @return stack with roman number
     */
    private static Stack getItoIV(int i, Stack stack, int position) {

        // Don't use a switch-construct here - it's too expensive!
        if (position == 0) {
            if (i == 4) {
                stack.push("IV");
            } else if (i == 3) {
                stack.push("III");
            } else if (i == 2) {
                stack.push("II");
            } else {
                stack.push("I");
            }
        }

        return stack;
    }


    /**
     *
     * @param number
     * @return length: the length of number; e.g., if number = 29, it returns 2
     */
    private static int getLengthOfInteger(int number) {
        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
        }
        return length;
    }

//    private static final HashMap<int, String[]> positionMap = new HashMap<>();
//
//    private static void getPositionMap() {
//        String one[] = {"I", "II", "III", "IV"};
//        positionMap.put(1, one);
//
//        String ten[] = {"IX", "IIX", "IIIX", "IV"};
//    }

    private static final HashMap<Integer, String> aMap = new HashMap<>();

    private static void romanNumbers() {
        aMap.put(1, "I");
        aMap.put(5, "V");
        aMap.put(10, "X");
        aMap.put(50, "L");
        aMap.put(100, "C");
        aMap.put(500, "D");
        aMap.put(1000, "M");
    }
}