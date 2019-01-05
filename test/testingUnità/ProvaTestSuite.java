package testingUnità;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class ProvaTestSuite {

	public static void main(String[] args) {
		Test test=ProvaTestSuite.suite();
		TestRunner.run(test);
	}
	
	private static Test suite() {
		TestSuite suite=new TestSuite();
		suite.addTest(RispostaDaoImpTest.suite());
		suite.addTest(DomandaDAOImpTest.suite());
		suite.addTest(StudenteDAOImpTest.suite());
		suite.addTest(TutorDAOImpTest.suite());
		suite.addTest(FactoryDAOTest.suite());
		return suite;
	}
}
