import java.io.*;
import java.util.*;
import java.math.*;

public class P1 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/p.in"))));

        int ans = 0;
        HashMap<String, Integer> flows = new HashMap<>();
        HashMap<String, ArrayList<String>> g = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String name = s.split(" ")[1];
            int flow = Integer.parseInt(s.split(";")[0].split("=")[1]);
            String[] tunnels = Arrays.stream(s.split(",")).map(str -> str.split(" ")[str.split(" ").length - 1])
                    .toArray(String[]::new);
            g.put(name, new ArrayList<>());
            for (String t : tunnels)
                g.get(name).add(t);
            flows.put(name, flow);
        }
        ArrayList<HashMap<String, HashMap<Integer, Integer>>> al = new ArrayList<>();
        for (int i = 0; i <= 30; ++i) {
            al.add(new HashMap<>());
            for (String s : flows.keySet()) {
                al.get(i).put(s, new HashMap<>());
            }
        }
        al.get(0).get("AA").put(0, 0);
        for (int i = 1; i <= 30; ++i) {
            for (String s : flows.keySet()) {
                for (int x : al.get(i - 1).get(s).keySet()) {
                    int val = 0;
                    for (int j = 1; j <= 30; ++j) {
                        if (((1 << j) & x) > 0)
                            val += j;
                    }
                    int nv = al.get(i - 1).get(s).get(x) + val;
                    for (String t : g.get(s)) {
                        al.get(i).get(t).put(x, Math.max(nv, al.get(i).get(t).getOrDefault(x, 0)));
                        ans = Math.max(ans, al.get(i).get(t).get(x));
                    }
                    if (flows.get(s) != 0) {
                        al.get(i).get(s).put(x | (1 << flows.get(s)),
                                Math.max(nv, al.get(i).get(s).getOrDefault(x | (1 << flows.get(s)), 0)));
                        ans = Math.max(ans, al.get(i).get(s).get(x | (1 << flows.get(s))));
                    }
                }
            }
        }
        System.out.println(ans);
    }
}