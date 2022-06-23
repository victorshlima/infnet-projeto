import com.projeto1.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {

    @Test
    public void mainTest(){
    assertDoesNotThrow(() -> Main.main(new String[]{""}) );
    }




}
