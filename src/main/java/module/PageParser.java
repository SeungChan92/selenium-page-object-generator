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
	public Elements getElements_button() {
		Elements buttonElements = new Elements();

		buttonElements.addAll(this.document.select("button[id~=.+]"));
		buttonElements.addAll(this.document.select("[href][id~=.+]"));
		buttonElements.addAll(this.document.select("[id~=.*btn.*]"));
		buttonElements.addAll(this.document.select("[class~=.*btn.*][id~=.+]"));
				
		return buttonElements;
	}
}
