package albotest.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

/**
 * Object class for collaborators
 */
@Document(collection = "colab")
public class MarvelColResp {
    /**
     * Data variables for collaborators
     */
    @Id
    private long id;
    private String name;
    private String lastSync;
    private Set<String> editors;
    private Set<String> writers;
    private Set<String> colorist;

    /**
     * Initializer for collaborators
     * @param id collaborator id
     * @param lastSync Date of last update (dd/M/yyyy hh:mm:ss)
     */
    public MarvelColResp(long id, String lastSync) {
        this.id = id;
        this.lastSync = lastSync;
    }

    /**
     * @return A set of editors
     */
    public Set<String> getEditors() {
        return editors;
    }

    /**
     * @param editors A set of editors
     */
    public void setEditors(Set<String> editors) {
        this.editors = editors;
    }

    /**
     * @return A set of writers
     */
    public Set<String> getWriters() {
        return writers;
    }

    /**
     * @param writers A set of writers
     */
    public void setWriters(Set<String> writers) {
        this.writers = writers;
    }

    /**
     * @return A set of colorist
     */
    public Set<String> getColorist() {
        return colorist;
    }

    /**
     * @param colorist A set of colorist
     */
    public void setColorist(Set<String> colorist) {
        this.colorist = colorist;
    }

    /**
     * @return the Id of the collaborators
     */
    public long getId() {
        return id;
    }

    /**
     * @param id set the Id for each collaborator
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return Date of last update in format dd/M/yyyy hh:mm:ss
     */
    public String getLastSync() {
        return lastSync;
    }

    /**
     * @param lastSync Date of last update (dd/M/yyyy hh:mm:ss)
     */
    public void setLastSync(String lastSync) {
        this.lastSync = lastSync;
    }

    /**
     * @return the name of each collaborator
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name of echa collaborator
     */
    public void setName(String name) {
        this.name = name;
    }

}
