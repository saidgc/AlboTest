package albotest.test;

import albotest.business.MarvelCharResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlled for characters
 */
@RestController
public class CharController {

    /**
     * Tells the application context to inject a CharRepository instance
     */
    @Autowired
    private CharRepository charRepository;

    /**
     * Endpoint to resolve test requests
     *
     * @param character Name of character to search (Captain America, Iron Man)
     * @return Data by character
     */
    @RequestMapping("marvel/characters/{character}")
    public MarvelCharResp characters(@PathVariable String character) {
        MarvelCharResp response = charRepository.findByName(character);

        if (response == null) {
            throw new NoDataException(character);
        }

        return response;
    }

}
