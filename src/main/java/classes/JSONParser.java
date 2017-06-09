package classes;

import classes.structure.Facebook;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaroslaw on 08.06.17.
 */

public class JSONParser {

    private Gson gson = new Gson();
    private List<Facebook> profiles = new ArrayList<>();
    private String location;
    private List<String> allPosts;

    public JSONParser(String location) {
        this.location = location;
    }

    public boolean isJSONFile(String name) {
        String ext = "";
        int i = name.lastIndexOf('.');
        if (i >= 0) {
            ext = name.substring(i+1);
        }
        return ext.equals("json");
    }

    public int filesNumber() {
        File dir = new File(location + "/data");
        File[] files = dir.listFiles();
        int z = 0;
        if(files != null)
            for(File file : files) {
                if(isJSONFile(file.getName()))
                    z++;
            }
        return z;
    }

    List<Facebook> getProfilesList() {
        profiles = new ArrayList<>();
        for (int i = 1; i <= filesNumber(); i++) {
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
        profiles.add(gson.fromJson(new FileReader(this.location + "/data/f" + i + ".json"), Facebook.class));
    }

    public void setProfiles(List<Facebook> profiles) {
        this.profiles = profiles;
    }

    public List<Facebook> getProfiles() {
        return profiles;
    }

}
