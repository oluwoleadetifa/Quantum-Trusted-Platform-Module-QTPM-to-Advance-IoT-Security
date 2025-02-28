/**
 *
 */
package prng;

/**
 *
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String [] args) throws IOException {

		// Number of expected output
		//		int[] times = {10, 100, 1000, 10000, 100000, 1000000};


		// create an object of both PRNG algorithms
		XorShift shift = new XorShift(56888);
		//		Mersenne twist = new Mersenne(56888);


		//
		//		for (int j = 0; j < times.length; j ++) {
		//			// Creating j random numbers with XorShift
		//			System.out.println("The time it takes to generate " + times[j] + " random numbers with XorShift is "+ shift.runtime(times[j]) +" nano seconds");
		//			// Creating j random numbers with Mersenne twister
		//			System.out.println("The time it takes to generate " + times[j] + " random numbers with Mersenne Twister is "+ twist.runtime(times[j]) +" nano seconds\n");
		//
		//			//Output on memory usage for XorShift
		//			System.out.println("The memory usage it takes to generate " + times[j] + " random numbers with XorShift is "+ shift.memoryUsage(times[j]) + " bytes");
		//			//Output on memory usage for Mersenne twister
		//			System.out.println("The memory usage it takes to generate " + times[j] + " random numbers with Mersenee Twister is "+ twist.memoryUsage(times[j]) + " bytes\n");
		//
		//		};

		//		System.out.println("The time it takes to generate " + 10 + " random numbers with Mersenne is "+ twist.runtime(10000) +" nano seconds");


		//		ArrayList<Long> shiftt_val = new ArrayList<>();
		//		for (int i=0; i < 10; i++) {
		//			shiftt_val.add(shift.next());
		//
		//		}
		System.out.print(shift.memoryUsage(10));

	};

	public static void write(String filename, ArrayList<Integer> array) throws IOException {
		BufferedWriter ow = null;
		ow = new BufferedWriter(new FileWriter(filename));
		for (int i = 0; i < array.size(); i++) {

			ow.write(array.get(i)+"");
			ow.newLine();
		}
		ow.flush();
		ow.close();
	}

}

