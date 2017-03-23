import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("jobform", "templates/jobForm.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("jobs", Job.all());
      model.put("template", "templates/jobs.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String title = request.queryParams("jobTitle");
      String desc = request.queryParams("jobDesc");
      String contact = request.queryParams("jobContact");
      Job newJob = new Job(title, desc, contact);
      City newCity = new City(title);
      newJob.addCity(newCity);
      model.put("city", newCity);
      model.put("jobs", newJob);
      model.put("template", "templates/job-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    // get("/tasks/:id", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Task task = Task.find(Integer.parseInt(request.params(":id")));
    //   model.put("task", task);
    //   model.put("template", "templates/task.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());


  }
}
