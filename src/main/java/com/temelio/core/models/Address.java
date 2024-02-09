package com.temelio.core.models;

/**
 * Represents an address.
 */
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;

    /**
     * Default constructor for Address.
     */
    public Address() {
    }

    /**
     * Get the street of the address.
     *
     * @return The street of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Set the street of the address.
     *
     * @param street The street of the address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Get the city of the address.
     *
     * @return The city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city of the address.
     *
     * @param city The city of the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state of the address.
     *
     * @return The state of the address.
     */
    public String getState() {
        return state;
    }

    /**
     * Set the state of the address.
     *
     * @param state The state of the address.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Get the ZIP code of the address.
     *
     * @return The ZIP code of the address.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set the ZIP code of the address.
     *
     * @param zip The ZIP code of the address.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
}
