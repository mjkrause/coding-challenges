import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY strings
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        // Write your code here
        ArrayList<Integer> results = new ArrayList<>(strings.size());

        for (int i = 0; i < queries.size(); i++) {
            String hook = queries.get(i);
            int counter = 0;
            for (int j = 0; j < strings.size(); j++) {
                String bait = strings.get(j);
                if (hook.equals(bait)) {
                    counter++;
                }
            }
            results.add(i, counter);
        }


        return results;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        List<String> strings = new ArrayList<>();
        strings.add("ab");
        strings.add("ab");
        strings.add("abc");

        List<String> queries = new ArrayList<>();
        queries.add("ab");
        queries.add("abc");
        queries.add("bc");

        List<Integer> res = Result.matchingStrings(strings, queries);
        res.forEach(s -> System.out.print(s));

    }
}
