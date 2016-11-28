package main;

import data.FileString;
import infra.Config;
import module.crawler.Controller;

public class Main {

	public static void main(String[] args) {

		FileString pageObjcetFileString = null;
		
		Config.init();
		
		try {
			Controller.crawl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageObjectBuilder.init();
		PageObjectBuilder.build();
		pageObjcetFileString = PageObjectBuilder.getFileString();
		pageObjcetFileString.makeFile();
	}
}
