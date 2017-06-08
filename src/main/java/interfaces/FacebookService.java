package interfaces;

import java.util.Map;
import java.util.Set;
import classes.Operations;
import classes.exceptions.NotFoundException;
import classes.structure.Facebook;

/**
 * Created by jaroslaw on 07.06.17.
 */
public interface FacebookService {
    Facebook findById(String id) throws NotFoundException;
    Map<String, Long> findMostCommonWords();
    Set<String> findPostIdsByKeyword(String word);
    Set<Operations> findAll();
}
