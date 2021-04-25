package kr.mjc.jacob.spring.logging;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggingEx {

  public static void main(String[] args) {
    log.trace("로거 구현체 : {}", log.getClass().getName());
    log.debug("로거 구현체 : {}", log.getClass().getName());
    log.info("로거 구현체 : {}", log.getClass().getName());
    log.error("로거 구현체 : {}", log.getClass().getName());

    // 다음과 같이 문자열 연산을 하지 않는다.
    log.debug("로거 구현체 : " + log.getClass().getName());
  }
}
