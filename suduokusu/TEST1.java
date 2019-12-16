package suduokusu;

public class TEST1 {

	public static void main(String[] args) {
		int[][]n = new int[9][9];
		System.out.println(n.length);
		int regionsize = (int)Math.sqrt(n.length);
		System.out.println(regionsize);
		Bricka[][]brick = new Bricka[9][9];

		for(int row=0;row<brick.length;row++) {
			for(int col = 0;col<brick[row].length;col++) {
				brick[row][col]= new Bricka(0,0,0,0);
			}
		}
		


	}

}
