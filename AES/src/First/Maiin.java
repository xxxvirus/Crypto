package First;

public class Maiin {

	public static void main(String[] args) {
		String in = "Textnbgfsb bbnh kk";
//		byte[] b = in.getBytes();
//		int[][] a = new int[4][4];
		int[][] aaa = {{ 41, 27, 55,67 },{24,33,54,67},{24,33,54,67},{24,33,54,67}};
//		int temp = aaa[0];
		int[][] aa = arrRowsS(aaa);
		for (int i = 0; i < aa.length; i++) {
			for (int j = 0; j < aa.length; j++) {
				System.out.print(" " + aa[i][j]);
			}
			System.out.println(" ");
			
		}
		
		

		// for (int i = 0, k = 0; i < a.length; i++) {
		// for (int j = 0; j < a[i].length; j++) {
		// if (k == b.length) {
		// a[i][j] = 0;
		// } else {
		// a[i][j] = b[k++];
		// }
		// System.out.print(" " + a[i][j]);
		// }
		// System.out.println(" ");
		// }

	}

	public static int[][] arrRowsS(int[][] arr) {
		for (int i = 1; i < arr.length; i++) {
            arr[i] = leftrotate(arr[i], i);
        }
		return arr;
	}
	
	public static int[] leftrotate(int[] arr, int times)
    {
        assert(arr.length == 4);
        if (times % 4 == 0) {
            return arr;
        }
        while (times > 0) {
            int temp = arr[0];
            for (int i = 0; i < arr.length - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[arr.length - 1] = temp;
            --times;
        }
        return arr;
    }
	
	public static int[] arr2(int[] aaa){
		int temp = aaa[0];
		for (int i = 0; i < aaa.length-1; i++) {
			aaa[i] = aaa[i+1];
		}
		aaa[aaa.length - 1] = temp;
		return aaa;
	}

	static int random(int min, int max) {
		return (int) Math.round(Math.random() * (max - min) + min);
	}

}
