import org.junit.*;
import static org.junit.Assert.*;

public class UnitTest {

  @Test
  public void tamagotchi_intstantiatesCorrectly() {
    Tamagotchi myPet = new Tamagotchi("mittens");
    assertEquals("mittens", myPet.getName());
    assertEquals(10.0, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(10.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(10.0, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_passTime() {
    Tamagotchi myPet = new Tamagotchi("mittens");
    myPet.passTime();
    assertEquals(9.0, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(9.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(9.0, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_feed() {
    Tamagotchi myPet = new Tamagotchi("pikachu");
    myPet.passTime();
    myPet.passTime();
    myPet.feed();
    assertEquals(10.0, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(7.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(7.0, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_sleep() {
    Tamagotchi myPet = new Tamagotchi("mittens");
    assertEquals(true, myPet.sleep());
  }

  @Test
  public void tamagotchi_isSleeping() {
    Tamagotchi myPet = new Tamagotchi("mittens");
    myPet.passTime();
    myPet.passTime();
    myPet.sleep();
    myPet.passTime();
    assertEquals(7.5, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(10.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(7.5, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_playWith() {
    Tamagotchi myPet = new Tamagotchi("toby");
    myPet.passTime();
    myPet.passTime();
    myPet.playWith();
    assertEquals(7.0, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(7.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(10.0, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_maxFood() {
    Tamagotchi myPet = new Tamagotchi("gracie");
    myPet.feed();
    assertEquals(10.0, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(9.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(9.0, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_maxSleep() {
    Tamagotchi myPet = new Tamagotchi("gracie");
    myPet.sleep();
    myPet.passTime();
    assertEquals(9.5, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(10.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(9.5, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_maxActivity() {
    Tamagotchi myPet = new Tamagotchi("gracie");
    myPet.playWith();
    assertEquals(9.0, (double)myPet.getFoodLevel(), 0.002);
    assertEquals(9.0, (double)myPet.getSleepLevel(), 0.002);
    assertEquals(10.0, (double)myPet.getActivityLevel(), 0.002);
  }

  @Test
  public void tamagotchi_isAlive() {
    Tamagotchi myPet = new Tamagotchi("gracie");
    assertEquals(true, myPet.isAlive());

  }

  @Test
  public void tamagotchi_isDead() {
    Tamagotchi myPet = new Tamagotchi("gracie");
    myPet.feed();
    myPet.feed();
    myPet.feed();
    myPet.feed();
    myPet.feed();
    myPet.playWith();
    myPet.playWith();
    myPet.playWith();
    myPet.playWith();
    myPet.playWith();
    assertEquals(false, myPet.getAliveLevel());
  }

/*
@Test
public void giveChange_25cents_1quarter() {
  App testApp = new App();
  assertEquals("{Nickels=0, Dimes=0, Quarters=1, Pennies=0}", testApp.giveChange(25).toString());
}
*/

}
