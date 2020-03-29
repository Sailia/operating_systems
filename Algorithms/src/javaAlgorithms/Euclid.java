package javaAlgorithms;

public class Euclid {
	
	public int gcd (int m, int n) {
		int r = m % n;
		if(r != 0) {
			m = n;
			n = r;
			gcd(m, n);
		}
		return n;
	} 
}
