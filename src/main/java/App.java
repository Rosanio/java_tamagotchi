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

    post("/result", (request, response) -> {
      HashMap model = new HashMap();

      Tamagotchi myPet = request.session().attribute("pet");
      String name;
      if(myPet == null) {
        name = request.queryParams("name");
        myPet = new Tamagotchi(name);
        request.session().attribute("pet", myPet);
      } else {
        name = myPet.getName();
      }

      String action = request.queryParams("action");
      if(action!=null) {
        if (action.equals("feed")) {
          myPet.feed();
        } else if (action.equals("sleep")) {
          myPet.sleep();
        } else if (action.equals("play")) {
          myPet.playWith();
        } else if (action.equals("time")) {
          myPet.passTime();
        }
      }

      Boolean alive = myPet.getAliveLevel();

      Double food = myPet.getFoodLevel();
      Double sleep = myPet.getSleepLevel();
      Double activity = myPet.getActivityLevel();

      String stringFood = Double.toString(food);
      String stringSleep = Double.toString(sleep);
      String stringActivity = Double.toString(activity);

      //call business logic functions here
      model.put("name", name); //"name" reference of name field in the vtl file, name references the value defined on this page
      model.put("food", stringFood);
      model.put("sleep", stringSleep);
      model.put("activity", stringActivity);
      model.put("alive", alive);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
      //additional pages would go here
  }

  //public static 'Returntype' 'FuncName' (Paramtype param) {}  //first business logic function

}
