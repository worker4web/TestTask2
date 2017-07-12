import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TestTask2 {

    public static void main(String[] args) {
        if(args.length<2) {
            System.out.println("Need two params!");
            System.exit(1);
        }

        String a = args[0].toLowerCase();
        String b = args[1].toLowerCase();

        System.out.println(compare(a,b));

        System.out.println(compareStream(a,b));
    }

    public static boolean compareStream(String str1, String str2) {

        Map<Character, Long> index = str1.chars()
                .mapToObj(val -> (char) val)
                .collect(groupingBy(identity(), counting()));

        for (Character symbol : str2.toCharArray()) {
            if (index.containsKey(symbol)) {
                index.merge(symbol, 1L, (v1, v2) -> v1 - v2);
            } else {
                return false;
            }
        }

        return index.values().stream().mapToLong(Long::longValue).sum() == 0;
    }

    public static boolean compare(String a, String b) {
        if(a.length()!=b.length())
            return false;
        else {
            String[] newA = a.split("");
            Arrays.sort(newA);
            String[] newB = b.split("");
            Arrays.sort(newB);
            if(Arrays.equals(newA, newB))
                return true;
            else
                return false;
        }
    }

}
