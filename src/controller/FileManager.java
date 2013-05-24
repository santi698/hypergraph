package controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	public static String getFileContents (String filepath) throws IOException{
		File f = new File(filepath);
		FileReader reader = new FileReader(f);
		char[] buffer = {};
		reader.read(buffer);
		reader.close();
		String s = new String(buffer);
		return s;
	}
	public static void createFileWithContent(String filename, String str) throws IOException {
		FileWriter writer = new FileWriter(filename);
		writer.write(str);
		writer.close();
	}

}
