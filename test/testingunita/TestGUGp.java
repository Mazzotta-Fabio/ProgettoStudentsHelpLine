package testingunita;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingintegrazione.ImpGestioneUtenteTest;

public class TestGUGp {

  public static void main(String[] args) {
    TestRunner.run(TestGUGp.suite());
  }
  
  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(ImpGestioneUtenteTest.suite());
    test.addTest(TestGP.suite());
    return test;
  }
}
