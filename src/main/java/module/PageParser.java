package module;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PageParser {

	private Document document;
	
	public PageParser(String html) {
		document = Jsoup.parse(html);
	}
	public Elements getElements(String tagName) {
		return this.document.select(tagName + "[id~=.+]");
	}
	public Elements getElements(String tagName, String type) {
		return this.document.select(tagName + "[type=" + type + "]" + "[id~=.+]");
	}
}
