package kr.mjc.jacob.spring.day1.class04.componentscan;

import org.springframework.stereotype.Component;

/**
 * p.67
 */
@Component
public class SonySpeaker implements Speaker {

	public SonySpeaker() {
		System.out.println("sonySpeaker instance is created.");
	}
}
