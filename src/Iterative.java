
public class Iterative {
	
	public static void main(String[] args) {
		
		// Enter number of disks
		int disks = 4;
		
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
		
		// Start moving!
		hanoi(a,b,c,disks);
	}
	
	public static void hanoi(int[] a, int[] b, int[] c, int disks) {
		
		int moves = 0; // Number of moves
		int state = 1; // Current state
		int lastmoved = 0; // Last moved disk
		
		show(a,b,c,disks,moves); // Print disk positions
		
		do { // Start loop
			switch(state){
			case 1:
				if(a[a[0]+1]%2 != 0) { // If top disk of tower 1 is odd
					if(!(lastmoved == 1 && a[a[0]+1] == 1) && a[0] > 0) { // If the last moved and current top disk isn't 1 and there exists disk on tower 1
						if((a[a[0]+1] < c[c[0]+1]) || c[0] == 0) { // If top disk of tower 1 is smaller than top disk of tower 3 or there's no disks on tower 3
							lastmoved = a[a[0]+1]; // Set last moved to top disk of tower 1
							c[(++c[0])+1] = a[(a[0]--)+1]; // Moves tower 1 top disk to tower 3 top disk
							moves++; // Increase number of moves
							show(a,b,c,disks,moves); // Print disk positions
						} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					state = 2; // Set next state
					break;
				} else { // If top disk of tower 1 is even
					if(!(lastmoved == 1 && a[a[0]+1] == 1) && a[0] > 0) { // If the last moved and current top disk isn't 1 and there exists disk on tower 1
						if((a[a[0]+1] < b[b[0]+1]) || b[0] == 0) { // If top disk of tower 1 is smaller than top disk of tower 2 or there's no disks on tower 2
							lastmoved = a[a[0]+1]; // Set last moved to top disk of tower 1
							b[(++b[0])+1] = a[(a[0]--)+1]; // Moves tower 1 top disk to tower 2 top disk
							moves++; // Increase number of moves
							show(a,b,c,disks,moves); // Print disk positions
						} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					state = 2; // Set next state
					break;
				}
			case 2:
				if(c[c[0]+1]%2 != 0) { // If top disk of tower 2 is odd
					if(!(lastmoved == 1 && c[c[0]+1] == 1) && c[0] > 0) { // If the last moved and current top disk isn't 1 and there exists disk on tower 2
						if((c[c[0]+1] < b[b[0]+1]) || b[0] == 0) { // If top disk of tower 3 is smaller than top disk of tower 2 or there's no disks on tower 2
							lastmoved = c[c[0]+1]; // Set last moved to top disk of tower 3
							b[(++b[0])+1] = c[(c[0]--)+1]; // Moves tower 3 top disk to tower 2 top disk
							moves++; // Increase number of moves
							show(a,b,c,disks,moves); // Print disk positions
						} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					state = 3; // Set next state
					break;
				} else { // If top disk of tower 2 is even
					if(!(lastmoved == 1 && c[c[0]+1] == 1) && c[0] > 0) { // If the last moved and current top disk isn't 1 and there exists disk on tower 2
						if((c[c[0]+1] < a[a[0]+1]) || a[0] == 0) { // If top disk of tower 3 is smaller than top disk of tower 1 or there's no disks on tower 1
							lastmoved = c[c[0]+1]; // Set last moved to top disk of tower 3
							a[(++a[0])+1] = c[(c[0]--)+1]; // Moves tower 3 top disk to tower 1 top disk
							moves++; // Increase number of moves
							show(a,b,c,disks,moves); // Print disk positions
						} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					state = 3; // Set next state
					break;
				}
			case 3:
				if(b[b[0]+1]%2 != 0 && b[0] > 0) { // If top disk of tower 3 is odd
					if(!(lastmoved == 1 && b[b[0]+1] == 1) && c[0] > 0) { // If the last moved and current top disk isn't 1 and there exists disk on tower 3
						if((b[b[0]+1] < a[a[0]+1]) || a[0] == 0) { // If top disk of tower 2 is smaller than top disk of tower 1 or there's no disks on tower 1
							lastmoved = b[b[0]+1]; // Set last moved to top disk of tower 2
							a[(++a[0])+1] = b[(b[0]--)+1]; // Moves tower 2 top disk to tower 1 top disk
							moves++; // Increase number of moves
							show(a,b,c,disks,moves); // Print disk positions
						} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					state = 1; // Set back to first state
					break;
				} else { // If top disk of tower 3 is even
					if(!(lastmoved == 1 && b[b[0]+1] == 1) && c[0] > 0) { // If the last moved and current top disk isn't 1 and there exists disk on tower 3
						if((b[b[0]+1] < c[c[0]+1]) || c[0] == 0) { // If top disk of tower 2 is smaller than top disk of tower 3 or there's no disks on tower 3
							lastmoved = b[b[0]+1]; // Set last moved to top disk of tower 2
							c[(++c[0])+1] = b[(b[0]--)+1]; // Moves tower 2 top disk to tower 3 top disk
							moves++; // Increase number of moves
							show(a,b,c,disks,moves); // Print disk positions
						} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					} else { lastmoved = 0; } // Reset last moved variable if nothing is moved
					state = 1; // Set back to first state
					break;
				}
			}
		} while((b[0] < disks) && (c[0] < disks)); // Run loop till all disks are moved to tower 1 or 2
	}
	
	public static void show(int[] a, int[] b, int[] c, int disks, int moves) {
		for(int i=disks+1; i>-1; --i) { // Scan thru towers and print positions
			System.out.println(a[i] + "  " + b[i] + "  " + c[i]);
		}
		System.out.println(moves + "\n"); // End with number of moves
	}
}
