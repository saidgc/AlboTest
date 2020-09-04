package albotest.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Comics class for each character
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelComic {
    /**
     * Data variables for each comic
     */
    public int id;
    public String title;
    public MarvelCreator creators;
    public MarvelCharAux characters;

    /**
     * @param id comic id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return the id of the comic
     */
    public int getId() {
        return id;
    }

    /**
     * @param title comic title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the title of the comic
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param creator comic creators
     */
    public void setCreators(MarvelCreator creator) {
        this.creators = creator;
    }

    /**
     * @return the creators of the comic
     */
    public MarvelCreator getCreators() {
        return creators;
    }

    /**
     * @param characters Characters involves
     */
    public void setCharacters(MarvelCharAux characters) {
        this.characters = characters;
    }

    /**
     * @return the Character involves of the comic
     */
    public MarvelCharAux getCharacters() {
        return characters;
    }
}
