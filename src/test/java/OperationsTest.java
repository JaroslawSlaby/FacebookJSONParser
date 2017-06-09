import classes.JSONParser;
import classes.Operations;
import classes.exceptions.NotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by jaroslaw on 08.06.17.
 */
public class OperationsTest {

    private JSONParser jsonParser;
    private Operations operations;
    Set<String> testSet;
    Map<String, Long> testMap;

    @Before
    public void initObjects() {
        jsonParser = new JSONParser(".");
        operations = new Operations(jsonParser);
        testSet = new TreeSet<>();
        testMap = new HashMap<>();
    }

    @Test
    public void findByIDTest() throws NotFoundException, FileNotFoundException {
        jsonParser.loadProfile(1);
        Assert.assertEquals(jsonParser.getProfiles().get(0).getId(), operations.findById("1").getId());
    }

    @Test
    public void findPostIdsByKeyword() throws FileNotFoundException {
        testSet.add("1");
        jsonParser.loadProfile(1);
        Assert.assertEquals(testSet, operations.findPostIdsByKeyword("Beautiful"));
    }

    @Test
    public void findMostCommonWordsTest() throws FileNotFoundException {
        jsonParser.loadProfile(1);
        testMap = operations.findMostCommonWords();
        Assert.assertTrue(testMap.containsKey("it"));
    }
}
