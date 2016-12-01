package module;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
		Set<Element> hs = new HashSet<>();

		hs.addAll(this.document.select("button[id~=.+]"));
		hs.addAll(this.document.select("[href][id~=.+]"));
		hs.addAll(this.document.select("[id~=.*btn.*]"));
		hs.addAll(this.document.select("[class~=.*btn.*][id~=.+]"));
		
		buttonElements.addAll(hs);
				
		return buttonElements;
	}
}
