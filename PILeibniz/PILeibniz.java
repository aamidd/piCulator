public class PILeibniz {
	public static void main(String[] args) {
		double m = 4;
		double pi = 0;
		for (int i = 1; i < Integer.MAX_VALUE; i+=2) {
			pi += m/i;
			m = -m;
		}
		System.out.println(pi);
	}
}
