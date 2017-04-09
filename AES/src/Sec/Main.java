package Sec;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {

		String in = "Text new Text Pa";
		String key = "KeyONewOKeyOnewO";
		String keyIV = "RozChirKeyzxswert";
		byte[] en = in.getBytes();
		byte[] keyB = key.getBytes();
		byte[] key4 = keyIV.getBytes();
		int[][] state = new int[4][4];
		int[][] stateK = new int[4][4];
		int[][] stateKIV = new int[4][4];

		state = chiper(state, stateK, stateKIV, en, keyB, key4);
		dechiper(state, stateKIV, stateK);
	}

	public static int[][] stateKey(int[][] stateK, byte[] keyB) {
		for (int i = 0, k = 0; i < stateK.length; i++) {
			for (int j = 0; j < stateK.length; j++) {
				stateK[i][j] = keyB[k++];
			}
		}
		return stateK;
	}

	public static int[][] stateKeyIV(int[][] stateKIV, byte[] keyIV) {
		for (int i = 0, k = 0; i < stateKIV.length; i++) {
			for (int j = 0; j < stateKIV.length; j++) {
				stateKIV[i][j] = keyIV[k++];
			}
		}
		return stateKIV;
	}

	public static int[][] state(int[][] state, byte[] en) {
		for (int i = 0, k = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				if (k == en.length) {
					state[i][j] = 0;
				} else {
					state[i][j] = en[k++];
				}
			}
		}
		return state;
	}

	public static int[][] statePlusKey(int[][] state, int[][] stateK) {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				state[i][j] = state[i][j] + stateK[i][j];
				state[i][j] = state[i][j] % 256;
			}
		}
		return state;
	}

	public static int[][] statePlusKeyPlusKeyIV(int[][] state, int[][] stateKIV) {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				state[i][j] = state[i][j] + stateKIV[i][j];
				state[i][j] = state[i][j] % 256;
			}
		}
		return state;
	}

	public static int[][] stateSbox(int[][] state) {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				int a = state[i][j];
				state[i][j] = Pac.sbox[a / 16][a % 16];
				state[i][j] = state[i][j] % 256;
			}
		}
		return state;
	}

	public static int[][] stateSboxInv(int[][] state) {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				int a = state[i][j];
				state[i][j] = Pac.invsbox[a / 16][a % 16];
				state[i][j] = state[i][j] % 256;
			}
		}
		return state;
	}

	public static int[][] stateSubKeyIVInv(int[][] state, int[][] stateKIV) {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				state[i][j] = state[i][j] - stateKIV[i][j];
				if (state[i][j] > 0) {
					state[i][j] = state[i][j] % 256;
				} else {
					state[i][j] = state[i][j] + 256;
				}
			}
		}
		return state;
	}

	public static int[][] stateSubKeyInv(int[][] state, int[][] stateK) {
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				state[i][j] = state[i][j] - stateK[i][j];
				if (state[i][j] >= 0) {
					state[i][j] = state[i][j] % 256;
				} else {
					state[i][j] = state[i][j] + 256;
				}
			}
		}
		return state;
	}

	public static void stateText(int[][] state) {
		System.out.println("Enter text file name");
		String fileName = SC.next();
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(
				new FileWriter(fileName + ".txt")))) {
			for (int i = 0; i < state.length; i++) {
				for (int j = 0; j < state.length; j++) {
					int kk = state[i][j];
					String str = new String(new char[] { (char) kk });
					System.out.print(str);
					pw.print(str);
				}
			}
			pw.flush();
		} catch (IOException e) {
		}
	}

	public static int[][] shiftRows(int[][] state) {
		for (int i = 1; i < state.length; i++) {
			state[i] = leftrotate(state[i], i);
		}
		return state;
	}

	public static int[] leftrotate(int[] state, int times) {
		assert (state.length == 4);
		if (times % 4 == 0) {
			return state;
		}
		while (times > 0) {
			int temp = state[0];
			for (int i = 0; i < state.length - 1; i++) {
				state[i] = state[i + 1];
			}
			state[state.length - 1] = temp;
			--times;
		}
		return state;
	}

	public static int[][] invShiftRows(int[][] state) {
		for (int i = 1; i < state.length; i++) {
			state[i] = rightrotate(state[i], i);
		}
		return state;
	}

	public static int[] rightrotate(int[] state, int times) {
		if (state.length == 0 || state.length == 1 || times % 4 == 0) {
			return state;
		}
		while (times > 0) {
			int temp = state[state.length - 1];
			for (int i = state.length - 1; i > 0; i--) {
				state[i] = state[i - 1];
			}
			state[0] = temp;
			--times;
		}
		return state;
	}

	public static int[][] chiper(int[][] state, int[][] stateK,
			int[][] stateKIV, byte[] en, byte[] keyB, byte[] key4) {
		state = state(state, en);
		stateK = stateKey(stateK, keyB);
		stateKIV = stateKeyIV(stateKIV, key4);
		state = statePlusKey(state, stateK);
		state = statePlusKeyPlusKeyIV(state, stateKIV);
		state = stateSbox(state);
		state = shiftRows(state);
		System.out.println("Chiper text");
		stateText(state);
		return state;
	}

	public static void dechiper(int[][] state, int[][] stateKIV, int[][] stateK) {
		state = invShiftRows(state);
		state = stateSboxInv(state);
		state = stateSubKeyIVInv(state, stateKIV);
		state = stateSubKeyInv(state, stateK);
		System.out.println();
		System.out.println("Dechiper text");
		stateText(state);
	}

}
