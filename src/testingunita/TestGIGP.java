package testingunita;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingIntegrazione.ImpGestioneInterazioneTutorStudenteTest;

public class TestGIGP {
	
	public static void main(String[] args) {
		TestRunner.run(TestGIGP.suite());
	}
	
	public static Test suite() {
		TestSuite test=new TestSuite();
		test.addTest(ImpGestioneInterazioneTutorStudenteTest.suite());
		test.addTest(TestGP.suite());
		return test;
	}
}
