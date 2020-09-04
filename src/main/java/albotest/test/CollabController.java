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
     * @param nameHero Name of collaborators to search (Captain America, Iron Man)
     * @return Data by collaborators
     */
    @RequestMapping("marvel/colaborators/{nameHero}")
    public MarvelColResp collaboratorByHero(@PathVariable String nameHero) {
        MarvelColResp response = collabRepository.findByName(nameHero);

        if (response == null) {
            throw new NoDataException(nameHero);
        }

        return response;
    }

}
