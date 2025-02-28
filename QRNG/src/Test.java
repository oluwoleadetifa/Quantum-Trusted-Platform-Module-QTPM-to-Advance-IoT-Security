public class Test {
	
	static {
		System.loadLibrary("Quantis");
//		System.load(Test.class.getResource("/dll/Quantis.dll").getPath());
	}

	public static void main(String[] args) throws QuantisException{
		// TODO Auto-generated method stub
		Quantis quantis = new Quantis(Quantis.QuantisDeviceType.QUANTIS_DEVICE_PCI, 0);
		
		System.out.println( System.getProperties().getProperty("java.library.path"));
		
		

		
		System.out.println(quantis.GetBoardVersion());
//	    System.out.println("Data: " + String.format("%X", new BigInteger(data)));
//	    System.out.println("Double: " + quantis.ReadDouble());
//	    System.out.println("Float: " + quantis.ReadFloat());
//	    System.out.println("Int: " + quantis.ReadInt());
//	    System.out.println("Short: " + quantis.ReadShort());
	}

}
