function countPrimeNumbers(n) {
	var count = 0;
	for (var i = 0; i < n; i++) {
		if (isPrime(i)) {
			count++;
		}
	}
	return count;
}

function isPrime(number) {
	for (var i = 2; i < number; i++) {
		if (number % i === 0) {
			return false;
		}
	}

	return true;
}