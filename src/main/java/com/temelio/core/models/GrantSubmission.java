package com.temelio.core.models;

import java.util.List;

/**
 * Represents a grant submission.
 */
public class GrantSubmission {
    private int nonprofitId;
    private int id;
    private String grantName;
    private String requestedAmount;
    private String awardedAmount;
    private GrantType grantType;
    private List<String> tags;
    private Duration duration;

    public GrantSubmission() {}

    /**
     * Get the ID of the grant submission.
     *
     * @return The ID of the grant submission.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the grant submission.
     *
     * @param id The ID of the grant submission.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the ID of the associated nonprofit.
     *
     * @return The nonprofit ID.
     */
    public int getNonprofitId() {
        return nonprofitId;
    }

    /**
     * Set the ID of the associated nonprofit.
     *
     * @param nonprofitId The nonprofit ID.
     */
    public void setNonprofitId(int nonprofitId) {
        this.nonprofitId = nonprofitId;
    }

    /**
     * Get the name of the grant.
     *
     * @return The name of the grant.
     */
    public String getGrantName() {
        return grantName;
    }

    /**
     * Set the name of the grant.
     *
     * @param grantName The name of the grant.
     */
    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    /**
     * Get the requested amount for the grant.
     *
     * @return The requested amount.
     */
    public String getRequestedAmount() {
        return requestedAmount;
    }

    /**
     * Set the requested amount for the grant.
     *
     * @param requestedAmount The requested amount.
     */
    public void setRequestedAmount(String requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    /**
     * Get the awarded amount for the grant.
     *
     * @return The awarded amount.
     */
    public String getAwardedAmount() {
        return awardedAmount;
    }

    /**
     * Set the awarded amount for the grant.
     *
     * @param awardedAmount The awarded amount.
     */
    public void setAwardedAmount(String awardedAmount) {
        this.awardedAmount = awardedAmount;
    }

    /**
     * Get the type of the grant.
     *
     * @return The grant type.
     */
    public GrantType getGrantType() {
        return grantType;
    }

    /**
     * Set the type of the grant.
     *
     * @param grantType The grant type.
     */
    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    /**
     * Get the tags associated with the grant.
     *
     * @return List of tags.
     */
    public List<String> getTags() {
        return tags;
    }

    /**
     * Set the tags associated with the grant.
     *
     * @param tags List of tags.
     */
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    /**
     * Get the duration of the grant.
     *
     * @return The duration of the grant.
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Set the duration of the grant.
     *
     * @param duration The duration of the grant.
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
