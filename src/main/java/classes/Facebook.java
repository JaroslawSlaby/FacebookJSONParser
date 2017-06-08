package classes;

import classes.exceptions.NotFoundException;
import interfaces.FacebookService;

import java.util.Map;
import java.util.Set;

/**
 * Created by jaroslaw on 07.06.17.
 */
public class Facebook implements FacebookService {

    public Facebook findById(String id) throws NotFoundException {
        return null;
    }

    public Map<String, Long> findMostCommonWords() {
        return null;
    }

    public Set<String> findPostIdsByKeyword(String word) {
        return null;
    }

    public Set<Facebook> findAll() {
        return null;
    }
}
