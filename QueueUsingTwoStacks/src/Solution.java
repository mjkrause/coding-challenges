import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Stack<Integer> main = new Stack<>();
        Stack<Integer> aux = new Stack<>();
        //String s;
        ArrayList<Integer> params;
        String type;
        int nQueries = 0;
        ArrayList<ArrayList<Integer>> requests = new ArrayList<>();

        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        if (scanner.hasNext()) {
            nQueries = Integer.parseInt(scanner.nextLine());
            System.out.println("Number of queries to input: " + nQueries);
        }

        // Collect input from STDIN:
        for (int i = 0; i < nQueries; i++) {
            params = parseInput(scanner.nextLine());
            requests.add(params);
        }

        for (int i = 0; i < requests.size(); i++) {
            params = requests.get(i);
            type = getType(params);
            //System.out.println(params.get(0));
            doOperation(type, params, main, aux);
        };

//        s = "1 42";
//        params = parseInput(s);
//        type = getType(params);
//        //System.out.println(params.get(0));
//        doOperation(type, params, main, aux);
//
//        s = "3";
//        params = parseInput(s);
//        type = getType(params);
//        doOperation(type, params, main, aux);


    }

    public static void doOperation(String type, ArrayList<Integer> params, Stack<Integer> main, Stack<Integer> aux) {
        if (type.equals("enqueue")) {
            enqueue(main, params);
        } else if (type.equals("dequeue")) {
            dequeue(main, aux);
        } else {
            print(main, aux);
        }
    }

    public static void enqueue(Stack<Integer> main, ArrayList<Integer> params) {
        main.push(params.get(1));
    }

    public static void dequeue(Stack<Integer> main, Stack<Integer> aux) {
        main.removeElementAt(0);
    }

    public static void print(Stack<Integer> main, Stack<Integer> aux) {
        System.out.println(main.firstElement());
    }

    public static ArrayList<Integer> parseInput(String input) {

        ArrayList<Integer> params = new ArrayList<>();
        String[] parts = input.split(" ");
        for (int i = 0; i < parts.length; i++) {
            params.add(Integer.parseInt(parts[i]));
        }

        return params;
    }

    public static String getType(ArrayList<Integer> params) {
        String type;
        if (params.get(0) == 1) {
            type = "enqueue";
        } else if (params.get(0) == 2) {
            type = "dequeue";
        } else {
            type = "print";
        }

        return type;
    }
}
