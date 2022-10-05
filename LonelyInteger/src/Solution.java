import java.io.*;
import java.util.*;
import java.util.stream.*;


class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        // A pedestrian solution - try again with streams...

        // Case that a only has one element:
        if (a.size() == 1) {
            return a.get(0);
        }

        int count;
        for (int i = 0; i < a.size(); i++) {
            count = 0;
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) == a.get(i)) {
                    count++;
                }
            }
            if (count == 1) {
                return a.get(i);
            }
        }

        return -1;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        //int[] arr = {1, 2, 3, 4, 3, 2, 1};
        //int[] arr = {1};
        int[] arr = {1, 1, 2};
        List<Integer> a = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.toList());

        int result = Result.lonelyinteger(a);

        System.out.println(result);
    }
}
