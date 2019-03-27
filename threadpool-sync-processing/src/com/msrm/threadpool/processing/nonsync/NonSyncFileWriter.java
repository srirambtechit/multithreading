package com.msrm.threadpool.processing.nonsync;

import java.io.FileWriter;
import java.io.IOException;

public class NonSyncFileWriter {

	private FileWriter writer;

	public NonSyncFileWriter(String file) throws IOException {
		writer = new FileWriter(file, true);
	}

	public void write(String content) throws IOException {
		writer.append(content);
	}

	public void writeNewLine(String content) throws IOException {
		writer.append(content);
		writer.append(System.getProperty("line.separator"));
		writer.flush();
	}

	public void close() throws IOException {
		writer.close();
	}

}
