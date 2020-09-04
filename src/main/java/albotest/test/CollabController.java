package albotest.test;

import albotest.business.MarvelColResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlled for Collaborators
 */
@RestController
public class CollabController {

    /**
     * Tells the application context to inject a CollabRepository instance
     */
    @Autowired
    private CollabRepository collabRepository;

    /**
     * Endpoint to resolve test requests
     *
     * @param character Name of collaborators to search (Captain America, Iron Man)
     * @return Data by collaborators
     */
    @RequestMapping("marvel/colaborators/{character}")
    public MarvelColResp collaboratorByHero(@PathVariable String character) {
        MarvelColResp response = collabRepository.findByName(character);

        if (response == null) {
            throw new NoDataException(character);
        }

        return response;
    }

}
