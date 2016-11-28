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
		attachWebElements(pageParser.getElements("input", "text"));
		attachWebElements(pageParser.getElements("input", "password"));
		attachWebElements(pageParser.getElements("button"));

		fileString.attachNewLine();
		attachFunctions_type(pageParser.getElements("input", "text"));
		attachFunctions_type(pageParser.getElements("input", "password"));
		attachFunctions_click(pageParser.getElements("button"));
		
		attachPieceOfPage(2);
	}


	public static FileString getFileString() {
		return fileString;
	}

	// depth 1
	private static void attachWebElements(Elements elements) {

		for(int i=0; i<elements.size(); i++)
		{
			fileString.attach(JavaGenerator.generateWebElement(
					elements.get(i).attr("id"), elements.get(i).tagName()));
		}
	}
	private static void attachFunctions_type(Elements elements) {

		for(int i=0; i<elements.size(); i++)
		{
			fileString.attach(JavaGenerator.generateFunction_type(
					elements.get(i).attr("id"), elements.get(i).tagName()));
		}
	}
	private static void attachFunctions_click(Elements elements) {

		for(int i=0; i<elements.size(); i++)
		{
			fileString.attach(JavaGenerator.generateFunction_click(
					elements.get(i).attr("id"), elements.get(i).tagName()));
		}
	}
	private static void attachPieceOfPage(int pieceNumber) {
		fileString.attachNewFile(Config.get("piecesOfPageFolder") + "/" 
				+ pieceNumber);
	}
}
