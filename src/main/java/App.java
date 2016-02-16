import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/input.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/result", (request, response) -> {
      HashMap model = new HashMap();
      String name = request.queryParams("name");

      Tamagotchi myPet = new Tamagotchi(name);
      Double food = myPet.getFoodLevel();
      Double sleep = myPet.getSleepLevel();
      Double activity = myPet.getActivityLevel();

      String stringFood = Double.toString(food);
      String stringSleep = Double.toString(sleep);
      String stringActivity = Double.toString(activity);

      //call business logic functions here
      model.put("name", name);
      model.put("food", stringFood);
      model.put("sleep", stringSleep);
      model.put("activity", stringActivity);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
      //additional pages would go here
  }

  //public static 'Returntype' 'FuncName' (Paramtype param) {}  //first business logic function

}
