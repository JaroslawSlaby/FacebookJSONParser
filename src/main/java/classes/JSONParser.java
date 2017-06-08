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
    private List<Profile> profiles = new ArrayList<Profile>();
    private String location;

    public JSONParser(String location) {
        this.location = location;
    }

    List<Profile> getProfilesList() {

        profiles = new ArrayList<Profile>();
        for (int i = 1; i < 6; i++) {
            try {
                loadProfile(i);
            } catch (FileNotFoundException e) {
                System.out.println("File not found!");
                e.printStackTrace();
            }
        }
        return profiles;
    }

    public void loadProfile(int i) throws FileNotFoundException{
        profiles.add(gson.fromJson(new FileReader(this.location + "/data/f" + i + ".json"), Profile.class));
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }
}
