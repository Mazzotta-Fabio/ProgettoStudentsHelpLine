package testingintegrazione;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingunita.ImpGestioneInterazioneTutorStudenteTest;


public class TestGigp {

  public static void main(String[] args) {
    TestRunner.run(TestGigp.suite());
  }
  
  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(ImpGestioneInterazioneTutorStudenteTest.suite());
    test.addTest(TestGp.suite());
    return test;
  }
}
