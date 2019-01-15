package testingintegrazione;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;
import testingunita.DomandaDaoImpTest;
import testingunita.RispostaDaoImpTest;
import testingunita.StudenteDaoImpTest;
import testingunita.TutorDaoImpTest;

public class TestGp {
  public static void main(String[] args) {
    TestRunner.run(TestGp.suite());
  }

  public static Test suite() {
    TestSuite test = new TestSuite();
    test.addTest(StudenteDaoImpTest.suite());
    test.addTest(TutorDaoImpTest.suite());
    test.addTest(DomandaDaoImpTest.suite());
    test.addTest(RispostaDaoImpTest.suite());
    return test;
  }
}
