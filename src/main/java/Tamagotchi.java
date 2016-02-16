public class Tamagotchi {
  private String mName;
  private Double mFood = 10.0;
  private Double mSleep = 10.0;
  private Double mActivity = 10.0;
  private Boolean mIsSleeping = false;
  private Boolean mIsAlive = true;

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

  public Boolean getAliveLevel() {
    return mIsAlive;
  }

  public void passTime() {
    if(mIsSleeping) {
      mFood -= 0.5;
      mSleep += 2.0;
      mActivity -= 0.5;
      if(mSleep > 10.0) {
        mSleep = 10.0;
      }
      this.isAlive();
    } else {
      mFood -= 1.0;
      mSleep -= 1.0;
      mActivity -= 1.0;
      this.isAlive();
    }
  }

  public void feed() {
    mFood += 2.0;
    mSleep -= 1.0;
    mActivity -= 1.0;
    if(mFood > 10.0) {
      mFood = 10.0;
    }
    this.isAlive();
  }

  public Boolean sleep() {
    if(mIsSleeping) {
      mIsSleeping = false;
    } else {
      mIsSleeping = true;
    }
    return mIsSleeping;
  }

  public void playWith() {
    mFood -= 1.0;
    mSleep -= 1.0;
    mActivity += 2.0;
    if(mActivity > 10.0) {
      mActivity = 10.0;
    }
    this.isAlive();
  }

  public Boolean isAlive() {
    if(mFood == 0.0 || mSleep == 0.0 || mActivity == 0.0) {
      mIsAlive = false;
    } return mIsAlive;
  }

}
