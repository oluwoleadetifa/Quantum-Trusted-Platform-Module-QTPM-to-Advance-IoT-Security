package com.idquantique.quantis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Test {

	static {
		System.loadLibrary("Quantis");
		//		System.load(Test.class.getResource("/dll/Quantis.dll").getPath());
	}

	public static void main(String[] args) throws QuantisException, IOException{

		// Number of expected output
		int[] times = {2050};


		// TODO Auto-generated method stub
		Quantis quantis = new Quantis(Quantis.QuantisDeviceType.QUANTIS_DEVICE_PCI, 0);

		//		for (int j = 0; j < times.length; j ++) {
		//			//result contains two values runtime which is index 0 and memory usage which is index 1
		//			long result[] = runtime(times[j]);
		//
		//			// Displaying the time taken to compute numbers
		//			System.out.println("The time it takes to generate " + times[j] + " random numbers with QRNG is "+ result[0] +" nano seconds");
		//
		//			//Output on memory usage for QRNG
		//			System.out.println("The memory usage it takes to generate " + times[j] + " random numbers with QRNG is "+ result[1] + " bytes");
		//
		//		};

		ArrayList<Integer> shiftt_val = new ArrayList<>();
		int i = 0;
		while (i < 10) {
			shiftt_val.add(quantis.ReadInt());
			i++;
		}
		System.out.print(shiftt_val);
		write("QRNGG9", shiftt_val);


		System.out.println("The time it takes to generate " + 10000 + " random numbers with QRNG is "+ runtime(10000) +" nano seconds");


	}

	public static long runtime(long num ) throws QuantisException{
		// create quantis object
		Quantis quantis1 = new Quantis(Quantis.QuantisDeviceType.QUANTIS_DEVICE_PCI, 0);

		// I created an array object d10 to stored 10 number values
		ArrayList<Integer> d10 = new ArrayList<Integer>();

		// Get time before operation
		long start10 = System.nanoTime();


		// Create and store randomly generated values in d10
		for(int i = 0; i < num; i++ ) {
			//			d10.add(quantis1.ReadInt());
			quantis1.ReadInt();
		};


		//Get time taken after operations
		long end10 = System.nanoTime();

		long runtime10 = end10 - start10;

		return runtime10;
	}

	public static long memoryUsage(long num) throws QuantisException{
		// create quantis object
		Quantis quantis1 = new Quantis(Quantis.QuantisDeviceType.QUANTIS_DEVICE_PCI, 0);

		// I created an array object d10 to stored 10 number values
		ArrayList<Integer> d10 = new ArrayList<Integer>();

		// Get initial memory usage
		long initialMemory = getMemoryUsage();

		// Create and store randomly generated values in d10
		for(int i = 0; i <= num; i++ ) {
			d10.add(quantis1.ReadInt());
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
