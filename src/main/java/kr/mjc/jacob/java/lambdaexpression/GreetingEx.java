package kr.mjc.jacob.java.lambdaexpression;

public class GreetingEx {
  public static void main(String[] args) {
    new GreetingEx().go();
  }

  /**
   * Functional interface Greeting의 greet() 메서드를 수행
   */
  public void sayHello(Greeting greeting) {
    greeting.greet();
  }

  public void go() {
    // 1. Greeting을 구현한 영어 인사 로컬 클래스
    class EnglishGreeting implements Greeting {
      @Override
      public void greet() {
        System.out.println("Hello.");
      }
    }
    Greeting englishGreeting = new EnglishGreeting();
    sayHello(englishGreeting); // Hello.

    // 2. 프랑스어 인사는 anonymous class (이름 없는 클래스) 사용
    Greeting frenchGreeting = new Greeting() {
      @Override
      public void greet() {
        System.out.println("Bonjour.");
      }
    };
    sayHello(frenchGreeting); // Bonjour.

    // 3. 스페인어 인사는 anonymous 클래스를 메서드에 직접 삽입
    sayHello(new Greeting() {
      @Override
      public void greet() {
        System.out.println("Hola.");  // Hola
      }
    });

    // 4. 한국어 인사는 lambda expression 사용
    // Lambda expression은 functional interface 구현체의 메서드 내부만 표현한 것
    sayHello(() -> System.out.println("안녕하세요."));
  }
}
