package br.edu.unisinos;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Scanner;

import br.edu.unisinos.lcloudlet.api.Cloudlet;
import br.edu.unisinos.lcloudlet.api.MimeType;

/**
 * Test class used as an example of usage of the Cloudlet.
 */
public class NumbersSumCounter { private static long localExecutionTreshold = 500; 
	private Cloudlet cloudlet;

	/**
	 * Instantiates a new numbers sum counter.
	 *
	 * @throws UnknownHostException the unknown host exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public NumbersSumCounter() throws UnknownHostException, IOException {
		cloudlet = new Cloudlet("localhost");
	}

	/**
	 * Starts the test program.
	 */
	private void start() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nEnter N: ");
			long n = Long.valueOf(scanner.nextLine());

			if (n == -1) {
				break;
			}

			long startTime = System.currentTimeMillis();

			long qttNumbersSumUpToFive;
			if (n < localExecutionTreshold) {
				qttNumbersSumUpToFive = countNumbersSumupTo(n, 5L);
				System.out.println("Executed locally.");
			} else {
				qttNumbersSumUpToFive = countNumbersSumupToRemotely(n);
				System.out.println("Executed remotelly on " + cloudlet);
			}

			System.out.println("Total quantity of numbers between 0 and " + n + " that sum up to 5: " + qttNumbersSumUpToFive);
			System.out.println("Total execution time: " + (System.currentTimeMillis() - startTime) + "ms");
		}
		scanner.close();
	}

	/**
	 * Test method that executes in O(n^2).
	 *
	 * @param n the n
	 * @return the long
	 */
	private long countNumbersSumupToRemotely(Long n) {
		if (!cloudlet.checkService("numberCounter")) {
			cloudlet.registerService("numberCounter", this.getClass(), MimeType.APPLICATION_JAVA);
		}
		return Long.valueOf(cloudlet.executeService("numberCounter", "countNumbersSumupTo", n, 5L));
	}

    /**
     * Counts the quantity of numbers between 0 an N that sum up to the targetNumber.
     * @param n N
     * @param targetNumber The targe number.
     * @return the quantity of numbers between 0 an N that sum up to the targetNumber.
     */
    public long countNumbersSumupTo(Long n, Long targetNumber) {
        long count = 0;
        for (long i = 0; i < n; i++){
            for (long k = 0; k < n; k++){
                if(i + k == 5){
                    count++;
                }
            }
        }

        return count;
    }

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws UnknownHostException the unknown host exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		new NumbersSumCounter().start();
	}

	/**
	 * Gets the JS service code.
	 *
	 * @return the JS service code
	 */
	public String getJSServiceCode() {
		try {
			return new String(
					Files.readAllBytes(FileSystems.getDefault().getPath("offloadable_code/PrimeNumbersCounter.js")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}