package com.msrm.threadpool.processing.sync;

import java.io.FileWriter;
import java.io.IOException;

public class SyncFileWriter {

	private FileWriter writer;
	
	private Object lock = new Object();

	public SyncFileWriter(String file) throws IOException {
		writer = new FileWriter(file, true);
	}

	public void write(String content) throws IOException {
		writer.append(content);
	}

	public void writeNewLine(String content) throws IOException {
//		synchronized (SyncFileWriter.class) {
		synchronized (lock) {
//		synchronized (this) {
			write(content);
			write(System.getProperty("line.separator"));
			writer.flush();
		}
	}

	public void close() throws IOException {
		writer.close();
	}

}
