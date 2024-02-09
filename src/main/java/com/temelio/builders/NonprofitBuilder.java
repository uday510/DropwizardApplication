package com.temelio.builders;

import com.temelio.core.models.Address;
import com.temelio.core.models.Nonprofit;

/**
 * Builder class for creating instances of Nonprofit.
 */
public class NonprofitBuilder {
    private final Nonprofit nonprofit;

    public NonprofitBuilder() {
        this.nonprofit = new Nonprofit();
    }
    public NonprofitBuilder(Nonprofit existingNonprofit) {
        this.nonprofit = existingNonprofit;
    }

    /**
     * Set the legal name for the nonprofit.
     *
     * @param legalName The legal name of the nonprofit.
     * @return The NonprofitBuilder instance for method chaining.
     */
    public NonprofitBuilder withLegalName(String legalName) {
        if (legalName == null || legalName.isEmpty()) {
            throw new IllegalArgumentException("Legal name cannot be null or empty");
        }
        nonprofit.setLegalName(legalName);
        return this;
    }

    /**
     * Set the EIN (Employer Identification Number) for the nonprofit.
     *
     * @param ein The EIN of the nonprofit.
     * @return The NonprofitBuilder instance for method chaining.
     */
    public NonprofitBuilder withEin(String ein) {
        if (ein != null && !ein.isEmpty()) {
            nonprofit.setEin(ein);
        }
        return this;
    }

    /**
     * Set the mission of the nonprofit.
     *
     * @param mission The mission of the nonprofit.
     * @return The NonprofitBuilder instance for method chaining.
     */
    public NonprofitBuilder withMission(String mission) {
        if (mission != null && !mission.isEmpty()) {
            nonprofit.setMission(mission);
        }
        return this;
    }

    /**
     * Set the address for the nonprofit.
     *
     * @param address The address of the nonprofit.
     * @return The NonprofitBuilder instance for method chaining.
     */
    public NonprofitBuilder withAddress(Address address) {
        if (address != null) {
            nonprofit.setAddress(address);
        }
        return this;
    }

    /**
     * Set the ID for the nonprofit.
     *
     * @param id The ID of the nonprofit.
     * @return The NonprofitBuilder instance for method chaining.
     */
    public NonprofitBuilder withId(int id) {
        nonprofit.setId(id);
        return this;
    }

    /**
     *  Update the nonprofit with the given values.
     *
     */
    public NonprofitBuilder updateFieldsFromUserInput(Nonprofit userInput) {
        if (userInput.getLegalName() != null) {
            nonprofit.setLegalName(userInput.getLegalName());
        }
        if (userInput.getEin() != null) {
            nonprofit.setEin(userInput.getEin());
        }
        if (userInput.getMission() != null) {
            nonprofit.setMission(userInput.getMission());
        }
        if (userInput.getAddress() != null) {
            nonprofit.setAddress(userInput.getAddress());
        }
        if (userInput.getGrantSubmissions() != null) {
            nonprofit.setGrantSubmissions(userInput.getGrantSubmissions());
        }

        return this;
    }

    /**
     * Build the Nonprofit instance.
     *
     * @return The created Nonprofit instance.
     */
    public Nonprofit build() {
        return nonprofit;
    }
}
