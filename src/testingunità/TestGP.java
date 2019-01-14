package testingunità;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class TestGP {
	public static void main(String[] args) {
		TestRunner.run(TestGP.suite());
	}
	
	public static Test suite() {
		TestSuite test = new TestSuite();
		test.addTest(StudenteDAOImpTest.suite());
		test.addTest(TutorDAOImpTest.suite());
		test.addTest(DomandaDAOImpTest.suite());
		test.addTest(RispostaDaoImpTest.suite());
		return test;
	}
}
