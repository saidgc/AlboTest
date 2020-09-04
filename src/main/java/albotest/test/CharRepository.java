package albotest.test;

import albotest.business.MarvelCharResp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface between the database manager and java
 */
@Repository
public interface CharRepository extends MongoRepository<MarvelCharResp, Long> {

    /**
     * Search for an entity that matches the requested name
     * @param name The character's name
     * @return A MarvelCharResp object
     */
    MarvelCharResp findByName(String name);
}
