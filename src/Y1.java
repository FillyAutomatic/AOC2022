import java.io.*;
import java.util.*;
import java.math.*;

public class Y1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/y.in"))));

        long an = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            long fuel = 0;
            for (char c : s.toCharArray()) {
                fuel *= 5;
                if (c == '-')
                    fuel--;
                else if (c == '=')
                    fuel -= 2;
                else
                    fuel += c - '0';
            }
            an += fuel;
        }
        String ans = "";
        while (an > 0) {
            if (an % 5 == 4) {
                ans = '-' + ans;
                an++;
            } else if (an % 5 == 3) {
                ans = '=' + ans;
                an += 2;
            } else {
                ans = (char) ('0' + an % 5) + ans;
                an -= an % 5;
            }
            an /= 5;
        }
        System.out.println(ans);
    }
}