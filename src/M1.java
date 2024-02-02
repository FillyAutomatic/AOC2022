import java.io.*;
import java.util.*;
import java.math.*;

public class M1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/m.in"))));

        int ans = 0;
        int ind = 0;
        while (sc.hasNextLine()) {
            ++ind;
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            if (sc.hasNextLine())
                sc.nextLine();
            if (compare(s1, s2) == -1)
                ans += ind;
        }
        System.out.println(ans);
    }

    public static int compare(String s1, String s2) {
        if (s1.startsWith(","))
            return compare(s1.substring(1), s2);
        if (s2.startsWith(","))
            return compare(s1, s2.substring(1));
        // System.out.println(s1);
        // System.out.println(s2);
        // System.out.println();
        if (s1.isEmpty() && s2.isEmpty())
            return 0;
        if (s1.isEmpty())
            return -1;
        if (s2.isEmpty())
            return 1;
        if (s1.charAt(0) >= '0' && s1.charAt(0) <= '9' && s2.charAt(0) >= '0' && s2.charAt(0) <= '9') {
            if (Integer.parseInt(s1.split(",")[0]) > Integer.parseInt(s2.split(",")[0]))
                return 1;
            if (Integer.parseInt(s1.split(",")[0]) < Integer.parseInt(s2.split(",")[0]))
                return -1;
            int i1 = s1.indexOf(",") + 1;
            int i2 = s2.indexOf(",") + 1;
            return compare(i1 == 0 ? "" : s1.substring(s1.indexOf(",") + 1),
                    i2 == 0 ? "" : s2.substring(s2.indexOf(",") + 1));
        }
        if (s1.charAt(0) >= '0' && s1.charAt(0) <= '9') {
            if (s1.indexOf(",") == -1)
                return compare("[" + s1 + "]", s2);
            return compare("[" + s1.substring(0, s1.indexOf(",")) + "]" + s1.substring(s1.indexOf(",")), s2);
        }
        if (s2.charAt(0) >= '0' && s2.charAt(0) <= '9') {
            if (s2.indexOf(",") == -1)
                return compare(s1, "[" + s2 + "]");
            return compare(s1, "[" + s2.substring(0, s2.indexOf(",")) + "]" + s2.substring(s2.indexOf(",")));
        }
        int c1 = 1;
        int j1 = 1;
        while (c1 > 0) {
            if (s1.charAt(j1) == '[')
                ++c1;
            if (s1.charAt(j1) == ']')
                --c1;
            ++j1;
        }
        int c2 = 1;
        int j2 = 1;
        while (c2 > 0) {
            if (s2.charAt(j2) == '[')
                ++c2;
            if (s2.charAt(j2) == ']')
                --c2;
            ++j2;
        }
        int cp = compare(s1.substring(1, j1 - 1), s2.substring(1, j2 - 1));
        if (cp != 0)
            return cp;
        return compare(s1.substring(j1), s2.substring(j2));
    }
}