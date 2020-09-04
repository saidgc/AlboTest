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
     * @param nameHero Name of character to search (Captain America, Iron Man)
     * @return Data by character
     */
    @RequestMapping("marvel/characters/{nameHero}")
    public MarvelCharResp characters(@PathVariable String nameHero) {
        MarvelCharResp response = charRepository.findByName(nameHero);

        if (response == null) {
            throw new NoDataException(nameHero);
        }

        return response;
    }

}
