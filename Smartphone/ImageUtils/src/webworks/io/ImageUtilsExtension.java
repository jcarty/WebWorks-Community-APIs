package webworks.io;

import net.rim.device.api.browser.field2.BrowserField;
import net.rim.device.api.script.ScriptEngine;
import net.rim.device.api.web.WidgetConfig;
import net.rim.device.api.web.WidgetExtension;

import org.w3c.dom.Document;

import webworks.io.ImageUtils.Logger;

public class ImageUtilsExtension implements WidgetExtension {

	public String[] getFeatureList() {
		return new String[] { ImageUtilsNamespace.NAME };
	}

	public void loadFeature(String feature, String version, Document doc,
			ScriptEngine scriptEngine) throws Exception {
		
		if (feature.equals(ImageUtilsNamespace.NAME)) {
			Logger.enableLogging(0xe995515474f898fbL, "webworks.io.ImageUtils");
			scriptEngine.addExtension(feature, new ImageUtilsNamespace());
		}		
	}

	public void register(WidgetConfig arg0, BrowserField arg1) {
	}

	public void unloadFeatures(Document arg0) {
	}

}
