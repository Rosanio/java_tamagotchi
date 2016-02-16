public class Tamagotchi {
  private String mName;
  private Double mFood = 10.0;
  private Double mSleep = 10.0;
  private Double mActivity = 10.0;
  private Boolean mIsSleeping = false;

  public Tamagotchi(String name) {
    mName = name;
  }

  public String getName() {
    return mName;
  }

  public Double getFoodLevel() {
    return mFood;
  }

  public Double getSleepLevel() {
    return mSleep;
  }

  public Double getActivityLevel() {
    return mActivity;
  }

  public void passTime() {
    if(mIsSleeping) {
      mFood -= 0.5;
      mSleep += 2.0;
      mActivity -= 0.5;
    } else {
      mFood -= 1.0;
      mSleep -= 1.0;
      mActivity -= 1.0;
    }
  }

  public void feed() {
    mFood += 2.0;
    mSleep -= 1.0;
    mActivity -= 1.0;
  }

  public Boolean sleep() {
    if(mIsSleeping) {
      mIsSleeping = false;
    } else {
      mIsSleeping = true;
    }
    return mIsSleeping;
  }

}
