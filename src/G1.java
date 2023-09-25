import java.io.*;
import java.util.*;
import java.math.*;

public class G1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/g.in"))));
		/**/
		
		int ans = 0;
		ArrayList<String> wd = new ArrayList<>();
		HashMap<String, Long> dirs = new HashMap<>();
		HashSet<String> tra = new HashSet<>();
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			if (s.startsWith("$")) {
				if (s.split(" ")[1].equals("cd")) {
					if (s.split(" ")[2].equals("/"))
						wd = new ArrayList<>();
					else if (s.split(" ")[2].equals(".."))
						wd.remove(wd.size()-1);
					else
						wd.add(s.split(" ")[2]);
				}
			} else {
				if (!s.startsWith("dir")) {
					String file = String.join("/", wd)+"/"+s.split(" ")[1];
					if (!tra.contains(file)) {
						tra.add(file);
						for (int i = 0; i <= wd.size(); ++i) {
							String folder = String.join("/", wd.subList(0, i));
							dirs.put(folder, dirs.getOrDefault(folder,0L)+Integer.parseInt(s.split(" ")[0]));
						}
					}
				}
			}
		}
		for (String s : dirs.keySet()) {
			if (dirs.get(s)<=100000)
				ans += dirs.get(s);
		}
		System.out.println(ans);
	}
}