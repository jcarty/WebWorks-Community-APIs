# ImageUtils
The ImageUtils extension provides a few utility functions for images such as reading metadata and rotating an image. 

**Author:** [Jerome Carty](https://github.com/jcarty)

## Tested On

* BlackBerry Bold 9900 v7.0.0.353
* BlackBerry Bold 9650 v6.0.0.546

**Requires BlackBerry WebWorks SDK for Smartphones v2.0 or higher**

Have a problem with this extension?  [Log an Issue](https://github.com/blackberry/WebWorks-Community-APIs/issues) or contact the [Author](https://github.com/jcarty)

## How To Configure The Extension For Use

1. Locate your BlackBerry WebWorks SDK for Smartphone extensions directory using your File Explorer.  Default path is _**C:\Program Files\Research In Motion\BlackBerry WebWorks Packager\ext**_

2. Create a new _**webworks.io.ImageUtils**_ directory in the _**ext**_ directory

3. Download the source from this repository and unzip it to a location on your computer

4. Using File Explorer browse to this extension's downloaded source code _**Smartphone\ImageUtils**_

5. Copy the _**library.xml**_ file from the downloaded _**Smartphone\ImageUtils**_ directory to your new _**ext\webworks.io.ImageUtils**_ directory

6. Copy the downloaded _**Smartphone\ImageUtils\src\webworks**_ directory to your new _**ext\webworks.io.ImageUtils\webworks**_ directory

**NOTE:** Be sure to back-up this _**ext\webworks.io.ImageUtils**_ directory in your WebWorks SDK extensions directory before performing a WebWorks SDK upgrade. Simply copy it back into the _**ext**_ directory after you have completed your SDK upgrade.

## Required Feature ID
Whenever you use the below feature id in any of your WebWorks applications this extension will be loaded for use.

    <feature id="webworks.io.ImageUtils" />

## Summary


## Code Example

    function foo()
    {
		var filePath = "file:///SDCard/pictures/image1.jpg";
		var meta = webworks.io.ImageUtils.getMetadata(filePath);
    }

## Usage Information


## Methods


## Change Log
_Empty_