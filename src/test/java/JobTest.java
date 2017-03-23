import org.junit.*;
import static org.junit.Assert.*;

public class JobTest {

  @Test
  public void jobs_JobObject_true() {
    Job testJob = new Job("Budtender");
    assertEquals(true, testJob instanceof Job);
  }


}
