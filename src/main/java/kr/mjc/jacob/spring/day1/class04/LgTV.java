package kr.mjc.jacob.spring.day1.class04;

import kr.mjc.jacob.spring.day1.class02.TV;

/**
 * p.69
 */
public class LgTV implements TV {

  private Speaker speaker = null;

  /**
   * Default constructor
   */
  public LgTV() {
    System.out.println("lgTV instance is created.");
  }

  /**
   * speaker를 주입하는 setter
   */
  public void setSpeaker(Speaker speaker) { // property speaker
    this.speaker = speaker;
    System.out.println("lgTV setter에서 speaker를 넣었습니다.");
  }

  @Override
  public void volumeUp() {
    System.out.print("lgTV : ");
    speaker.volumeUp();
  }

  @Override
  public void volumeDown() {
    System.out.print("lgTV : ");
    speaker.volumeDown();
  }
}
