import java.io.*;
import java.util.*;
import java.math.*;

public class P2 {
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
        ArrayList<HashMap<String, HashMap<String, HashMap<Integer, Integer>>>> al = new ArrayList<>();
        for (int i = 0; i <= 30; ++i) {
            al.add(new HashMap<>());
            for (String s : flows.keySet()) {
                al.get(i).put(s, new HashMap<>());
                for (String s2 : flows.keySet()) {
                    al.get(i).get(s).put(s2, new HashMap<>());
                }
            }
        }
        al.get(0).get("AA").get("AA").put(0, 0);
        for (int i = 1; i <= 26; ++i) {
            System.out.println(i);
            for (String s : flows.keySet()) {
                for (String s2 : flows.keySet()) {
                    for (int x : al.get(i - 1).get(s).get(s2).keySet()) {
                        if (i >= 20 && al.get(i - 1).get(s).get(s2).get(x) < 1000)
                            continue;
                        int val = 0;
                        for (int j = 1; j <= 30; ++j) {
                            if (((1 << j) & x) > 0)
                                val += j;
                        }
                        int nv = al.get(i - 1).get(s).get(s2).get(x) + val;
                        for (String t : g.get(s)) {
                            for (String t2 : g.get(s2)) {
                                al.get(i).get(t).get(t2).put(x,
                                        Math.max(nv, al.get(i).get(t).get(t2).getOrDefault(x, 0)));
                                ans = Math.max(ans, al.get(i).get(t).get(t2).get(x));
                            }
                        }
                        if (flows.get(s) != 0) {
                            int nx = x | (1 << flows.get(s));
                            for (String t2 : g.get(s2)) {
                                al.get(i).get(s).get(t2).put(nx,
                                        Math.max(nv, al.get(i).get(s).get(t2).getOrDefault(nx, 0)));
                                ans = Math.max(ans, al.get(i).get(s).get(t2).get(nx));
                            }
                        }
                        if (flows.get(s2) != 0) {
                            int nx = x | (1 << flows.get(s2));
                            for (String t : g.get(s)) {
                                al.get(i).get(t).get(s2).put(nx,
                                        Math.max(nv, al.get(i).get(t).get(s2).getOrDefault(nx, 0)));
                                ans = Math.max(ans, al.get(i).get(t).get(s2).get(nx));
                            }
                        }
                        if (flows.get(s) != 0 && flows.get(s2) != 0) {
                            int nx = x | (1 << flows.get(s)) | (1 << flows.get(s2));
                            al.get(i).get(s).get(s2).put(nx,
                                    Math.max(nv, al.get(i).get(s).get(s2).getOrDefault(nx, 0)));
                            ans = Math.max(ans, al.get(i).get(s).get(s2).get(nx));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }
}