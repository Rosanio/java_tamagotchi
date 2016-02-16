import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();





  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Name your Tamagotchi");
  }
  @Test
  public void namePet() {
    goTo("http://localhost:4567");
    fill("#name").with("toby");
    submit(".btn");
    assertThat(pageSource()).contains("toby");
  }

  @Test
  public void startFoodLevel() {
    goTo("http://localhost:4567/");
    fill("#name").with("toby");
    submit(".btn");
    assertThat(pageSource()).contains("10");
  }



  // @Test
  // public void negativeNumber() {
  //   goTo("http://localhost:4567");
  //   fill("#userChange").with("-87");
  //   submit(".btn");
  //   assertThat(pageSource()).contains("Please enter a positive value");
  // }


}
