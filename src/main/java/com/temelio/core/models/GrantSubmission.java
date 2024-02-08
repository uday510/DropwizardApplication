package com.temelio.core.models;

import java.util.ArrayList;
import java.util.List;

public class GrantSubmission {
    private int nonprofitId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String grantName;
    private String requestedAmount;
    private String awardedAmount;
    private GrantType grantType;
    private List<String> tags;
    private Duration duration;

    public long getNonprofitId() {
        return nonprofitId;
    }

    public void setNonprofitId(int nonprofitId) {
        this.nonprofitId = nonprofitId;
    }

    public String getGrantName() {
        return grantName;
    }

    public void setGrantName(String grantName) {
        this.grantName = grantName;
    }

    public String getRequestedAmount() {
        return requestedAmount;
    }

    public void setRequestedAmount(String requestedAmount) {
        this.requestedAmount = requestedAmount;
    }

    public String getAwardedAmount() {
        return awardedAmount;
    }

    public void setAwardedAmount(String awardedAmount) {
        this.awardedAmount = awardedAmount;
    }

    public GrantType getGrantType() {
        return grantType;
    }

    public void setGrantType(GrantType grantType) {
        this.grantType = grantType;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
