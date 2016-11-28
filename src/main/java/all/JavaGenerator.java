package all;

import infra.Config;

public class JavaGenerator {

	private static String javaLines;
	
	public static String generateFunction_goToPage() {
		
		javaLines = "";

		addLine("	public static void goToPage() {");
		addLine("		Tool.goToPage(\"" + Config.get("lastUrl") + "\");");
		addLine("	}");
		
		return javaLines;
	}
	public static String generateWebElement(String id, String tagName) {
		
		javaLines = "";

		addLine("	@FindBy(id = \"" + id + "\")");
		addLine("	private WebElement " + tagName + "_" + id + ";");
		
		return javaLines;
	}

	private static void addLine(String line) {
		javaLines += line + "\n";
	}
}
