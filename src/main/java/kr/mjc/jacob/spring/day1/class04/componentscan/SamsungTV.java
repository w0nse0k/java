package kr.mjc.jacob.spring.day1.class04.componentscan;

import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * p.69
 */
@Component
public class SamsungTV implements TV {

  private Speaker speaker;

  /**
   * speaker를 주입하는 컨스트럭터
   */
  @Autowired
  public SamsungTV(@Qualifier("sonySpeaker") Speaker speaker) {
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
