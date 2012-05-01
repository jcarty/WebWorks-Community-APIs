package webworks.io;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.microedition.media.control.MetaDataControl;

import net.rim.device.api.script.Scriptable;
import net.rim.device.api.script.ScriptableFunction;
import net.rim.device.api.system.JPEGEncodedImage;
import webworks.io.ImageUtils.FileUtils;
import webworks.io.ImageUtils.Logger;

public class FunctionGetMetaData extends ScriptableFunction {

	public static final String NAME = "getMetaData";

	public Object invoke(Object thiz, Object[] args) throws Exception {
		if (args.length == 1) {
			ReturnObject s = new ReturnObject();
			
			String filePath = (String) args[0];
			byte[] og = FileUtils.getFileByteArray(filePath);
			
			JPEGEncodedImage jei = (JPEGEncodedImage) JPEGEncodedImage.createEncodedImage(og, 0, -1);
			MetaDataControl m = jei.getMetaData();	
			jei = null;
			
			if (m != null) {
				String[] keys = m.getKeys();
				String key;
				
				int count = keys.length;
				
				Logger.info("Metadata keys: " + count);
				
				for (int i=count-1; i >= 0; i--) {
					key = keys[i];
					s.putField(key, m.getKeyValue(key));
				}
			
			}
			
			return s;
		}
		return null;
	}
	
	private class ReturnObject extends Scriptable {
		private Hashtable _data = new Hashtable();
		
		public void enumerateFields(Vector v) {
			Enumeration e = _data.keys();
			
			while (e.hasMoreElements()) {
				v.addElement(e.nextElement().toString());
			}
		}

		public Object getField(String name) throws Exception {
			return _data.get(name);
		}

		public boolean putField(String name, Object value) throws Exception {
			_data.put(name, value);
			return true;
		}
		
		
	}

}
