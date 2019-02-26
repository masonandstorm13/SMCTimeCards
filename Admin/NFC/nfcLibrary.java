package NFC;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import javax.smartcardio.Card;
import javax.smartcardio.CardChannel;
import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import Gui.CardGui.getEmployeeFromCard;
import Gui.CardGui.writeCard;

public class nfcLibrary implements Runnable{

	/*
	 * Noted Defaults cardConnectionType : T=1 KeyLocation: (byte) 0x00 blockByte:
	 * (byte) 0x04 writeByteArray: (byte) 0x00, (byte)0x01, (byte) 0x02, (byte)0x03,
	 * (byte) 0x04, (byte)0x05, (byte) 0x06, (byte)0x07, (byte) 0x08, (byte)0x09,
	 * (byte) 0x0A, (byte)0x0B, (byte) 0x0C, (byte)0x0D, (byte) 0x0E, (byte)0x0F
	 */

	/*
	 * operation values: 0 : read 1 : write 2 : read then write 3 : write then read
	 */
	public int operation;
	
	//channel 
	public static CardChannel channel;
	// reads UID
	private byte[] baReadUID = new byte[5];

	// Load key
	private byte[] baLoadKey = new byte[12];

	// Authenticate
	private byte[] baAuth = new byte[7];

	// Read value at blcokByte location
	private static byte[] baRead = new byte[6];

	static // write value at block Byte location using passed in writeByteArray
	byte[] baWrite = new byte[20];

	// Used to Decide if Bytes for write are usable
	private static Boolean canWrite = false;
	private String cardConnectionType;
	CardTerminal terminal;
	
	public nfcLibrary(CardTerminal cardTerminal, String cardConnectionType, byte keyLocation, byte blockByte, byte[] writeByteArray, int operation) {
		try {
			this.operation = operation;

			terminal = cardTerminal;			
			this.cardConnectionType = cardConnectionType;
			
			baReadUID = new byte[] { (byte) 0xFF, (byte) 0xCA, (byte) 0x00, (byte) 0x00, (byte) 0x00 };

			baLoadKey = new byte[] { (byte) 0xFF, (byte) 0x82, (byte) 0x00, keyLocation, (byte) 0x06, (byte) 0xFF,
					(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF };

			baAuth = new byte[] { (byte) 0xFF, (byte) 0x86, (byte) 0x00, (byte) 0x00, (byte) 0x05, keyLocation,
					(byte) 0x00, blockByte, (byte) 0x60, (byte) 0x00 };

			//sets up default read command
			baRead = new byte[]{(byte) 0xFF, (byte) 0xB0, (byte) 0x00,
	   				blockByte, (byte) 0x10};
			
			if (writeByteArray != null && writeByteArray.length == 16) {
				canWrite = true;

				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				byte[] baWrite1 = new byte[4];
				baWrite1 = new byte[] { (byte) 0xFF, (byte) 0xD6, (byte) 0x00, blockByte, (byte) 0x10, };
				baos.write(baWrite1);
				baos.write(writeByteArray);
				baWrite = baos.toByteArray();
				// DebugPrint// System.out.println("Write: " + writeToCard(baWrite, channel));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	public String readUID(byte[] cmd) {
		String res = "";

		byte[] baResp = new byte[258];
		ByteBuffer bufCmd = ByteBuffer.wrap(cmd);
		ByteBuffer bufResp = ByteBuffer.wrap(baResp);

		// output = The length of the received response APDU
		int output = 0;

		try {

			output = channel.transmit(bufCmd, bufResp);

		} catch (CardException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < output; i++) {
			res += String.format("%02X", baResp[i]);
			// The result is formatted as a hexadecimal integer
		}

		return res;
	}

	public String loadAuthKey(byte[] cmd) {
		String res = "";

		byte[] baResp = new byte[258];
		ByteBuffer bufCmd = ByteBuffer.wrap(cmd);
		ByteBuffer bufResp = ByteBuffer.wrap(baResp);

		// output = The length of the received response APDU
		int output = 0;

		try {

			output = channel.transmit(bufCmd, bufResp);

		} catch (CardException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < output; i++) {
			res += String.format("%02X", baResp[i]);
			// The result is formatted as a hexadecimal integer
		}

		return res;
	}

	public String authWithKey(byte[] cmd) {
		String res = "";

		byte[] baResp = new byte[258];
		ByteBuffer bufCmd = ByteBuffer.wrap(cmd);
		ByteBuffer bufResp = ByteBuffer.wrap(baResp);

		// output = The length of the received response APDU
		int output = 0;

		try {

			output = channel.transmit(bufCmd, bufResp);

		} catch (CardException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < output; i++) {
			res += String.format("%02X", baResp[i]);
			// The result is formatted as a hexadecimal integer
		}

		return res;
	}

	public byte[] readFromCard() {
		@SuppressWarnings("unused")
		String res = "";

		CommandAPDU bufCmd = new CommandAPDU(baRead);
		ResponseAPDU bufResp = null;

		// output = The length of the received response APDU
		int output = 0;

		try {
			bufResp = channel.transmit(bufCmd);
			output = bufResp.getData().length;

		} catch (CardException ex) {
			ex.printStackTrace();
		}

		for (int i = 0; i < output; i++) {
			res += String.format("%02X", bufResp.getData()[i]);
			// The result is formatted as a hexadecimal integer
		}

		return bufResp.getData();
	}

	//will return null if canWrite == null
	public String writeToCard() {
		
		if(canWrite == false) {
			return null;
		}else {
			String res = "";

			byte[] baResp = new byte[258];
			ByteBuffer bufCmd = ByteBuffer.wrap(baWrite);
			ByteBuffer bufResp = ByteBuffer.wrap(baResp);

			// output = The length of the received response APDU
			int output = 0;

			try {

				output = channel.transmit(bufCmd, bufResp);

			} catch (CardException ex) {
				ex.printStackTrace();
			}

			//how to convert to hex 
			for (int i = 0; i < output; i++) {
				res += String.format("%02X", baResp[i]);
				// The result is formatted as a hexadecimal integer
			}

			return res;
		}
	}
	public volatile boolean flag = true;
	
	public void stopRunning() {
		flag = false;
	}
	
	@Override
	public void run() {
		while(flag) {
			// TODO Auto-generated method stub
			try {
				terminal.waitForCardPresent(1000);
			} catch (CardException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(terminal.isCardPresent()) {
					flag = false;
					System.out.println("we are here");
					// I use T=1
					Card card = null;
					try {
						card = terminal.connect(this.cardConnectionType);
					} catch (CardException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					channel = card.getBasicChannel();
					
					// DebugPrint// System.out.println("UID: " + readUID(baReadUID, channel));
					readUID(baReadUID);
					// If successful, the output will end with 9000
					
					// DebugPrint// System.out.println("LOAD KEY: " + loadAuthKey(baLoadKey,
					// channel));
					loadAuthKey(baLoadKey);
					// If successful, will output 9000
					
					// DebugPrint// System.out.println("AUTHENTICATE: " + authWithKey(baAuth,
					// channel));
					authWithKey(baAuth);
					// If successful, will output 9000
					
					if(operation == 0) {
						try {
							getEmployeeFromCard.hereIsYourValue(new String(readFromCard(), "US-ASCII").trim());
							card.disconnect(false);
						} catch (UnsupportedEncodingException | CardException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}else if(operation == 1) {
						try {
							writeCard.hereIsYourValue(writeToCard(), new String(baWrite, "US-ASCII").trim());
							card.disconnect(false);
						} catch (UnsupportedEncodingException | CardException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else {
					
				}
			} catch (CardException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		System.out.println("we are at the end");
	}
}
