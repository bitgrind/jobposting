import java.util.List;
import java.util.ArrayList;

public class City {
  private String cityTitle;
  private static ArrayList<City> instances = new ArrayList<City>();
  private int cityId;
  private List<Job> cityJobs;

  public City(String title){
    cityTitle = title;
    instances.add(this);
    cityId = instances.size();
    cityJobs = new ArrayList<Job>();
  }

  public String getTitle() {
    return cityTitle;
  }

  public static ArrayList<City> all() {
   return instances;
  }

  public static void clear() {
    instances.clear();
  }

  public int getId() {
    return cityId;
  }

  public static City find(int id) {
   return instances.get(id - 1);
  }

  public List<Job> getJobs() {
    return cityJobs;
  }

  public void addJob(Job job) {
    cityJobs.add(job);
  }


}
