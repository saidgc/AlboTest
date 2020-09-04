package albotest.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Class for each character's response object
 */
@Document(collection = "char")
public class MarvelCharResp {

    /**
     * response object variables for each character
     */
    @Id
    private long id;
    private String name;
    private String lastSync;
    private List<MarvelCharacter> marvelCharacters;

    /**
     * MarvelCharResp object initializer
     * @param id id of the MarvelCharResp object
     * @param lastSync Date of last update (dd/M/yyyy hh:mm:ss)
     */
    public MarvelCharResp(long id, String lastSync) {
        this.id = id;
        this.lastSync = lastSync;
    }

    /**
     * @param id id of the MarvelCharResp object
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return MarvelCharResp object id
     */
    public long getId() {
        return id;
    }

    /**
     * @return Date of last update (dd/M/yyyy hh:mm:ss)
     */
    public String getLastSync() {
        return lastSync;
    }

    /**
     * @param lastSync Date of last update with format dd/M/yyyy hh:mm:ss
     */
    public void setLastSync(String lastSync) {
        this.lastSync = lastSync;
    }

    /**
     * @param marvelCharacters Characters
     */
    public void setMarvelCharacters(List<MarvelCharacter> marvelCharacters) {
        this.marvelCharacters = marvelCharacters;
    }

    /**
     * @return A list of characters
     */
    public List<MarvelCharacter> getMarvelCharacters() {
        return marvelCharacters;
    }

    /**
     * @return the character's name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name name of the character
     */
    public void setName(String name) {
        this.name = name;
    }

}
