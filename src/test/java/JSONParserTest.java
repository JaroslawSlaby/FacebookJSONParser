import classes.JSONParser;
import classes.structure.Profile;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaroslaw on 08.06.17.
 */
public class JSONParserTest {

    private List<Profile> profiles;
    private Profile profile;
    private Gson gson;
    private JSONParser jsonParser;

    @Before
    public void initObjects() {
        jsonParser = new JSONParser(".");
        profiles = new ArrayList<Profile>();

    }

    @Test
    public void loadProfileTest() throws FileNotFoundException {
        Assert.assertEquals(0, jsonParser.getProfiles().size());
        jsonParser.loadProfile(1);
        Assert.assertEquals(1, jsonParser.getProfiles().size());
    }
}
