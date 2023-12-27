public class PICulator {

	public static void main(String[] args) {
		System.out.println(calc(0, 0, 1, 1, 15) * 4);
		System.out.println((1 - calcExcess(0, 0, 1, 1, 25)) * 4);
	}

	private static double calc(double x1, double y1, double x2, double y2, int limit) {
		if (limit-- == 0)
			return 0;
		if (isInCircle(x2, y2))
			return (x2 - x1) * (y2 - y1);
		double midX = x1 + (x2 - x1) / 2;
		double midY = y1 + (y2 - y1) / 2;
		return calc(midX, midY, x2, y2, limit)
			+ calc(midX, y1, x2, midY, limit)
			+ calc(x1, y1, midX, midY, limit)
			+ calc(x1, midY, midX, y2, limit);
	}

	private static double calcExcess(double x1, double y1, double x2, double y2, int limit) {
		if (limit-- == 0)
			return 0;
		if (!isInCircle(x1, y1))
			return (x2-x1) * (y2-y1);
		if (isInCircle(x2, y2))
			return 0;

		double midX = (x1+x2) / 2;
		double midY = (y1+y2) / 2;

		return calcExcess(midX, midY, x2, y2, limit)
			+ calcExcess(midX, y1, x2, midY, limit)
			+ calcExcess(x1, y1, midX, midY, limit)
			+ calcExcess(x1, midY, midX, y2, limit);
	}
	private static boolean isInCircle(double x, double y) {
		return (Math.pow(x, 2) + Math.pow(y, 2) < 1);
	}
}
