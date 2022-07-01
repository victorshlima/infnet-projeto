import com.projeto1.Main;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @Test
    public void mainTest(){
        assertThrows(NoSuchElementException.class, () -> Main.main(new String[]{""}) );
    }
}
