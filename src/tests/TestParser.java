package tests;

import model.TaskHypergraph;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import controller.TaskHypergraphParser;


public class TestParser {
	
	private static final String HGTESTDIR = "./tests/hg_examples/";
	private TaskHypergraphParser parser;
	private LinkedList<String> hgReps;
	
	private static String readFileAsString(File file) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(file));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
	@Before
	public void initialize() throws IOException {
		parser = new TaskHypergraphParser();
		hgReps = new LinkedList<>();
		File f = new File("/home/santi698/workspace/TP Hipergrafo/src/tests/hg_examples");
		assertTrue(f.exists());
		File[] files = f.listFiles();
		for (File file : files) {
			if (!file.isDirectory() && file.getName().endsWith(".hg")) {
				String data = readFileAsString(file);
				hgReps.add(data);
			}
		}
	}
	
	@Test
	public void testParse() {
		for (String hg : hgReps) {
			TaskHypergraph graph = parser.parse(hg);
			String unparsed = graph.getHgRep();
			assertEquals(hg.trim(), unparsed.trim());
		}
	}
}
