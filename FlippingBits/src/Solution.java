import java.io.*;


class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        // Write your code here
        //StringBuilder sb = new StringBuilder();
        //long res = convert(n, sb);

        String s = Integer.toBinaryString((int) n);
        String s2 = padWithZeros(s, 32);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        long res = Long.parseUnsignedLong(sb.toString(), 2);

        return res;
    }

    private static String padWithZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

//    private static long convert(long n, StringBuilder sb) {
//
//        if (n > 0) {
//            sb.append(n % 2);
//            convert(n >> 1, sb);
//        }
//        sb = sb.insert(0, "0".repeat(32));
//        long res = Integer.parseInt(sb.toString());
//
//        return res;
//    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        // General approach:
        // 1. convert to binary
        // 2. flip bits
        // 3. pad with zeros to the left for 32 bits

        int n = 1234;

        long result = Result.flippingBits(n);
        System.out.println(result);

    }
}
