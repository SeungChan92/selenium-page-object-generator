
public class Main {

	public static void main(String[] args) {

		Main.crawl();
		Main.generatePageObjectFile();
	}

	// depth 1
	private static void generatePageObjectFile() {
		
	}
	private static void crawl() {

		try {
			crawl.Controller.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
