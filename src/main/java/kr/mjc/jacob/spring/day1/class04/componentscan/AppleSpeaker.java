package kr.mjc.jacob.spring.day1.class04.componentscan;

import org.springframework.stereotype.Component;

/**
 * p.77
 */
@Component
public class AppleSpeaker implements Speaker {

  public AppleSpeaker() {
    System.out.println("appleSpeaker instance is created.");
  }
}
