public class Tamagotchi {
  private String mName;
  private Integer mFood = 10;
  private Integer mSleep = 10;
  private Integer mActivity = 10;

  public Tamagotchi(String name) {
    mName = name;
  }

  public String getName() {
    return mName;
  }
  public Integer getFoodLevel() {
    return mFood;
  }
  public Integer getSleepLevel() {
    return mSleep;
  }
  public Integer getActivityLevel() {
    return mActivity;
  }
  public void passTime() {
    mFood -= 1;
    mSleep -= 1;
    mActivity -= 1;
  }

}
