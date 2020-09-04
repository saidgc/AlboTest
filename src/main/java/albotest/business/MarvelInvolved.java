package albotest.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Role and name of those involved
 * Assistant for the Comics class
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelInvolved {

    public String name;
    public String role;

    /**
     * @param role Role of the person involved
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return the current role of the person involved
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param name name of the person involved
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return the current name of the person involved
     */
    public String getName() {
        return name;
    }

}
