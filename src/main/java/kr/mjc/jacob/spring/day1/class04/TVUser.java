package kr.mjc.jacob.spring.day1.class04;


public class TVUser {

  public static void main(String[] args) {
    Speaker sonySpeaker = new SonySpeaker();
    Speaker appleSpeaker = new AppleSpeaker();

    // constructor를 사용해서 sonySpeaker를 넣는다.
    SamsungTV samsungTV = new SamsungTV(sonySpeaker);

    // default constructor로 만든 후에 setter를 사용해서 appleSpeaker를 넣는다.
    LgTV lgTV = new LgTV();
    lgTV.setSpeaker(appleSpeaker);

    samsungTV.volumeUp();
    lgTV.volumeDown();
  }
}
