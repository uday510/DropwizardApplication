package com.temelio.core.models;

import java.util.Date;

// Duration.java
public class Duration {
    private String grantStart;
    private String grantEnd;

    public Duration() {}
    public String getGrantStart() {
        return grantStart;
    }

    public void setGrantStart(String grantStart) {
        this.grantStart = grantStart;
    }

    public String getGrantEnd() {
        return grantEnd;
    }

    public void setGrantEnd(String grantEnd) {
        this.grantEnd = grantEnd;
    }
}
