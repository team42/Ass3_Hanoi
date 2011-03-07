
public class Iterative {
	
	public static void main(String[] args) {
		
		int disks = 3;
		
		int[] a = new int[disks+2];
		int[] b = new int[disks+2];
		int[] c = new int[disks+2];
		
		for(int i=disks+1; i>1; --i) {
			a[i] = disks-i+2;
			b[i] = c[i] = 0;
		}
		
		a[0] = disks;
		b[0] = c[0] = 0;
		
		a[1] = 1; b[1] = 2; c[1] = 3;
		
		hanoi(a,b,c,disks);
	}
	
	public static void hanoi(int[] a, int[] b, int[] c, int disks) {
		
		int moves = 0;
		int state = 1;
		int lastmoved = 0;
		int[] done = new int[disks+2];
		done = a;
		
		show(a,b,c,disks,moves);
		
		//while(b[0] != disks || c[0] != disks) {
		for(int i=0; i<30; i++) {
			switch(state){
			case 1:
				if(a[a[0]+1]%2 != 0) {
					if(!(lastmoved == 1 && a[a[0]+1] == 1)) {
						if((a[a[0]+1] < c[c[0]+1]) || c[0] == 0) {
							lastmoved = a[a[0]+1];
							c[(++c[0])+1] = a[(a[0]--)+1];
							moves++;
							System.out.println("Lastmove: " + lastmoved);
							show(a,b,c,disks,moves);
						} else { lastmoved = 0; }
					} else { lastmoved = 0; }
					state = 2;
					break;
				} else {
					if(!(lastmoved == 1 && a[a[0]+1] == 1)) {
						if((a[a[0]+1] < b[b[0]+1]) || b[0] == 0) {
							lastmoved = a[a[0]+1];
							b[(++b[0])+1] = a[(a[0]--)+1];
							moves++;
							System.out.println("Lastmove: " + lastmoved);
							show(a,b,c,disks,moves);
						} else { lastmoved = 0; }
					} else { lastmoved = 0; }
					state = 2;
					break;
				}
			case 2:
				if(c[c[0]+1]%2 != 0) {
					if(!(lastmoved == 1 && c[c[0]+1] == 1)) {
						if((c[c[0]+1] < b[b[0]+1]) || b[0] == 0) {
							lastmoved = c[c[0]+1];
							b[(++b[0])+1] = c[(c[0]--)+1];
							moves++;
							System.out.println("Lastmove: " + lastmoved);
							show(a,b,c,disks,moves);
						} else { lastmoved = 0; }
					} else { lastmoved = 0; }
					state = 3;
					break;
				} else {	
					if(!(lastmoved == 1 && c[c[0]+1] == 1)) {
						if((c[c[0]+1] < a[a[0]+1]) || a[0] == 0) {
							lastmoved = c[c[0]+1];
							a[(++a[0])+1] = c[(c[0]--)+1];
							moves++;
							System.out.println("Lastmove: " + lastmoved);
							show(a,b,c,disks,moves);
						} else { lastmoved = 0; }
					} else { lastmoved = 0; }
					state = 3;
					break;
				}
			case 3:
				if(b[b[0]+1]%2 != 0) {
					if(!(lastmoved == 1 && b[b[0]+1] == 1)) {
						if((b[b[0]+1] < a[a[0]+1]) || a[0] == 0) {
							lastmoved = b[b[0]+1];
							a[(++a[0])+1] = b[(b[0]--)+1];
							moves++;
							System.out.println("Lastmove: " + lastmoved);
							show(a,b,c,disks,moves);
						} else { lastmoved = 0; }
					} else { lastmoved = 0; }
					state = 1;
					break;
				} else {
					if(!(lastmoved == 1 && b[b[0]+1] == 1)) {
						if((b[b[0]+1] < c[c[0]+1]) || c[0] == 0) {
							lastmoved = b[b[0]+1];
							c[(++c[0])+1] = b[(b[0]--)+1];
							moves++;
							System.out.println("Lastmove: " + lastmoved);
							show(a,b,c,disks,moves);
						} else { lastmoved = 0; }
					} else { lastmoved = 0; }
					state = 1;
					break;
				}
			}
		}
	}
	
	public static void show(int[] a, int[] b, int[] c, int disks, int moves) {
		for(int i=disks+1; i>-1; --i) {
			System.out.println(a[i] + "  " + b[i] + "  " + c[i]);
		}
		System.out.println(moves + "\n");
	}
}
