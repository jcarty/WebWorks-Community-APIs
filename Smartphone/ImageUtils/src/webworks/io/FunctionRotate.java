package webworks.io;

import net.rim.device.api.script.ScriptableFunction;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.JPEGEncodedImage;
import webworks.io.ImageUtils.FileUtils;
import webworks.io.ImageUtils.ImageManipulator;


public class FunctionRotate extends ScriptableFunction {

	public static final String NAME = "rotate";

	public Object invoke(Object thiz, Object[] args) throws Exception {
		if (args.length >= 2) {
			String path = (String) args[0];
			int angle = ((Integer) args[1]).intValue();
			
			String newFile = path;
			
			if (args.length == 3 && !args[2].equals(UNDEFINED)) {
				newFile = (String) args[2];
			}
			
			byte[] data = FileUtils.getFileByteArray(path);
			
			Bitmap b = Bitmap.createBitmapFromBytes(data, 0, data.length, 1);
			data = null;
			
			b = ImageManipulator.rotate(b, angle);
			JPEGEncodedImage jei = JPEGEncodedImage.encode(b, 100);
			
			FileUtils.writeFileByteArray(newFile, jei.getData());
			
			b = null;
			jei = null;
		}
		return null;
	}
	
}
