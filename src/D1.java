import java.io.*;
import java.util.*;
import java.math.*;

public class D1 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/d.in"))));
		/**/
		
		int ans = 0;
		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			int a = Integer.parseInt(s.split(",")[0].split("-")[0]);
			int b = Integer.parseInt(s.split(",")[0].split("-")[1]);
			int c = Integer.parseInt(s.split(",")[1].split("-")[0]);
			int d = Integer.parseInt(s.split(",")[1].split("-")[1]);
			if ((a<=c&&b>=d)||(c<=a&&d>=b))
				++ans;
		}
		System.out.println(ans);
	}
}