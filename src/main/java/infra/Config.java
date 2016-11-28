package infra;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Config implements Infra {

	private static JSONObject jsonObject_root = null;

	public static void init() {
		if (!(Config.is_loaded())) {
			Config.load();
		}
	}
	public static String get(String key) {
		String value = null;

		value = (String) jsonObject_root.get(key);

		return value;
	}
	
	// depth 1
	public static void load() {
		
		JSONParser parser = new JSONParser();
		String configFile_path = "src/main/resource/config.json";

		try {
			Object obj;
			obj = parser.parse(new FileReader(configFile_path));
			Config.jsonObject_root = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean is_loaded() {
		boolean loaded = false;

		if (Config.jsonObject_root != null)
		{
			loaded = true;
		}

		return loaded;
	}
}