package Custom;

public class StringByteConvert {

	public String ByteConvert(String value) {
		

		byte[] initalByte = value.getBytes();
		String byteAsString ="";
		int initialStringlength = 0;
		
		System.out.println(initalByte.toString());
		//adds bytes to string
		for(int i = 0; i < initalByte.length; i++) {
			byteAsString = byteAsString + initalByte[i];
		}
		//sets a int to be used for loop
		initialStringlength = byteAsString.length();	
		for(int i = 0; i < 32 - initialStringlength ; i++) {
			System.out.println(i);
			byteAsString = byteAsString + "F";		
		}
		
		
		return byteAsString;
		
	}
}
