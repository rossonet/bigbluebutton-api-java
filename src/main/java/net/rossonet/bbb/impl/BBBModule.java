package net.rossonet.bbb.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

/**
 * Java class that stores that modules configuration to be used for create
 * BigBlueButton meeting. See the following url for more details
 * https://github.com/mconf/bigbluebutton-api-ruby/blob/master/lib/bigbluebutton_modules.rb
 *
 * @author Yunkai Wang
 */
public class BBBModule {

	public enum PresentationType {
		base64, file, url;
	}

	private final Map<String, String> presentation_base64s = new HashMap<String, String>();
	private final LinkedList<String> presentation_files = new LinkedList<String>();
	private final LinkedList<String> presentation_urls = new LinkedList<String>();

	public void add_presentation(final PresentationType type, final String value) {
		add_presentation(type, value, "");
	}

	public void add_presentation(final PresentationType type, final String value, final String name) {
		switch (type) {
		case url:
			presentation_urls.add(value);
			return;
		case file:
			presentation_files.add(value);
			return;
		case base64:
			presentation_base64s.put(name, value);
			return;
		}
	}

	private boolean has_presentation() {
		return !(presentation_urls.isEmpty() && presentation_files.isEmpty() && presentation_base64s.isEmpty());
	}

	private String presentations_to_xml() throws IOException {
		String xml = "<module name=\"presentation\">";
		for (final String url : presentation_urls)
			xml += String.format("<document url=\"%s\" />", url);
		for (final Map.Entry<String, String> entry : presentation_base64s.entrySet()) {
			xml += String.format("<document name=\"%s\">", entry.getKey());
			xml += entry.getValue();
			xml += "</document>";
		}

		for (final String fileName : presentation_files) {
			final File f = new File(fileName);
			xml += String.format("<document name=\"%s\">", f.getName());
			final FileReader fr = new FileReader(fileName);
			final BufferedReader br = new BufferedReader(fr);
			String file = "";
			String line = "";
			while ((line = br.readLine()) != null)
				file += line + "\n";
			br.close();
			final byte[] bytes = Base64.encodeBase64(file.getBytes());
			for (final byte b : bytes)
				xml += (char) b;
			xml += "</document>";
		}
		xml += "</module>";
		return xml;
	}

	public String to_xml() throws IOException {
		if (!has_presentation())
			return "";
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><modules>";
		xml += presentations_to_xml();
		xml += "</modules>";
		return xml;
	}
}
