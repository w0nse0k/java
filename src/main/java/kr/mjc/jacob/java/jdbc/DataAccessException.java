package kr.mjc.jacob.java.jdbc;

/**
 * SQLException이 발생할 경우 던지는 unchecked exception
 */
public class DataAccessException extends RuntimeException {
  public DataAccessException() {
  }

  public DataAccessException(String message) {
    super(message);
  }

  public DataAccessException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataAccessException(Throwable cause) {
    super(cause);
  }

  public DataAccessException(String message, Throwable cause,
                             boolean enableSuppression,
                             boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
