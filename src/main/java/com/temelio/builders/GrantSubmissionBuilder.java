package com.temelio.builders;

import com.temelio.core.models.GrantSubmission;

public class GrantSubmissionBuilder {
    private final GrantSubmission grantSubmission;

    public GrantSubmissionBuilder(GrantSubmission oldSubmission) {
        this.grantSubmission = oldSubmission;
    }

    public GrantSubmissionBuilder updateFieldsFromUserInput(GrantSubmission userInput) {
        if (userInput.getGrantName() != null) {
            grantSubmission.setGrantName(userInput.getGrantName());
        }

        if (userInput.getRequestedAmount() != null) {
            grantSubmission.setRequestedAmount(userInput.getRequestedAmount());
        }

        if (userInput.getAwardedAmount() != null) {
            grantSubmission.setAwardedAmount(userInput.getAwardedAmount());
        }

        if (userInput.getGrantType() != null) {
            grantSubmission.setGrantType(userInput.getGrantType());
        }

        if (userInput.getTags() != null) {
            grantSubmission.setTags(userInput.getTags());
        }

        if (userInput.getDuration() != null) {
            grantSubmission.setDuration(userInput.getDuration());
        }

        return this;
    }

    public GrantSubmission build() {
        return grantSubmission;
    }
}
