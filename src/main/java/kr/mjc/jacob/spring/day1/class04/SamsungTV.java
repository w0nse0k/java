package kr.mjc.jacob.spring.day1.class04;

import kr.mjc.jacob.spring.day1.class02.TV;

/**
 * p.69
 */
public class SamsungTV implements TV {

  private Speaker speaker;

  /**
   * speaker를 주입하는 컨스트럭터
   */
  public SamsungTV(Speaker speaker) {
    this.speaker = speaker;
    System.out.println("samsungTV constructor에서 speaker를 넣었습니다.");
    System.out.println("samsungTV instance is created.");
  }

  @Override
  public void volumeUp() {
    System.out.print("samsungTV : ");
    speaker.volumeUp();
  }

  @Override
  public void volumeDown() {
    System.out.print("samsungTV : ");
    speaker.volumeDown();
  }
}
