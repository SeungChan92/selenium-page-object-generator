package module;

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
	public static String generateFunction_type(String id, String tagName) {

		javaLines = "";

		addLine("	public Page type_"+ id +"(String " + id +") {");
		addLine("");
		addLine("		this." + tagName + "_" + id + ".sendKeys(" + id + ");");
		addLine("");
		addLine("		return this;");
		addLine("	}");

		return javaLines;
	}
	public static String generateFunction_click(String id, String tagName) {

		javaLines = "";

		addLine("	public Page click_"+ id +"() {");
		addLine("");
		addLine("		this." + tagName + "_" + id + ".click();");
		addLine("");
		addLine("		return this;");
		addLine("	}");

		return javaLines;
	}

	private static void addLine(String line) {
		javaLines += line + "\n";
	}
}
