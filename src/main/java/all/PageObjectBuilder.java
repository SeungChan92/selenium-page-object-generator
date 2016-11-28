package all;

import org.jsoup.select.Elements;

import infra.Config;

public class PageObjectBuilder {

	private static FileString fileString;
	private static PageParser pageParser;

	public static void init() {
		fileString = new FileString();
		pageParser = new PageParser(Config.get("baseUrl") + Config.get("lastUrl"));
	}
	public static void build() {
		attachPieceOfPage(1);

		fileString.attach(JavaGenerator.generateFunction_goToPage());

		fileString.attachNewLine();
		attachWebElements("input", "text");
		attachWebElements("input", "password");
		attachWebElements("button");
	}
	public static FileString getFileString() {
		return fileString;
	}

	// depth 1
	private static void attachWebElements(String tagName) {

		Elements elements = pageParser.getElements(tagName);

		for(int i=0; i<elements.size(); i++)
		{
			fileString.attach(JavaGenerator.generateWebElement(
					elements.get(i).attr("id"), elements.get(i).tagName()));
		}
	}
	private static void attachWebElements(String tagName, String type) {

		Elements elements = pageParser.getElements(tagName, type);

		for(int i=0; i<elements.size(); i++)
		{
			fileString.attach(JavaGenerator.generateWebElement(
					elements.get(i).attr("id"), elements.get(i).tagName()));
		}
	}
	private static void attachPieceOfPage(int pieceNumber) {
		fileString.attachNewFile(Config.get("piecesOfPageFolder") + "/" 
				+ pieceNumber);
	}
}
