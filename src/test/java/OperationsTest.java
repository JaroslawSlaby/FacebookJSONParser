import classes.JSONParser;
import classes.Operations;
import classes.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by jaroslaw on 08.06.17.
 */
public class OperationsTest {

    private JSONParser jsonParser;
    private Operations operations;

    @Before
    public void initObjects() {
        jsonParser = new JSONParser(".");
        operations = new Operations(jsonParser);
    }

    @Test
    public void findByIDTest() throws NotFoundException, FileNotFoundException {
        jsonParser.loadProfile(1);
        Assert.assertEquals(jsonParser.getProfiles().get(0).getId(), operations.findById("1").getId());
    }
}
