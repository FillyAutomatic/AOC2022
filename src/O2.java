import java.io.*;
import java.util.*;
import java.math.*;

public class O2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/o.in"))));
		/**/
		
		HashSet<Integer> p1s = new HashSet<>();
		HashSet<Integer> p2s = new HashSet<>();
		HashSet<Integer> m1s = new HashSet<>();
		HashSet<Integer> m2s = new HashSet<>();
		ArrayList<Integer> xs = new ArrayList<>();
		ArrayList<Integer> ys = new ArrayList<>();
		ArrayList<Integer> ds = new ArrayList<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			String s1 = s.split(":")[0].substring("Sensor at ".length()).replace("x=","").replace("y=","").replace(" ","");
			String s2 = s.split(":")[1].substring(" closest beacon is at ".length()).replace("x=","").replace("y=","").replace(" ","");
			int x1 = Integer.parseInt(s1.split(",")[0]);
			int y1 = Integer.parseInt(s1.split(",")[1]);
			int x2 = Integer.parseInt(s2.split(",")[0]);
			int y2 = Integer.parseInt(s2.split(",")[1]);
			int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
			p1s.add(x1+y1+dist+1);
			p2s.add(x1+y1-dist-1);
			m1s.add(x1-y1+dist+1);
			m2s.add(x1-y1-dist-1);
			xs.add(x1);
			ys.add(y1);
			ds.add(dist);
		}
		p1s.retainAll(p2s);
		m1s.retainAll(m2s);
		for (int p : p1s) {
			for (int m : m1s) {
				int y = (p-m)/2;
				long x = p-y;
				if (y<0||x<0||y>4000000||x>4000000)
					continue;
				boolean isAns = true;
				for (int i = 0; i < xs.size(); ++i) {
					if (Math.abs(xs.get(i)-x)+Math.abs(ys.get(i)-y)<=ds.get(i))
						isAns = false;
				}
				if (isAns) {
					System.out.println(x*4000000+y);
				}
			}
		}
	}
}