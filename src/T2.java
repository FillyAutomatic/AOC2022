import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.math.*;

public class T2 {
	public static void main(String[] args) throws IOException {

		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/t.in"))));
		/**/
		
		long ans = 0;
		ArrayList<Long> al = new ArrayList<>();
		int n = 0;
		while (sc.hasNextLine()) {
			al.add(sc.nextLong()*811589153);
			++n;
		}
		List<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; ++i)
			arr.add(i);
		for (int z = 0; z < 10; ++z) {
			for (int xi = 0; xi < n; ++xi) {
				int i = 0;
				for (int j = 0; j < n; ++j) {
					if (arr.get(j)==xi)
						i=j;
				}
				long x = al.get(xi)%(n-1);
				for (int k = 0; k < Math.abs(x); ++k) {
					int j = i;
					if (x>0)
						++j;
					else if (x<0)
						--j;
					j = (j+n)%n;
					if (Math.abs(i-j)==1) {
						int t = arr.get(j);
						arr.set(j, arr.get(i));
						arr.set(i, t);
					} else if (i==0) {
						j = n-2;
						arr.add(n-2, arr.remove(0));
					} else {
						j = 1;
						arr.add(1, arr.remove(n-1));
					}
					i = j;
				}
			}
		}
		int zind = 0;
		for (int j = 0; j < n; ++j) {
			if (al.get(arr.get(j))==0)
				zind=j;
		}
		ans = al.get(arr.get((zind+1000)%n))+al.get(arr.get((zind+2000)%n))+al.get(arr.get((zind+3000)%n));
		System.out.println(ans);
	}
}