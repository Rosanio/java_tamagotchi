import java.util.HashMap;
import spark.ModelAndView;
import java.util.ArrayList;
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
      Boolean legitName = true;

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
      Boolean asleep = myPet.getSleepState();

      Double food = myPet.getFoodLevel();
      Double sleep = myPet.getSleepLevel();
      Double activity = myPet.getActivityLevel();

      String stringFood = Double.toString(food);
      String stringSleep = Double.toString(sleep);
      String stringActivity = Double.toString(activity);


      ArrayList<String> deadPets = request.session().attribute("deadPets");
      if(deadPets == null) {
        deadPets = new ArrayList<String>();
        request.session().attribute("deadPets", deadPets);
      }

      for(String deadPet: deadPets) {
        System.out.println(deadPet);
        if(name.equals(deadPet)) {
          legitName = false;
          request.session().attribute("pet", null);
        }
      }
      System.out.println(legitName);

      if(!alive) {
        deadPets.add(name);
        request.session().attribute("pet", null);
      }

      //call business logic functions here
      model.put("name", name); //"name" reference of name field in the vtl file, name references the value defined on this page
      model.put("food", stringFood);
      model.put("sleep", stringSleep);
      model.put("activity", stringActivity);
      model.put("alive", alive);
      model.put("deadPets", deadPets);
      model.put("legitName", legitName);
      model.put("asleep", asleep);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
      //additional pages would go here
  }

  //public static 'Returntype' 'FuncName' (Paramtype param) {}  //first business logic function

}
