package albotest.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Class of people involved in the creation of the comic
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelCreator {

    public List<MarvelInvolved> items;

    /**
     * @return A list of the people Involved from the comic
     */
    public List<MarvelInvolved> getItems() {
        return items;
    }

    /**
     * @param items list of people involved
     */
    public void setItems(List<MarvelInvolved> items) {
        this.items = items;
    }
}
