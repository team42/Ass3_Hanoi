
public class Recursive_TimeMeasurements {
	
public static void main(String[] args) {
		
		// Enter number of disks
		int disks = 0;
		
		for(disks = 10; disks<=30; disks = disks+5) {
		
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
		}
	}
	
	public static void hanoi(int[] a, int[] b, int[] c, int disks) {
		// if amount of disks equals 1
		if(disks == 1) {
			
			// Move from start pole to destination pole			
			c[(++c[0])+1] = a[(a[0]--)+1];
			
		} else {
			
			// Switch temp and destination pole and call again
			hanoi(a,c,b,disks-1);
			
			// Move from start pole to destination pole
			c[(++c[0])+1] = a[(a[0]--)+1];
			
			// Switch start and temp pole and call again
			hanoi(b,a,c,disks-1);
		}
	}
}
