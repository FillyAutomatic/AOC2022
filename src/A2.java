import java.io.*;
import java.util.*;
import java.math.*;

public class A2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));

        ArrayList<Integer> al = new ArrayList<>();
        int ans = 0;
        int curr = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.isEmpty()) {
                al.add(curr);
                curr = 0;
            } else {
                curr += Integer.parseInt(s);
            }
        }
        al.add(curr);
        Collections.sort(al);
        ans += al.get(al.size() - 1);
        ans += al.get(al.size() - 2);
        ans += al.get(al.size() - 3);
        System.out.println(ans);
    }
}