package webworks.io;

import net.rim.device.api.script.ScriptableFunction;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.system.JPEGEncodedImage;
import webworks.io.ImageUtils.FileUtils;

public class FunctionScale extends ScriptableFunction {

	public static final String NAME = "scale";
	
	public static final int FILTER_LANCZOS = Bitmap.FILTER_LANCZOS;
	public static final int FILTER_BOX = Bitmap.FILTER_BOX;
	public static final int FILTER_BILINEAR = Bitmap.FILTER_BILINEAR;

	public Object invoke(Object thiz, Object[] args) throws Exception {
		if (args.length >= 3) {
			String path = (String) args[0];
			int newWidth = ((Integer) args[1]).intValue();
			int newHeight = ((Integer) args[2]).intValue();
			int filter = FILTER_LANCZOS;
			
			String newFile = path;
			
			if (args.length >= 4 && !args[3].equals(UNDEFINED)) {
				filter = ((Integer) args[3]).intValue();
			}
			
			if (args.length == 5 && !args[4].equals(UNDEFINED)) {
				newFile = (String) args[4];
			}
			
			byte[] data = FileUtils.getFileByteArray(path);
			
			Bitmap b = Bitmap.createBitmapFromBytes(data, 0, data.length, 1);
			data = null;
			
			Bitmap nb = new Bitmap(newWidth, newHeight);
			b.scaleInto(nb, filter);
			
			JPEGEncodedImage jei = JPEGEncodedImage.encode(nb, 100);
			
			FileUtils.writeFileByteArray(newFile, jei.getData());
			
			b = null;
			jei = null;
		}
		return null;
	}
}
