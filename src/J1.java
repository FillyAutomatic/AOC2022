import java.io.*;
import java.util.*;
import java.math.*;

public class J1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/j.in"))));

        int ans = 0;
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
        for (int i = 19; i <= 220; i += 40) {
            ans += vals.get(i) * (i + 1);
        }
        System.out.println(ans);
    }
}