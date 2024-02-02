import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.math.*;

public class K2 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/k.in"))));

        int ans = 0;
        ArrayList<List<Long>> worry = new ArrayList<>();
        ArrayList<Integer> mul = new ArrayList<>();
        ArrayList<Integer> add = new ArrayList<>();
        ArrayList<Integer> div = new ArrayList<>();
        ArrayList<Integer> trues = new ArrayList<>();
        ArrayList<Integer> falses = new ArrayList<>();
        long[] cts;
        while (sc.hasNextLine()) {
            sc.nextLine();
            String itemString = sc.nextLine();
            String op = sc.nextLine();
            String test = sc.nextLine();
            String ifTrue = sc.nextLine();
            String ifFalse = sc.nextLine();
            if (sc.hasNextLine())
                sc.nextLine();
            worry.add(Arrays.stream(itemString.replaceAll(" ", "").split(":")[1].split(",")).map(Long::parseLong)
                    .collect(Collectors.toList()));
            if (op.contains("+")) {
                mul.add(1);
                try {
                    add.add(Integer.parseInt(op.split(" ")[op.split(" ").length - 1]));
                } catch (Exception e) {
                    add.add(-1);
                }
            } else {
                add.add(0);
                try {
                    mul.add(Integer.parseInt(op.split(" ")[op.split(" ").length - 1]));
                } catch (Exception e) {
                    mul.add(-1);
                }
            }
            div.add(Integer.parseInt(test.split(" ")[test.split(" ").length - 1]));
            trues.add(Integer.parseInt(ifTrue.split(" ")[ifTrue.split(" ").length - 1]));
            falses.add(Integer.parseInt(ifFalse.split(" ")[ifFalse.split(" ").length - 1]));
        }
        int n = worry.size();
        cts = new long[n];
        for (int i = 0; i < 10000; ++i) {
            for (int j = 0; j < n; ++j) {
                for (long x : worry.get(j)) {
                    if (mul.get(j) == -1)
                        x *= x;
                    else
                        x *= mul.get(j);
                    if (add.get(j) == -1)
                        x += x;
                    else
                        x += add.get(j);
                    x %= 2L * 3 * 5 * 7 * 11 * 13 * 17 * 19 * 23;
                    ++cts[j];
                    if (x % div.get(j) == 0)
                        worry.get(trues.get(j)).add(x);
                    else
                        worry.get(falses.get(j)).add(x);
                }
                worry.get(j).clear();
            }
        }
        Arrays.sort(cts);
        System.out.println(cts[n - 1] * cts[n - 2]);
    }
}