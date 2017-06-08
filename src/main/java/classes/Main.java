package classes;

import classes.structure.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaroslaw on 07.06.17.
 */
public class Main {
    public static void main(String[] args) {
        JSONParser jsonParser = new JSONParser(".");
        List<Profile> profiles = new ArrayList<Profile>();
        profiles.addAll(jsonParser.getProfilesList());
        System.out.print(profiles.get(0).getPosts().get(0).getMessage());
    }
}
