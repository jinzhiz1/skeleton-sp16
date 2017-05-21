import java.math.*;

//Test pairwise force
public class TestPlanet {

	/*
	 * Test checkPlanet
	 */
	public static void main(String[] args) {
		checkPlanet();
	}
	/**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label   Label for the 'test' case
     *  @param  eps     Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /*
     * chech the pairwise force
     */
	private static void checkPlanet() {
		System.out.println("Checking pairwise force...");

		Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
		Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

		checkEquals(p1.calcForceExertedBy(p3), 6.67e-11, "TestPlanet()", 0.01);
	}
}