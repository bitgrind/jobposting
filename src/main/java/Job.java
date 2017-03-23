import java.util.List;
import java.util.ArrayList;

public class Job{
  private int jobId;
  private String jobTitle;
  private String jobDesc;
  private String jobContact;
  private static List<Job> instances = new ArrayList<Job>();
  private static List<City> cities = new ArrayList<City>();


  public Job(String name, String desc, String contact){
    jobTitle = name;
    jobDesc = desc;
    jobContact = contact;
    instances.add(this);
    jobId = instances.size();
    //mDesc;
  }

  public void addCity(City city){
    cities.add(city);
  }

  public int getId(){
    return jobId;
  }

  public String getTitle(){
    return jobTitle;
  }

  public static void clear() {
    instances.clear();
  }

  public static List<Job> all() {
   return instances;
  }

  public static Job find(int id) {
    return instances.get(id - 1);
  }

}
