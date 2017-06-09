package classes;

import classes.exceptions.NotFoundException;
import classes.structure.Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        System.out.println(profiles.get(0).getPosts().get(1).getMessage());
        Operations operations = new Operations(jsonParser);
        /*try {
            testProfile = operations.findById("6");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }*/
        Set<Facebook> facebookSet = operations.findAll();

        /*for (Facebook profile: facebookSet) {
            System.out.println(profile.getFirstName() + " " + profile.getLastName());
        }*/
        Set<String> wordID = operations.findPostIdsByKeyword("TV");
        Map<String, Long> words = operations.findMostCommonWords();
        for (Map.Entry<String, Long> entry : words.entrySet())
        {
            System.out.println("Word: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
