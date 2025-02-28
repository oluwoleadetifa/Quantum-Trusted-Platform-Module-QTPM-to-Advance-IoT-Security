/**
 *
 */
package prng;

/**
 *
 */
import java.util.ArrayList;

public class XorShift {
	private long state;

	public XorShift(long seed) {
		this.state = seed;
	}

	public long next() {
		long x = this.state;
		x ^= x << 13;
		x ^= x >> 7;
		x ^= x << 17;
		this.state = x;
		return x & 0xffffffffL;
	}

	public long runtime(long num ) {
		// Created an object with a seed value of 56888
		XorShift shift = new XorShift(56888);

		// I created an array object d10 to stored 10 number values
		ArrayList<Long> d10 = new ArrayList<Long>();

		long start10 = System.nanoTime();


		// Create and store 10 randomly generated values in d10
		for(int i = 0; i < num; i++ ) {
			d10.add(shift.next());
		};

		long end10 = System.nanoTime();

		long runtime10 = end10 - start10;

		return runtime10;
	};

	public long memoryUsage(int num) {
		// Created an object with a seed value of 56888
		XorShift shift = new XorShift(56888);

		// I created an array object d10 to stored 10 number values
		ArrayList<Long> d10 = new ArrayList<Long>();

		// Get initial memory usage
		long initialMemory = getMemoryUsage();

		// Create and store randomly generated values in d10
		for(int i = 0; i < num; i++ ) {
			d10.add(shift.next());
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

