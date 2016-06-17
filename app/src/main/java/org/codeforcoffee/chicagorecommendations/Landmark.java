package org.codeforcoffee.chicagorecommendations;

/**
 * Created by codeforcoffee on 6/17/16.
 */
public class Landmark {

    private String name;
    private String description;
    private String address;

    public Landmark(String name, String desc, String addy) {
        this.name = name;
        this.description = desc;
        this.address = addy;
    }

    public String toString() {
        return this.name + " : " + this.description + " : " + this.address;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }
}
