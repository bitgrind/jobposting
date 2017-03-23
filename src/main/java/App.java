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

    // get("/jobs", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   model.put("jobs", Job.all());
    //   model.put("template", "templates/jobs.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());

    post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.queryParams("cityId")));
      String title = request.queryParams("jobTitle");
      Job newJob = new Job(title);
      city.addJob(newJob);
      model.put("city", city);
      model.put("template", "templates/category-task-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}
