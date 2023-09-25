import java.io.*;
import java.util.*;
import java.math.*;

public class O1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/o.in"))));
		/**/
		
		int ycheck = 2000000;
		HashSet<Integer> ans = new HashSet<>();
		HashSet<Integer> ab = new HashSet<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			String s1 = s.split(":")[0].substring("Sensor at ".length()).replace("x=","").replace("y=","").replace(" ","");
			String s2 = s.split(":")[1].substring(" closest beacon is at ".length()).replace("x=","").replace("y=","").replace(" ","");
			int x1 = Integer.parseInt(s1.split(",")[0]);
			int y1 = Integer.parseInt(s1.split(",")[1]);
			int x2 = Integer.parseInt(s2.split(",")[0]);
			int y2 = Integer.parseInt(s2.split(",")[1]);
			int dist = Math.abs(x1-x2)+Math.abs(y1-y2);
			int dy = Math.abs(y1-ycheck);
			for (int i = x1-(dist-dy); i <= x1+(dist-dy); ++i) {
				ans.add(i);
			}
			if (y2==ycheck)
				ab.add(x2);
		}
		ans.removeAll(ab);
		System.out.println(ans.size());
	}
}