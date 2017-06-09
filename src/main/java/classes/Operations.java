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

        if(Integer.parseInt(id) > jsonParser.getProfilesList().size()) {
            throw new NotFoundException("not find");
        }

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
        return null;
    }

    public Map<String, Long> findMostCommonWords() {

        Map<String, Long> map = new HashMap<>();
        for (Facebook profile : jsonParser.getProfilesList()) {
            for(int i = 0; i < profile.getPosts().size(); i++) {
                String[] temp = profile.getPosts().get(i).getMessage().toLowerCase().replaceAll("/", " ").replaceAll("-", " ").split("\\s+");
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = temp[j].replaceAll("[^\\w]", "");
                    Long n = map.get(temp[j]);
                    n = (n == null) ? 1 : ++n;
                    map.put(temp[j], n);
                }
            }
        }
        map.remove(map.keySet().iterator().next());
        return map;
    }

    public Set<String> findPostIdsByKeyword(String word) {

        Set<String> idKeywords = new TreeSet<>();
        for(Facebook profile :  jsonParser.getProfilesList()) {
            for (int i = 0; i < profile.getPosts().size(); i++) {
               if(profile.getPosts().get(i).getMessage().toLowerCase().contains(word.toLowerCase())) {
                   idKeywords.add(profile.getPosts().get(i).getId());
               }
            }
        }
        return idKeywords;
    }

    public Set<Facebook> findAll() {
        Set profileSet = new TreeSet(jsonParser.getProfiles());
        return profileSet;
    }
}
