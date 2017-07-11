import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestTask2 {

    public static void main(String[] args) {
        if(args.length<2) {
            System.out.println("Need two params!");
            System.exit(1);
        }

        String a = args[0].toLowerCase();
        String b = args[1].toLowerCase();

        System.out.println(compare(a,b));

        System.out.println(compareByMap(a,b));
    }

    public static boolean compareByMap(String a, String b) {
        Map<Integer, Integer> mapA = new HashMap<>();
        if(a.length()!=b.length())
            return false;
        else
        {
            for(int i=0;i<a.length();i++)
                mapA.put((int)a.charAt(i), 1);

            for(int i=0;i<b.length();i++) {
                if(mapA.get((int)b.charAt(i))!=null)
                    mapA.remove((int)b.charAt(i));
                else
                    return false;
            }
            return true;
        }
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
