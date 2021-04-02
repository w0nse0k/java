package kr.mjc.jacob.spring.day1.class02;

/**
 * p.44
 */
public class TVUser {

	public static void main(String[] args) {

		TV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	}
}
