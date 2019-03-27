package com.msrm.threadpool.processing.sync;

import java.io.IOException;

public class SyncUniqContentGenTask implements Runnable {

	private SyncFileWriter writer;
	private String content;

	public SyncUniqContentGenTask(SyncFileWriter writer, String content) {
		this.writer = writer;
		this.content = content;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + content);
		String constant = "String";
		int startIndex = constant.length();
		String uniqueNumber = content.substring(startIndex);
//		try {
			try {
				writer.writeNewLine(uniqueNumber);
			} catch (IOException e) {
				e.printStackTrace();
			}
//			Thread.sleep((long) (Math.random() * 1000));
//		} catch (InterruptedException | IOException e) {
//			e.printStackTrace();
//		}
	}

}
