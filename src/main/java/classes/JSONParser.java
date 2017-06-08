package classes;

import classes.structure.Profile;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaroslaw on 08.06.17.
 */
public class JSONParser {

    private Gson gson = new Gson();
    private List<Profile> profiles;
    private String location;

    JSONParser(String location) {
        this.location = location;
    }

    List<Profile> getProfiles() {

        profiles = new ArrayList<Profile>();
        try {
            for (int i = 1; i < 6; i++)
                profiles.add(gson.fromJson(new FileReader(this.location + "data/f" + i + ".json"), Profile.class));
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }

        return profiles;
    }

}
