/**
 *
 */
package prng;

/**
 *
 */
import java.util.ArrayList;

public class Mersenne {
	private static final int N = 624;
	private static final int M = 397;
	private static final int MATRIX_A = 0x9908b0df;
	private static final int UPPER_MASK = 0x80000000;
	private static final int LOWER_MASK = 0x7fffffff;
	private int[] state;
	private int index;

	public static void main(String [] args) {
		// Create an instance of the Mersenne class with a seed value of 12345
		Mersenne mersenne = new Mersenne(12345);


		// Create and store randomly generated values in d10
		for (int i = 0; i < 100; i++) {
			mersenne.next();
		}
		System.out.print("Hi");
	}

	public Mersenne(int seed) {
		this.state = new int[N];
		this.state[0] = seed;
		for (int i = 1; i < N; i++) {
			this.state[i] = (1812433253 * (this.state[i-1] ^ (this.state[i-1] >>> 30)) + i);
		}
		this.index = N;
	}

	public int next() {
		if (this.index >= N) {
			twist();
		}
		int y = this.state[this.index];
		y ^= y >>> 11;
		y ^= (y << 7) & 0x9d2c5680;
		y ^= (y << 15) & 0xefc60000;
		y ^= y >>> 18;
		this.index++;
		return y;
	}

	private void twist() {
		for (int i = 0; i < N; i++) {
			int x = (this.state[i] & UPPER_MASK) + (this.state[(i+1) % N] & LOWER_MASK);
			int xa = x >>> 1;
		if (x % 2 != 0) {
			xa ^= MATRIX_A;
		}
		this.state[i] = this.state[(i+M) % N] ^ xa;
		}
		this.index = 0;
	}

	public long runtime(long num ) {
		// Created an object with a seed value of 56888
		Mersenne twist = new Mersenne(56888);

		// I created an array object d10 to stored 10 number values
		ArrayList<Integer> d10 = new ArrayList<Integer>();

		long start10 = System.nanoTime();


		// Create and store randomly generated values in d10
		for(int i = 0; i < num; i++ ) {
			d10.add(twist.next());
		};


		long end10 = System.nanoTime();

		long runtime10 = end10 - start10;

		return runtime10;
	};

	public long memoryUsage(long num) {
		// Created an object with a seed value of 56888
		Mersenne twist = new Mersenne(56888);

		// I created an array object d10 to stored 10 number values
		ArrayList<Integer> d10 = new ArrayList<Integer>();

		// Get initial memory usage
		long initialMemory = getMemoryUsage();

		// Create and store randomly generated values in d10
		for(int i = 0; i < num; i++ ) {
			d10.add(twist.next());
		};

		// Get memory usage after operations
		long finalMemory = getMemoryUsage();

		// Calculate memory usage difference
		long memoryUsed = finalMemory - initialMemory;

		// Print memory usage information
		return memoryUsed;
	}


	private static long getMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		return memory;
	}
}

