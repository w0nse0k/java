package kr.mjc.jacob.spring.day1.class04.componentscan;

import kr.mjc.jacob.spring.day1.class02.TV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * p.69
 */
@Component
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
  @Autowired
  public void setSpeaker(@Qualifier("appleSpeaker") Speaker speaker) {
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
