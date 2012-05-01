package webworks.io.ImageUtils;

import java.io.DataOutputStream;
import java.io.InputStream;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

import net.rim.device.api.io.IOUtilities;

public class FileUtils {
	public static byte[] getFileByteArray(String fullPath) throws Exception {

		FileConnection fc = null;
		InputStream is;
		is = null;
		byte[] raw = null;

	// Open file and stream
		fc = (FileConnection) Connector.open(fullPath);
		
		is = fc.openInputStream();
	// Create a byte array to hold file contents
		raw = IOUtilities.streamToBytes(is);

		System.out.println("length of data: "+raw.length);
		
		is.close();
		fc.close();
		
		return raw;
	}
	
	public static byte[] writeFileByteArray(String fullPath, byte[] data) throws Exception {

		FileConnection fc = null;
		DataOutputStream os = null;
		byte[] raw = null;

	// Open file and stream
		fc = (FileConnection) Connector.open(fullPath, Connector.READ_WRITE);
		
		if (!fc.exists()) {
			fc.create();
		}
		
		os = fc.openDataOutputStream();
		os.write(data);
		
		os.close();
		fc.close();
		
		return raw;
	}
}
