import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.nio.CharBuffer;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import controller.TaskHypergraphParser;


public class TestParser {
	TaskHypergraphParser parser;
	LinkedList<String> hgReps;
	const HGTESTSDIR = "hg_examples/";
	@Before
	public void initialize() {
		parser = new TaskHypergraphParser();
		File f = new File(HGTESTDIR);
		File[] files = f.listFiles();
		for (File file : files) {
			if (file.getName().endsWith(".hg")) {
				FileReader reader = new FileReader(file);
				CharBuffer target = new CharBuffer();
				reader.read(target);
				hgReps.add(target.toString());
			}
		}
	}
	@Test
	public void test() {
		
	}

}
