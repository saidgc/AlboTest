package albotest.test;

import albotest.business.*;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Service to get the editors, writers, and colorists
 * who have been involved in the character's comics.
 */
@Component
public class UpdateService {

    private final String characterPath = "/characters";

    /**
     * Tells the application context to inject a CollabRepository instance
     */
    @Autowired
    private CollabRepository collabRepository;

    /**
     * Tells the application context to inject a CharRepository instance
     */
    @Autowired
    private CharRepository charRepository;

    /**
     * collects the data of the characters, initializes all the objects
     * with their corresponding class and writes them to the database.
     * This method is linked to a crontab to run daily, thus keeping data up to date
     * to pay royalties to writers, editors and colorists.
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void fetchCharacters() {
        JSONArray data = Utilities.fetchData(characterPath, true);


        for (int i = 0; i < data.length(); i++) {
            Map<String, List<String>> characterComic = new HashMap<>();
            List<MarvelCharacter> marvelCharacters = new ArrayList<>();

            JSONObject object = data.getJSONObject(i);

            String nameHero = object.getString("name");

            MarvelComic[] marvelComics = Utilities.fetchComics(data.getJSONObject(i).getString("id"));

            for (MarvelComic comic : marvelComics) {
                List<MarvelInvolved> involves = comic.getCharacters().getItems();
                for (MarvelInvolved involved : involves) {
                    List<String> set = characterComic.computeIfAbsent(involved.getName(), k -> new ArrayList<>());
                    set.add(comic.getTitle());
                }
            }

            for (Map.Entry<String, List<String>> entry : characterComic.entrySet()) {
                if (!entry.getKey().equals(nameHero)) {
                    MarvelCharacter marvelCharacter = new MarvelCharacter();
                    marvelCharacter.setCharacter(entry.getKey());
                    marvelCharacter.setComics(entry.getValue());
                    marvelCharacters.add(marvelCharacter);
                }

            }

            MarvelCharResp charResp = new MarvelCharResp(
                    Long.parseLong(object.getString("id")),
                    Utilities.getDate());
            charResp.setCharacters(marvelCharacters);
            charResp.setName(nameHero);

            charRepository.save(charResp);
        }

    }

    /**
     * collects the data of the creators, initializes all the objects
     * with their corresponding class and writes them to the database.
     * This method is linked to a crontab to run daily, thus keeping data up to date.
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void fetchCreators() {
        JSONArray arrayCharacters = Utilities.fetchData(characterPath, true);

        for (int i = 0; i < arrayCharacters.length(); i++) {
            JSONObject characterData = arrayCharacters.getJSONObject(i);
            String characterId = characterData.getString("id");
            String nameHero = characterData.getString("name");

            Set<String> editors = new HashSet<>();
            Set<String> colorists = new HashSet<>();
            Set<String> writers = new HashSet<>();

            MarvelColResp collaborator = new MarvelColResp(Long.parseLong(characterId), Utilities.getDate());

            for (MarvelComic comic : Utilities.fetchComics(arrayCharacters.getJSONObject(i).getString("id"))) {
                List<MarvelInvolved> involves = comic.getCreators().getItems();
                for (MarvelInvolved involve : involves) {
                    switch (involve.getRole()) {
                        case "editor":
                            editors.add(involve.getName());
                            break;
                        case "colorist":
                            colorists.add(involve.getName());
                            break;
                        case "writer":
                            writers.add(involve.getName());
                            break;
                    }
                }
            }

            collaborator.setColorist(colorists);
            collaborator.setWriters(writers);
            collaborator.setEditors(editors);
            collaborator.setName(nameHero);

            collabRepository.save(collaborator);
        }

    }

}
