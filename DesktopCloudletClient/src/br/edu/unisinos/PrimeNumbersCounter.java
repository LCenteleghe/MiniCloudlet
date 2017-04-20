package br.edu.unisinos;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Scanner;

import br.edu.unisinos.lcloudlet.api.Cloudlet;
import br.edu.unisinos.lcloudlet.api.MimeType;

public class PrimeNumbersCounter {
	private static long localExecutionTreshold = 500;

	private Cloudlet cloudlet;

	public PrimeNumbersCounter() throws UnknownHostException, IOException {
		cloudlet = new Cloudlet("localhost");
	}

	private void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			long n = Long.valueOf(scanner.nextLine());

			if (n == -1) {
				break;
			}

			long startTime = System.currentTimeMillis();

			if (n < localExecutionTreshold) {
				System.out.println(countPrimeNumbers(n));
			} else {
				System.out.println(remoteHeavyAlgorithm(n));
			}

			long endTime = System.currentTimeMillis();
			System.out.println("Total time: " + (endTime - startTime));
		}
		scanner.close();
	}

	private double remoteHeavyAlgorithm(Long n) {
		// cloudlet.registerService("heavyAlgorithm", "heavyAlgorithm",
		// offloadableJSCode, MimeType.APPLICATION_JAVASCRIPT);
		if (!cloudlet.checkService("primeCounter")) {
			cloudlet.registerService("primeCounter", getJSServiceCode(), MimeType.APPLICATION_JAVASCRIPT);
		}
		return Double.valueOf(cloudlet.executeService("primeCounter", "countPrimeNumbers", n));
	}

	public double countPrimeNumbers(Long n) {
		long count = 0;
		for (long i = 0; i < n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	public boolean isPrime(Long number) {
		for (long i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		new PrimeNumbersCounter().start();
	}

	public String getJSServiceCode() {
		try {
			return new String(Files.readAllBytes(FileSystems.getDefault().getPath("offloadable_code/PrimeNumbersCounter.js")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}