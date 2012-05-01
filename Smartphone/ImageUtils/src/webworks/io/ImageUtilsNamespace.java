package webworks.io;

import net.rim.device.api.script.Scriptable;

public class ImageUtilsNamespace extends Scriptable {
		
	public static final String NAME = "webworks.io.ImageUtils";
	
	private static final String FIELD_GET_METADATA = FunctionGetMetaData.NAME;
	private static final String FIELD_ROTATE = FunctionRotate.NAME;
	private static final String FIELD_SCALE = FunctionScale.NAME;
	
	private FunctionRotate _rotateFunction;
	private FunctionGetMetaData _getMetadataFunction;
	private FunctionScale _scaleFunction;
	
	public ImageUtilsNamespace() {
		_getMetadataFunction = new FunctionGetMetaData();
		_rotateFunction = new FunctionRotate();
		_scaleFunction = new FunctionScale();
	}

    public Object getField(String name) throws Exception {
        if (name.equals(FIELD_GET_METADATA)) {
            return _getMetadataFunction;
        }
        if (name.equals(FIELD_ROTATE)) {
            return _rotateFunction;
        }
        if (name.equals(FIELD_SCALE)) {
            return _scaleFunction;
        }
		return super.getField(name);
    }

}
