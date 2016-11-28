import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import infra.Config;

public class Main {

	private static Elements inputs;
	private static Elements buttons;
	
	public static void main(String[] args) {

		Main.parsePage();
		Main.generatePageObjectFile();
	}

	// depth 1
	private static void parsePage() {

		Document doc = null;
		
		Config.init();
		
		try {
			doc = Jsoup.connect(Config.get("baseUrl") + Config.get("lastUrl")).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		inputs = doc.select("input[type=text][id~=.+]");
		buttons = doc.select("button[id~=.+]");
		buttons.addAll(doc.select("input[type=button][id~=.+]"));
	}
	private static void generatePageObjectFile() {
		for(int i=0; i < inputs.size(); i++)
		{
			System.out.println(inputs.get(i).attr("id"));
		}
		for(int i=0; i < buttons.size(); i++)
		{
			System.out.println(buttons.get(i).attr("id"));
		}
	}
}
