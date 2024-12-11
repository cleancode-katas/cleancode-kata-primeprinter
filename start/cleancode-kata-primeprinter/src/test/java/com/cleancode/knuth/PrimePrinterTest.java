package com.cleancode.knuth;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimePrinterTest {
    private PrintStream out;

    @BeforeEach
    void setup() throws Exception {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("lead.txt")));
    }

    @AfterEach
    void teardown() {
    	System.out.close();
        System.setOut(out);
        new File("lead.txt").delete();
    }

    @Test
    void makeSureOutputMatchesGold() throws Exception {
        PrimePrinter.main(new String[0]);
        BufferedReader lead = null;
        BufferedReader gold = null;
		try {
			lead = new BufferedReader(new FileReader("lead.txt"));
			gold = new BufferedReader(new FileReader("gold.txt"));
			String line;
			while ((line = gold.readLine()) != null)
				assertEquals(line, lead.readLine());
			assertEquals(null, lead.readLine());
		} finally {
			lead.close();
			gold.close();
		}
    }
}
