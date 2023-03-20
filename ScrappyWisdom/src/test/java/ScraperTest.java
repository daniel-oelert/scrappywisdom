import org.junit.Assert;
import org.junit.Test;

import com.accenture.Scrappy.Scraper;
public class ScraperTest {

    @Test
    public void testScraperSimple(){
        var s = new Scraper();
        s.getQuote();
        Assert.assertTrue(true);
    }


}
