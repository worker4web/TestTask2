import java.util.Arrays;

public class TestTask2 {

    public static void main(String[] args) {
        if(args.length<2) {
            System.out.println("Need two params!");
            System.exit(1);
        }

        String a = args[0].toLowerCase();
        String b = args[1].toLowerCase();

        System.out.println(compare(a,b));
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
