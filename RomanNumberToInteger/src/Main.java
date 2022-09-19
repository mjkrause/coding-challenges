import java.util.HashMap;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        romanNumbers();
        int num;
        num = romanToInteger("V");
        System.out.println("Number: " + num);

        num = romanToInteger("IV");
        System.out.println("Number: " + num);

        num = romanToInteger("XIV");
        System.out.println("Number: " + num);

        num = romanToInteger("III");
        System.out.println("Number: " + num);

        num = romanToInteger("LVIII");
        System.out.println("Number: " + num);

        num = romanToInteger("MCMXCIV");
        System.out.println("Number: " + num);


    }
    private static int romanToInteger(String romanNumber) {
        int length = romanNumber.length();
        int counter = 0;
        // Does it have any characters?
        if (length == counter) {
            return 0;
        }

        Stack<Integer> integerStack = new Stack<>();
        while (counter < length) {

            // Iterate over string of the roman number.
            String _current = Character.toString(romanNumber.charAt(counter));
            int current = getIntegerFromRomanNumber(_current);
            if (length == (counter + 1)) {
                integerStack.push(current);
                break;
            }
            String _next = Character.toString(romanNumber.charAt(counter + 1));
            int next = getIntegerFromRomanNumber(_next);
            if (current < next) {
                integerStack.push(next - current);
                counter = counter + 2;
            } else {
                integerStack.push(current);
                counter++;
            }
        }
        int res = sumStack(integerStack);
        return res;
    }
    private static int sumStack(Stack integerStack) {
        int out = 0;
        while(!integerStack.empty()) {
            out += (int)integerStack.pop();
        }
        return out;
    }
    private static HashMap<String, Integer> aMap = new HashMap<>();

    private static void romanNumbers() {
        aMap.put("I", 1);
        aMap.put("V", 5);
        aMap.put("X", 10);
        aMap.put("L", 50);
        aMap.put("C", 100);
        aMap.put("D", 500);
        aMap.put("M", 1000);
    }
    private static int getIntegerFromRomanNumber(String r) {
        return aMap.get(r);
    }
}
