package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class CheckedTest {

    @Test
    void checked_catch(){
        Service service = new Service();
        service.callCatch();
    }
    static class MyCheckedException extends Exception {
        //Exception을 상속받은 예외는 체크 예외가 된다.

        public MyCheckedException(String message) {
            super(message);
        }
    }

    //checked 예외는 예외를 잡아서 처리하거나, 던지거나 둘중 하나를 필수로 선택해야 함
    static class Service{
        Repository repository = new Repository();
        //예외를 잡아서 처리하는 코드
        public void callCatch(){
            try {
                repository.call();
            } catch (MyCheckedException e) {
                log.info("예외 처리, message={}", e.getMessage());
            }
        }
    }

    static class Repository{
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }
    }
}
