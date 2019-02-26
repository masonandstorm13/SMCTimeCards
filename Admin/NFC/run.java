package NFC;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import javax.smartcardio.TerminalFactory;

public class run {

	public static void main(String[] args) throws CardException, UnsupportedEncodingException {
		String string = "Chuck";
		byte[] byteString = string.getBytes("US-ASCII");
		String formated = "";
//		for(int i = 0; i < byteString.length; i++) {
//			formated = formated + String.format("%02X", byteString[i]);
//		}

		
		for(int i = 0; i < byteString.length; i++) {
			System.out.println(byteString[i]);
		}
		
		byte[] masterByte = new byte[16];
		
		for(int i = 0; i < byteString.length; i++) {
			masterByte[i] = byteString[i];
		}
		System.out.println("");
		
		for(byte loopByte : masterByte) {
			System.out.println(loopByte);
		}
		
		System.out.println(new String(masterByte).trim());
		
		
		TerminalFactory factory = TerminalFactory.getDefault();
        List<CardTerminal> terminals = factory.terminals().list();
        CardTerminal terminal = terminals.get(0);

        nfcLibrary nfcLibrary = new nfcLibrary(terminal, "T=1", (byte) 0x00, (byte) 0x04, masterByte, 0);
        System.out.println("Read Value: " + new String(nfcLibrary.readFromCard(), "US-ASCII"));
        System.out.println("Write Value: " + nfcLibrary.writeToCard());
        
        
	}
}
