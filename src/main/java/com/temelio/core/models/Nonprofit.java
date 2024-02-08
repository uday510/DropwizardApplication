package com.temelio.core.models;

import java.util.ArrayList;
import java.util.List;

public class Nonprofit {
    private String legalName;
    private String ein;
    private String mission;
    private Address address;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<GrantSubmission> grantSubmissions;
    public Nonprofit() {
        this.grantSubmissions = new ArrayList<>();
    };

    public String getLegalName() {
        return legalName;
    }

    public List<GrantSubmission> getGrantSubmissions() {
        return grantSubmissions;
    }

    public void setGrantSubmissions(List<GrantSubmission> grantSubmissions) {
        this.grantSubmissions = grantSubmissions;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
