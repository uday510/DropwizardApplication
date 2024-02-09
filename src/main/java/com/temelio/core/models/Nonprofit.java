package com.temelio.core.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a nonprofit organization.
 */
public class Nonprofit {
    private String legalName;
    private String ein;
    private String mission;
    private Address address;
    private int id;
    private List<GrantSubmission> grantSubmissions;

    /**
     * Default constructor initializes the list of grant submissions.
     */
    public Nonprofit() {
        this.grantSubmissions = new ArrayList<>();
    }

    /**
     * Get the unique identifier of the nonprofit.
     *
     * @return The nonprofit's unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the unique identifier of the nonprofit.
     *
     * @param id The nonprofit's unique identifier.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the legal name of the nonprofit.
     *
     * @return The legal name of the nonprofit.
     */
    public String getLegalName() {
        return legalName;
    }

    /**
     * Set the legal name of the nonprofit.
     *
     * @param legalName The legal name of the nonprofit.
     */
    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    /**
     * Get the Employer Identification Number (EIN) of the nonprofit.
     *
     * @return The EIN of the nonprofit.
     */
    public String getEin() {
        return ein;
    }

    /**
     * Set the Employer Identification Number (EIN) of the nonprofit.
     *
     * @param ein The EIN of the nonprofit.
     */
    public void setEin(String ein) {
        this.ein = ein;
    }

    /**
     * Get the mission statement of the nonprofit.
     *
     * @return The mission statement of the nonprofit.
     */
    public String getMission() {
        return mission;
    }

    /**
     * Set the mission statement of the nonprofit.
     *
     * @param mission The mission statement of the nonprofit.
     */
    public void setMission(String mission) {
        this.mission = mission;
    }

    /**
     * Get the address of the nonprofit.
     *
     * @return The address of the nonprofit.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Set the address of the nonprofit.
     *
     * @param address The address of the nonprofit.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Get the list of grant submissions associated with the nonprofit.
     *
     * @return List of GrantSubmission objects.
     */
    public List<GrantSubmission> getGrantSubmissions() {
        return grantSubmissions;
    }

    /**
     * Set the list of grant submissions associated with the nonprofit.
     *
     * @param grantSubmissions List of GrantSubmission objects.
     */
    public void setGrantSubmissions(List<GrantSubmission> grantSubmissions) {
        this.grantSubmissions = grantSubmissions;
    }
}
