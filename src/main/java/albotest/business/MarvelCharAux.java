package albotest.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Assistant for the Character class
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelCharAux {

    public List<MarvelInvolved> characters;

    /**
     * @return A list of characters
     */
    public List<MarvelInvolved> getCharacters() {
        return characters;
    }

    /**
     * @param characters characters list of the class MarvelInvolved
     */
    public void setCharacters(List<MarvelInvolved> characters) {
        this.characters = characters;
    }

}
