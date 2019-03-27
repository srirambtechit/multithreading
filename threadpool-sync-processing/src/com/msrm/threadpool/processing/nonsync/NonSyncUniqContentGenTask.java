package com.msrm.threadpool.processing.nonsync;

import java.io.IOException;

public class NonSyncUniqContentGenTask implements Runnable {

	private String content;

	public NonSyncUniqContentGenTask(String content) {
		this.content = content;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " : " + content);
		String constant = "String";
		String file = "data.txt";
		int startIndex = constant.length();
		String uniqueNumber = content.substring(startIndex);
//		try {
			try {
				NonSyncFileWriter writer = new NonSyncFileWriter(file );
				writer.writeNewLine(uniqueNumber);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			Thread.sleep((long) (Math.random() * 1000));
//		} catch (InterruptedException | IOException e) {
//			e.printStackTrace();
//		}
	}

}
