package classes;

import classes.exceptions.NotFoundException;
import classes.structure.Facebook;
import interfaces.FacebookService;

import java.util.*;

/**
 * Created by jaroslaw on 07.06.17.
 */
public class Operations implements FacebookService {

    JSONParser jsonParser;

    public Operations(JSONParser jsonParser) {
        this.jsonParser = jsonParser;
    }

    public Facebook findById(String id) throws NotFoundException {
        int l, p, s;
        List<Facebook> profiles = jsonParser.getProfilesList();
        l = 0;
        p = profiles.size() - 1;
        while (l <= p) {
            s = (l + p) / 2;
            if (profiles.get(s).getId().compareTo(id) == 0) {
                System.out.println("Find profile " + id + " Index: " + s);
                return profiles.get(s);
            }
            else if (profiles.get(s).getId().compareTo(id) < 0) {
                l = s + 1;
            } else
                p = s - 1;
        }
        System.out.println("Cannot find: " + id);
        return null;
    }

    public Map<String, Long> findMostCommonWords() {
        return null;
    }

    public Set<String> findPostIdsByKeyword(String word) {
        return null;
    }

    public Set<Facebook> findAll() {
        Set profileSet = new TreeSet(jsonParser.getProfiles());
        return profileSet;
    }
}
