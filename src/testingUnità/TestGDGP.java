package testingUnità;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingIntegrazione.ImpGestioneDomandaTest;


public class TestGDGP {
	
	public static void main(String[] args) {
		TestRunner.run(TestGDGP.suite());
	}
	
	public static Test suite() {
		TestSuite test=new TestSuite();
		test.addTest(TestGP.suite());
		test.addTest(ImpGestioneDomandaTest.suite());
		return test;
	}
}
