package classes;

import classes.exceptions.NotFoundException;
import classes.structure.Facebook;

import java.util.*;

/**
 * Created by jaroslaw on 07.06.17.
 */
public class Main {
    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser(".");
        Operations operations = new Operations(jsonParser);;
        List<Facebook> profiles = new ArrayList<>();
        Facebook testProfile = new Facebook();
        Scanner in = new Scanner(System.in);

        System.out.println("Insert ID to find: ");
        String id = in.nextLine();
        try {
            testProfile = operations.findById(id);
            System.out.println(testProfile.getId() + " " + testProfile.getFirstName() + " " + testProfile.getLastName());
        } catch (NotFoundException e) {
            System.out.println("Error. Cannot find id: " + id);
            e.printStackTrace();
        }
        System.out.println();
        Set<Facebook> facebookSet = operations.findAll();
        System.out.println("All profiles sorted by firstname, lastname: ");
        for (Facebook profile: facebookSet) {
            System.out.println(profile.getId() +" " + profile.getFirstName() + " " + profile.getLastName());
        }
        System.out.println();
        System.out.println("Insert word to find posts IDs: ");
        id = in.nextLine();
        Set<String> wordID = operations.findPostIdsByKeyword(id);
        for (String wordId : wordID) {
            System.out.println("Post ID: " + wordId);
        }
        System.out.println();
        System.out.println("Most common words in all posts: ");
        Map<String, Long> words = operations.findMostCommonWords();
        for (Map.Entry<String, Long> entry : words.entrySet())
        {
            System.out.println("Word: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
