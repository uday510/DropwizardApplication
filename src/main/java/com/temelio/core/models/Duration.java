package com.temelio.core.models;

/**
 * Represents the duration of a grant.
 */
public class Duration {
    private String grantStart;
    private String grantEnd;

    /**
     * Default constructor for Duration.
     */
    public Duration() {
    }

    /**
     * Get the start date of the grant.
     *
     * @return The start date of the grant.
     */
    public String getGrantStart() {
        return grantStart;
    }

    /**
     * Set the start date of the grant.
     *
     * @param grantStart The start date of the grant.
     */
    public void setGrantStart(String grantStart) {
        this.grantStart = grantStart;
    }

    /**
     * Get the end date of the grant.
     *
     * @return The end date of the grant.
     */
    public String getGrantEnd() {
        return grantEnd;
    }

    /**
     * Set the end date of the grant.
     *
     * @param grantEnd The end date of the grant.
     */
    public void setGrantEnd(String grantEnd) {
        this.grantEnd = grantEnd;
    }
}
