package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.select.Elements;

import data.FileString;
import infra.Config;
import module.JavaGenerator;
import module.PageParser;

public class PageObjectBuilder {

	private static FileString fileString;
	private static PageParser pageParser;

	public static void init() {
		String html = "";
		
		fileString = new FileString();
		html = readHtml();
		pageParser = new PageParser(html);
	}
	public static void build() {

		attachPieceOfPage(1);

		fileString.attach(JavaGenerator.generateFunction_goToPage());

		fileString.attachNewLine();
		attachWebElements(pageParser.getElements("input", "text"));
		attachWebElements(pageParser.getElements("input", "password"));
		
		fileString.attachNewLine();
		attachWebElements(pageParser.getElements_button());

		fileString.attachNewLine();
		attachFunctions_type(pageParser.getElements("input", "text"));
		attachFunctions_type(pageParser.getElements("input", "password"));
		
		fileString.attachNewLine();
		attachFunctions_click(pageParser.getElements_button());
		
		attachPieceOfPage(2);
	}
	public static FileString getFileString() {
		return fileString;
	}

	// depth 1
	private static String readHtml() {
		String fileString = "";

		try {
			BufferedReader in = new BufferedReader(new FileReader(
					Config.get("htmlFile")));
			String line;

			while ((line = in.readLine()) != null) {
				fileString += line += "\n";
			}
			in.close();

		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}

		return fileString;
	}
	
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
