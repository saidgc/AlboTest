package albotest.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Assistant for the Character class
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelCharAux {

    public List<MarvelInvolved> items;

    /**
     * @return A list of characters
     */
    public List<MarvelInvolved> getItems() {
        return items;
    }

    /**
     * @param items characters list of the class MarvelInvolved
     */
    public void setItems(List<MarvelInvolved> items) {
        this.items = items;
    }

}
