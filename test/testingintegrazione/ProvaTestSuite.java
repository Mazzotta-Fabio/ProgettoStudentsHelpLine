package testingintegrazione;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingunita.ResetDataBase;

public class ProvaTestSuite {
  
  public static void main(String[] args) {
    ResetDataBase reset = new ResetDataBase();
    reset.resetDataBase();
    TestRunner.run(ProvaTestSuite.suite());
  }

  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(TestGigp.suite());
    test.addTest(TestGugp.suite());
    test.addTest(TestGdgp.suite());
    return test;
  }
}