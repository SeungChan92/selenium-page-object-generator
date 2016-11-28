import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import infra.Config;

public class Main {

	private static Elements inputs;
	private static Elements buttons;

	public static void main(String[] args) {

		Config.init();
		Main.parsePage();
		Main.generatePageObjectFile();
	}

	// depth 1
	private static void parsePage() {

		Document doc = null;

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

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(Config.get("targetFile")));
			String s = "출력 파일에 저장될 이런 저런 문자열입니다.";

			out.write(s); out.newLine();
			out.write(s); out.newLine();

			out.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}
