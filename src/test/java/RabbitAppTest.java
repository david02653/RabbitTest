import com.example.demo.RabbitApp;
import org.junit.jupiter.api.Test;

public class RabbitAppTest {

    @Test
    public void testCase() throws Exception {
        RabbitApp.send("test", "testing content");
    }

    @Test
    public void testCase2() throws Exception {
        RabbitApp.send("two.part", "testing content 2");
    }

    @Test
    public void testCase3() throws Exception {
        RabbitApp.send("three.part.key", "testing content 3");
    }
}
