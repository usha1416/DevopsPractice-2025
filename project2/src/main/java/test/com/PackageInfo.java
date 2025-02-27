package test.com;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import javax.servlet.ServletContext;

/**
 * This is a sample class that you can use to get package information on
 * runtime.
 */
public class PackageInfo {
	private static PackageInfo instance = null;
	private Attributes manifestAttrs = null;
	private ServletContext context = null;

	protected PackageInfo() {
		readManifestEntries();
	}

	protected PackageInfo(ServletContext context) {
		this.context = context;
		readManifestEntries();
	}

	public static PackageInfo getInstance() {
		if (instance == null) {
			instance = new PackageInfo();
		}

		return instance;
	}

	public static PackageInfo getInstance(ServletContext context) {
		if (instance == null) {
			instance = new PackageInfo(context);
		}

		return instance;
	}

	public void refresh() {
		readManifestEntries();
	}

	public String getManifestEntry(String entryName) {
		String entryValue = null;

		if (manifestAttrs != null && manifestAttrs.size() > 0) {
			entryValue = manifestAttrs.getValue(entryName);
		}

		return entryValue;
	}

	public String getTitle() {
		return getManifestEntry("Specification-Title");
	}

	public String getName() {
		return getManifestEntry("Implementation-Title");
	}

	public String getVersion() {
		return getManifestEntry("Implementation-Version");
	}

	public String getCode() {
		return getManifestEntry("Package-Code");
	}

	public String getURL() {
		return getManifestEntry("Implementation-URL");
	}

	public String getTechnology() {
		return getManifestEntry("Package-Technology");
	}

	public String getVendorName() {
		return getManifestEntry("Implementation-Vendor");
	}

	public String getVendorURL() {
		return getManifestEntry("Implementation-Vendor-URL");
	}

	public String getVendorID() {
		return getManifestEntry("Implementation-Vendor-Id");
	}

	private void readManifestEntries() {
		InputStream inputStream = null;
		
		try {
			if(context != null) {
				inputStream = context.getResourceAsStream("META-INF/MANIFEST.MF");
				if (inputStream != null) {
					Manifest manifest = new Manifest(inputStream);
					manifestAttrs = manifest.getMainAttributes();
				} else {
					System.err.println("Input stream for context is null.");
				}
			} else {
				inputStream = getClass().getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF");
				if (inputStream != null) {
					Manifest manifest = new Manifest(inputStream);
					manifestAttrs = manifest.getMainAttributes();
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
