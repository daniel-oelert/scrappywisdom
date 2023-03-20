import com.accenture.Scrappy.ScrappyMastodonClient;
import org.junit.Test;

public class ScrappyMastodonClientTest {

    @Test
    public void testMastodonClient(){
        ScrappyMastodonClient c = new ScrappyMastodonClient();
        c.mastodonClientInit("");
    }


}
