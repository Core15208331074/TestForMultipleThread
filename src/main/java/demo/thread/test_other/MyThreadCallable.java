package demo.thread.test_other;

import java.nio.file.attribute.UserPrincipal;
import java.util.concurrent.Callable;

public class MyThreadCallable implements Callable {
    @Override
    public Object call() throws Exception {

        return new UserPrincipal() {
            @Override
            public String getName() {
                return "u";
            }

            @Override
            public String toString() {
                return "u:"+getName();
            }
        };
    }
}
