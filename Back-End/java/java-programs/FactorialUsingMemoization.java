import java.util.HashMap;
import java.util.Map;
public class FactorialUsingMemoization {
    static Map<Integer, Integer> factorialMap = new HashMap<>();
    public static void main(String[] args) {

        factorialMap.put(1, 1);

        System.out.println(calculateFactorial(5));
        System.out.println(calculateFactorial(8));
        System.out.println(calculateFactorial(10));
    }

    public static int calculateFactorial(int num) {

        if(num == 1) { return 1; }

        if(factorialMap.containsKey(num)) {
//            System.out.println("Getting factorial value from " + num + "to simplify the process");
            return factorialMap.get(num);
        }

        factorialMap.put(num, (num * calculateFactorial(num-1)));
        return factorialMap.get(num);
    }
}
