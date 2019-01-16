package testingintegrazione;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingunita.ImpGestioneDomandaTest;
import testingintegrazione.TestGp;



public class TestGdgp {
  public static void main(String[] args) {
    TestRunner.run(TestGdgp.suite());
  }
  
  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(TestGp.suite());
    test.addTest(ImpGestioneDomandaTest.suite());
    return test;
  }
}
