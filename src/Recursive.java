
public class Recursive {

	static int moves = 0;
	
public static void main(String[] args) {
		
		// Enter number of disks
		int disks = 4;
		
		//for(disks = 10; disks<=30; disks = disks+5) {
		
			// Time variables
			long ts = 0;
			long t = 0;
			
			// Create tower arrays
			int[] a = new int[disks+2];
			int[] b = new int[disks+2];
			int[] c = new int[disks+2];
			
			// Insert values of disks
			for(int i=disks+1; i>1; --i) {
				a[i] = disks-i+2;
				b[i] = c[i] = 0;
			}
			
			// Set number of disks
			a[0] = disks;
			b[0] = c[0] = 0;
			
			// Set tower numbers
			a[1] = 1; b[1] = 2; c[1] = 3;
			
			// Time measurements of 20 rings
			ts = System.nanoTime();
			hanoi(a,b,c,disks);
			t = System.nanoTime()-ts;
			System.out.println(disks + ": " + t + " ns");
			show(a,b,c,disks,moves); // Print disk positions
		//}
	}
	
	public static void hanoi(int[] a, int[] b, int[] c, int disks) {
		if(disks == 1) {
			c[(++c[0])+1] = a[(a[0]--)+1]; // Moves tower 1 top disk to tower 2 top disk
			moves++;
		} else {
			hanoi(a,c,b,disks-1);
			c[(++c[0])+1] = a[(a[0]--)+1]; // Moves tower 1 top disk to tower 2 top disk
			moves++;
			hanoi(b,a,c,disks-1);
		}
	}
	
	public static void show(int[] a, int[] b, int[] c, int disks, int moves) {
		for(int i=disks+1; i>-1; --i) { // Scan thru towers and print positions
			System.out.println(a[i] + "  " + b[i] + "  " + c[i]);
		}
		System.out.println(moves + "\n"); // End with number of moves
	}
}
