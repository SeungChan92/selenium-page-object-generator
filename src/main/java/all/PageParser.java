package all;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import infra.Config;

public class PageParser {

	private String url;
	private Document document;
	
	public PageParser(String url) {
		this.url = url;
		this.parsePage();
	}
	public Elements getElements(String tagName) {
		return this.document.select(tagName + "[id~=.+]");
	}
	public Elements getElements(String tagName, String type) {
		return this.document.select(tagName + "[type=" + type + "]" + "[id~=.+]");
	}
	
	// depth 1
	private void parsePage() {

		try {
			document = Jsoup.connect(this.url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		inputs = doc.select("input[type=text][id~=.+]");
//		buttons = doc.select("button[id~=.+]");
//		buttons.addAll(doc.select("input[type=button][id~=.+]"));
	}
}
