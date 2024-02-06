package com.temelio.builders;

import com.temelio.core.models.Nonprofit;

public class NonprofitBuilder {
    private final Nonprofit nonprofit;

    public NonprofitBuilder(Nonprofit oldNonprofit) {
        this.nonprofit = oldNonprofit;
    }

    public NonprofitBuilder updateFieldsFromUserInput( Nonprofit updatedNonprofit) {

        if (updatedNonprofit.getLegalName() != null) {
            nonprofit.setLegalName(updatedNonprofit.getLegalName());
        }

        if (updatedNonprofit.getEin() != null) {
            nonprofit.setEin(updatedNonprofit.getEin());
        }

        if (updatedNonprofit.getMission() != null) {
            nonprofit.setMission(updatedNonprofit.getMission());
        }

        if (updatedNonprofit.getAddress() != null) {
            nonprofit.setAddress(updatedNonprofit.getAddress());
        }

        return this;
    }

    public Nonprofit build() {
        return nonprofit;
    }
}
