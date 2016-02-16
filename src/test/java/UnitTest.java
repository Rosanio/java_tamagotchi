import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void tamagotchi_intstantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("mittens");
    assertEquals("mittens", myPet.getName());
    assertEquals(10, (int)myPet.getFoodLevel());
    assertEquals(10, (int)myPet.getSleepLevel());
    assertEquals(10, (int)myPet.getActivityLevel());
  }


/*
@Test
public void giveChange_25cents_1quarter() {
  App testApp = new App();
  assertEquals("{Nickels=0, Dimes=0, Quarters=1, Pennies=0}", testApp.giveChange(25).toString());
}
*/

}
