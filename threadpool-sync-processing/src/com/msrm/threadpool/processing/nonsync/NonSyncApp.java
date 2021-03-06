package com.msrm.threadpool.processing.nonsync;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NonSyncApp {

	public static void main(String[] args) {
		int threadSize = 100;
		int taskLimit = 10000;
		String file = "data.txt";
		
		try {
			Files.deleteIfExists(Paths.get(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<String> contents = IntStream.iterate(1, i -> i + 1)
			.limit(taskLimit)
			.mapToObj(i -> "String" + i)
			.collect(Collectors.toList());
		
		ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
		contents.forEach(content -> {
			threadPool.execute(new NonSyncUniqContentGenTask(content));
		});
		
		threadPool.shutdown();
		try {
			threadPool.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("App exited");
	}

}
