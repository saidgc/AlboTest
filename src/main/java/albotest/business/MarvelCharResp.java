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
    private String last_sync;
    private List<MarvelCharacter> characters;

    /**
     * MarvelCharResp object initializer
     *
     * @param id        id of the MarvelCharResp object
     * @param last_sync Date of last update (dd/M/yyyy hh:mm:ss)
     */
    public MarvelCharResp(long id, String last_sync) {
        this.id = id;
        this.last_sync = last_sync;
    }

    /**
     * @param id id of the MarvelCharResp object
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return MarvelCharResp object id
     */
    public long getId() {
        return id;
    }

    /**
     * @return Date of last update (dd/M/yyyy hh:mm:ss)
     */
    public String getLast_sync() {
        return last_sync;
    }

    /**
     * @param last_sync Date of last update with format dd/M/yyyy hh:mm:ss
     */
    public void setLast_sync(String last_sync) {
        this.last_sync = last_sync;
    }

    /**
     * @param characters Characters
     */
    public void setCharacters(List<MarvelCharacter> characters) {
        this.characters = characters;
    }

    /**
     * @return A list of characters
     */
    public List<MarvelCharacter> getCharacters() {
        return characters;
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
