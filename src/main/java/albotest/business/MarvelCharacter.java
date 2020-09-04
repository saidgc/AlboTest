package albotest.business;

import java.util.List;

/**
 * Character object class
 */
public class MarvelCharacter {
    /**
     * Variables of the characters object
     */
    private String character;
    private List<String> comics;

    /**
     * @return a character in string
     */
    public String getCharacter() {
        return character;
    }

    /**
     * @param character character in string
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * @return a list of comics by character
     */
    public List<String> getComics() {
        return comics;
    }

    /**
     * @param comics comics by character in List of String
     */
    public void setComics(List<String> comics) {
        this.comics = comics;
    }
}
