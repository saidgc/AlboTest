package albotest.test;

import albotest.business.MarvelColResp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface between the database manager and java
 */
@Repository
public interface CollabRepository extends MongoRepository<MarvelColResp, Long> {

    /**
     * Search for an entity that matches the requested name
     * @param name The collaborator's name
     * @return A MarvelColResp object
     */
    MarvelColResp findByName(String name);
}
