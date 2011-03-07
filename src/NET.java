
public class NET {

	static int operations = 0;
	
	public static void main (String args[]) {
		/*if (args.length != 1) {
			System.err.println("error: a single integer argument needed");
			System.exit(1);
		}
		Integer N = new Integer(args[0]);
		H_dohanoi(N.intValue(), 3, 1, 2);*/
		H_dohanoi(4, 3, 1, 2);
		System.out.println("Operations: "+operations);
		System.exit(0);
	}
	
	static void H_dohanoi(int n, int p3, int p1, int p2) {
		if (n > 0) {
			operations++;
			H_dohanoi(n-1, p2, p1, p3);
			H_moveit(p1, p3);
			H_dohanoi(n-1, p3, p2, p1);
		}
	}
	
	static void H_moveit(int from, int to) {
		System.out.print("move ");
		System.out.print(from);
		System.out.print(" --> ");
		System.out.println(to);
	}
} 
