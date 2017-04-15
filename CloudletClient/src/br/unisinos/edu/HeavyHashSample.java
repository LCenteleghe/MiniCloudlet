package br.unisinos.edu;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.edu.unisinos.lcloudlet.api.Cloudlet;
import br.edu.unisinos.lcloudlet.api.MimeType;

public class HeavyHashSample {
	private static long localExecutionTreshold = 300;

	private Cloudlet cloudlet;

	public HeavyHashSample() throws UnknownHostException, IOException {
		cloudlet = new Cloudlet("localhost");
	}

	private String offloadableJSCode = "function heavyAlgorithm(n) {" + "var result = n;"
			+ "for (var i = 0; i < n; i++) {" + "for (var j = 0; j < n; j++) {" + "result = (result * i + j) % n;" + "}"
			+ "}" + "return result;" + "}";

	private void start() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			long n = Long.valueOf(scanner.nextLine());

			long startTime = System.currentTimeMillis();

			if (n < localExecutionTreshold) {
				System.out.println(heavyAlgorithm(n));
			} else {
				System.out.println(remoteHeavyAlgorithm(n));
			}

			long endTime = System.currentTimeMillis();
			System.out.println("Total time: " + (endTime - startTime));

		}
	}

	private double remoteHeavyAlgorithm(Long n) {
		// cloudlet.registerService("heavyAlgorithm", "heavyAlgorithm",
		// offloadableJSCode, MimeType.APPLICATION_JAVASCRIPT);
		if (!cloudlet.checkService("heavyAlgorithm")) {
			cloudlet.registerService("heavyAlgorithm", "heavyAlgorithm", this.getClass(), MimeType.APPLICATION_JAVA);
		}
		return Double.valueOf(cloudlet.executeService("heavyAlgorithm", n));
	}

	public double heavyAlgorithm(Long n) {
		double result = n;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = (result * i + j) % n;
			}
		}
		return result;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new HeavyHashSample().start();
	}
}