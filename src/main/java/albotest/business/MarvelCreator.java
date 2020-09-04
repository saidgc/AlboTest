package albotest.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Class of people involved in the creation of the comic
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelCreator {

    public List<MarvelInvolved> involves;

    /**
     * @return A list of the people Involved from the comic
     */
    public List<MarvelInvolved> getInvolves() {
        return involves;
    }

    /**
     * @param involves list of people involved
     */
    public void setInvolves(List<MarvelInvolved> involves) {
        this.involves = involves;
    }
}
