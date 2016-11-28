package all;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import infra.Config;

public class FileString {

	String fileString;
	
	public FileString() {
		fileString = "";
	}

	public void makeFile() {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(Config.get("targetFile")));

			out.write(fileString);
			out.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
	public void attach(String string) {
		this.fileString += string;
	}
	public void attachNewLine() {
		this.fileString += "\n";
	}
	public void attachNewFile(String filePath) {
		String newFileString = readFile(filePath);
		fileString += newFileString;
	}
	
	private String readFile(String filePath) {
		String fileString = "";

		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
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
}
