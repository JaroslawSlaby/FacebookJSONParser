package classes;

import classes.exceptions.NotFoundException;
import classes.structure.Facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaroslaw on 07.06.17.
 */
public class Main {
    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser(".");
        List<Facebook> profiles = new ArrayList<>();
        Facebook testProfile = new Facebook();
        profiles.addAll(jsonParser.getProfilesList());
        System.out.println(profiles.get(0).getId());

        Operations operations = new Operations(jsonParser);
        try {
            testProfile = operations.findById("3");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        System.out.print(testProfile.getFirstName());
    }
}
