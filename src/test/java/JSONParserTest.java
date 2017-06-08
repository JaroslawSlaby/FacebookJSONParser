import classes.JSONParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by jaroslaw on 08.06.17.
 */
public class JSONParserTest {

    private JSONParser jsonParser;

    @Before
    public void initObjects() {
        jsonParser = new JSONParser(".");

    }

    @Test
    public void loadProfileTest() throws FileNotFoundException {
        Assert.assertEquals(0, jsonParser.getProfiles().size());
        jsonParser.loadProfile(1);
        Assert.assertEquals(1, jsonParser.getProfiles().size());
    }

    @Test
    public void filesNumberTest() {
        Assert.assertEquals(5, jsonParser.filesNumber());
    }

    @Test
    public void isJSONFileTest() {
        Assert.assertEquals(true, jsonParser.isJSONFile("jarek.json"));
        Assert.assertEquals(false, jsonParser.isJSONFile("jarek.txt"));
    }
}
