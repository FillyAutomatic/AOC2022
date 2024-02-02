import java.io.*;
import java.util.*;
import java.math.*;

public class F1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/f.in"))));

        int ans = 0;
        String s = sc.next();
        for (int i = 3; i < s.length(); ++i) {
            HashSet<Character> cs = new HashSet<>();
            cs.add(s.charAt(i));
            cs.add(s.charAt(i - 1));
            cs.add(s.charAt(i - 2));
            cs.add(s.charAt(i - 3));
            if (cs.size() == 4) {
                System.out.println(i + 1);
                return;
            }
        }
    }
}