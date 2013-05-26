package tests;

import model.TaskHypergraph;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import controller.TaskHypergraphParser;

@RunWith(Parameterized.class)
public class TestParser {
	
	private static final String HGTESTDIR = "./tests/hg_examples/";
	private TaskHypergraphParser parser;
	private String s;
	@Parameters
	public static Collection<Object[]> data () throws IOException {
		LinkedList<String> hgReps = new LinkedList<String>();
		File f = new File("/home/santi698/workspace/TP Hipergrafo/src/tests/hg_examples");
		assertTrue(f.exists());
		File[] files = f.listFiles();
		for (File file : files) {
			if (!file.isDirectory() && file.getName().endsWith(".hg")) {
				String data = readFileAsString(file);
				hgReps.add(data);
			}
		}
		Object[][] aux = new Object[hgReps.size()][1];
		for (int i = 0; i < hgReps.size(); i++) 
			aux[i][0] = hgReps.get(i);
		return Arrays.asList(aux);
	}
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
	public TestParser(String s) {
		this.s = s;
	}
	@Before
	public void initialize() throws IOException {
		parser = new TaskHypergraphParser();
	}
	
	@Test
	public void testParse() {
		TaskHypergraph graph = parser.parse(s);
		String unparsed = graph.getHgRep();
		assertEquals(s.trim(), unparsed.trim());
	}
}
