package testingunita;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class ProvaTestSuite {
  
  public static void main(String[] args) {
    ResetDataBase reset = new ResetDataBase();
    reset.resetDataBase();
    TestRunner.run(ProvaTestSuite.suite());
  }

  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(TestGIGP.suite());
    test.addTest(TestGUGp.suite());
    test.addTest(TestGDGP.suite());
    return test;
  }
}