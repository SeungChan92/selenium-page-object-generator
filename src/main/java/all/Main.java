package all;

import org.jsoup.select.Elements;

import infra.Config;

public class Main {

	private static Elements inputs;
	private static Elements buttons;

	public static void main(String[] args) {

		FileString pageObjcetFileString = null;
		
		Config.init();
		
		PageObjectBuilder.init();
		PageObjectBuilder.build();
		pageObjcetFileString = PageObjectBuilder.getFileString();
		pageObjcetFileString.makeFile();
	}
}
