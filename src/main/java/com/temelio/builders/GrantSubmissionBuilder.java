package com.temelio.builders;

import com.temelio.core.models.Duration;
import com.temelio.core.models.GrantSubmission;
import com.temelio.core.models.GrantType;

import java.util.List;

/**
 * Builder class for creating instances of GrantSubmission.
 */

public class GrantSubmissionBuilder {
    private final GrantSubmission grantSubmission;

    public GrantSubmissionBuilder() {
        this.grantSubmission = new GrantSubmission();
    }
    public GrantSubmissionBuilder(GrantSubmission grantSubmission) {
        this.grantSubmission = grantSubmission;
    }

    /**
     * Set the ID for the grant submission.
     *
     * @param id The ID of the grant submission.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withId(int id) {
        grantSubmission.setId(id);
        return this;
    }

    /**
     * Set the ID of the associated nonprofit.
     *
     * @param nonprofitId The nonprofit ID.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withNonprofitId(int nonprofitId) {
        grantSubmission.setNonprofitId(nonprofitId);
        return this;
    }

    /**
     * Set the name of the grant.
     *
     * @param grantName The name of the grant.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withGrantName(String grantName) {
        if (grantName == null || grantName.isEmpty()) {
            throw new IllegalArgumentException("Grant name cannot be null or empty");
        }
        grantSubmission.setGrantName(grantName);
        return this;
    }

    /**
     * Set the requested amount for the grant.
     *
     * @param requestedAmount The requested amount for the grant.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withRequestedAmount(String requestedAmount) {
        if (requestedAmount != null) {
            grantSubmission.setRequestedAmount(requestedAmount);
        }
        return this;
    }

    /**
     * Set the awarded amount for the grant.
     *
     * @param awardedAmount The awarded amount for the grant.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withAwardedAmount(String awardedAmount) {
        if (awardedAmount != null) {
            grantSubmission.setAwardedAmount(awardedAmount);
        }
        return this;
    }

    /**
     * Set the Duration for the grant.
     * @param duration The duration for the grant.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withDuration(Duration duration) {
        if (duration != null) {
            grantSubmission.setDuration(duration);
        }
        return this;
    }

    /**
     * Set the grant type for the grant.
     *
     * @param grantType The grant type.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withGrantType(GrantType grantType) {
        if (grantType != null) {
            grantSubmission.setGrantType(grantType);
        }
        return this;
    }

    /**
     * Set the tags for the grant.
     *
     * @param tags The tags for the grant.
     * @return The GrantSubmissionBuilder instance for method chaining.
     */
    public GrantSubmissionBuilder withTags(List<String> tags) {
        if (tags != null) {
            grantSubmission.setTags(tags);
        }
        return this;
    }


    public GrantSubmissionBuilder updateFieldsFromUserInput(GrantSubmission updatedSubmission) {
        if (updatedSubmission.getGrantName() != null) {
            grantSubmission.setGrantName(updatedSubmission.getGrantName());
        }
        if (updatedSubmission.getRequestedAmount() != null) {
            grantSubmission.setRequestedAmount(updatedSubmission.getRequestedAmount());
        }
        if (updatedSubmission.getAwardedAmount() != null) {
            grantSubmission.setAwardedAmount(updatedSubmission.getAwardedAmount());
        }
        if (updatedSubmission.getGrantType() != null) {
            grantSubmission.setGrantType(updatedSubmission.getGrantType());
        }
        if (updatedSubmission.getTags() != null) {
            grantSubmission.setTags(updatedSubmission.getTags());
        }
        if (updatedSubmission.getDuration() != null) {
            grantSubmission.setDuration(updatedSubmission.getDuration());
        }

        return this;
    }
    /**
     * Build the GrantSubmission instance.
     *
     * @return The GrantSubmission instance.
     */
    public GrantSubmission build() {
        return grantSubmission;
    }
}