import java.io.*;
import java.util.*;
import java.math.*;

public class J2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/j.in"))));

        String ans = "";
        ArrayList<Integer> vals = new ArrayList<>();
        vals.add(1);
        int cv = 1;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String op = s.split(" ")[0];
            if (op.equals("noop")) {
                vals.add(cv);
                continue;
            }
            vals.add(cv);
            int x = Integer.parseInt(s.split(" ")[1]);
            cv += x;
            vals.add(cv);
        }
        for (int i = 0; i < 240; ++i) {
            int x = vals.get(i);
            if (Math.abs(x - i % 40) <= 1)
                ans += "#";
            else
                ans += ".";
            if (i % 40 == 39)
                ans += "\n";
        }
        System.out.println(ans);
    }
}