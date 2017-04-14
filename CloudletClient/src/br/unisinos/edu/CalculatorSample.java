package br.unisinos.edu;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CalculatorSample {
	private static long threshold = 300;
	
	private CloudletInterface cloudletInterface;
	
	public CalculatorSample() throws UnknownHostException, IOException{
		cloudletInterface = new CloudletInterface("localhost");
	}
	
	private String offloadableCode = 
			"function heavyAlgorithm(n) {"
		+ "var result = n;"
	+ "for (var i = 0; i < n; i++) {"
			+ "for (var j = 0; j < n; j++) {"
					+ "result = (result * i + j) % n;"
			+ "}"
		+ "}"
		+ "return result;"
	 + "}";

	private void start() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			long pow = Long.valueOf(scanner.nextLine());

			
			long startTime = System.currentTimeMillis();
			
			if (pow < threshold) {
				System.out.println(heavyAlgorithm(pow));
			} else {
				System.out.println(remotePow(pow));
			}
			
			long endTime   = System.currentTimeMillis();
			System.out.println("Total time: " + (endTime - startTime));
		}
	}

	private double remotePow(long n) {
		cloudletInterface.registerService("heavyAlgorithm", "heavyAlgorithm", offloadableCode, "application/javascript");
		return Double.valueOf(cloudletInterface.executeService("heavyAlgorithm", n));
	}
	
	private double heavyAlgorithm(long n) {
		double result = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
					result = (result * i + j) % n;
			}
		}
		return result;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new CalculatorSample().start();
	}
}