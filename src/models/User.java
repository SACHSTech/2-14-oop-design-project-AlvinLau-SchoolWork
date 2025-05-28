package models;

/**
 * Abstract base class representing any user in the online store system.
 * Defines common attributes (id, name) and behaviors (displayRole).
 */
public abstract class User {
    protected String id;
    protected String name;

    /**
     * Constructs a User with the specified ID and name.
     * 
     * @param id   the unique identifier for the user
     * @param name the name of the user
     */
    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Displays the role of the user (e.g., Admin or Customer) to the console.
     */
    public abstract void displayRole();

    /**
     * Returns the unique identifier of the user.
     * 
     * @return the user ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the name of the user.
     * 
     * @return the user name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name of the user.
     * 
     * @param name the new name for the user
     */
    public void setName(String name) {
        this.name = name;
    }
}
