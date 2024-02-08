package com.temelio.resources;

import com.temelio.builders.GrantSubmissionBuilder;
import com.temelio.builders.NonprofitBuilder;
import com.temelio.core.models.GrantSubmission;
import com.temelio.core.models.Nonprofit;
import io.swagger.annotations.Api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Api()
@Path("/nonprofits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NonprofitResource {
    private final List<Nonprofit> nonprofits;
    public NonprofitResource() {
        this.nonprofits = new ArrayList<>();
    }
    @GET
    public List<Nonprofit> getNonProfits() {
        return nonprofits;
    }

    @POST
    public Nonprofit createNonProfit(Nonprofit nonProfit){
        if (nonProfit == null) {
            throw new BadRequestException("Nonprofit cannot be null");
        }

        if (nonProfit.getLegalName() == null || nonProfit.getLegalName().isEmpty()) {
            throw new BadRequestException("Legal name cannot be null or empty");
        }

        // check for same legal name , assuming legal name is unique
        for (Nonprofit currNonProfit : nonprofits) {
            if (Objects.equals(currNonProfit.getLegalName(), nonProfit.getLegalName())) {
                throw new BadRequestException("Non profit same legal name already exists");
            }
        }
        nonprofits.add(nonProfit);
        return nonProfit;
    }

    @GET
    @Path("/{id}")
    public Nonprofit getNonprofitById(@PathParam("id") int id) {
        if (id < 0 || id >= nonprofits.size())
            throw new NotFoundException("invalid nonprofit Id");

        return nonprofits.get(id);
    }

    @PUT
    @Path("/{id}")
    public Nonprofit updateNonProfit(@PathParam("id") int id, Nonprofit updatedNonprofit) {
       getNonprofitById(id);

       Nonprofit updated = new NonprofitBuilder(nonprofits.get(id))
               .updateFieldsFromUserInput(updatedNonprofit)
               .build();

       nonprofits.set(id, updated);

       return updated;
    }


    @GET
    @Path("/{id}/submissions")
    public List<GrantSubmission> getSubmissions(@PathParam("id") int id) {
        // check for valid nonprofitId
        getNonprofitById(id);

        return nonprofits.get(id).getGrantSubmissions();
    }


    @POST
    @Path("/{id}/submissions")
    public GrantSubmission createSubmission(@PathParam("id") int id, GrantSubmission grantSubmission) {
        if (grantSubmission == null) {
            throw new BadRequestException("Grant submission cannot be null");
        }

        if (grantSubmission.getGrantName() == null || grantSubmission.getGrantName().isEmpty()) {
            throw new BadRequestException("Grant submission name cannot be null or empty");
        }
        // check for valid nonprofitId
        getNonprofitById(id);

        // check for same name , assuming  name is unique
        for (GrantSubmission currGrantSubmission  : nonprofits.get(id).getGrantSubmissions()) {

            if (Objects.equals(currGrantSubmission.getGrantName(), grantSubmission.getGrantName())) {
                throw new BadRequestException("Grant submission with same name already exists");
            }
        }

        grantSubmission.setNonprofitId(id);
        this.nonprofits.get(id).getGrantSubmissions().add(grantSubmission);

        return grantSubmission;
    }

    @GET
    @Path("/{nonprofitId}/submissions/{submissionId}")
    public GrantSubmission getSubmissionByNonprofitId(@PathParam("nonprofitId") int nonprofitId, @PathParam("submissionId") int submissionId) {
        // check for valid nonprofitId
        checkForValid(nonprofitId, submissionId);

        GrantSubmission grantSubmission = nonprofits.get(nonprofitId).getGrantSubmissions().get(submissionId);

        return grantSubmission;
    }

    @PUT
    @Path("/{nonprofitId}/submissions/{submissionId}")
    public GrantSubmission updateSubmissionByNonprofitId(@PathParam("nonprofitId") int nonprofitId, @PathParam("submissionId") int submissionId, GrantSubmission updatedSubmission) {
        // check for valid nonprofitId
       checkForValid(nonprofitId, submissionId);

        GrantSubmission updated = new GrantSubmissionBuilder(nonprofits.get(nonprofitId).getGrantSubmissions().get(submissionId))
                .updateFieldsFromUserInput(updatedSubmission)
                .build();

        nonprofits.get(nonprofitId).getGrantSubmissions().set(submissionId, updatedSubmission);
        return updated;
    }

    @GET
    @Path("/submissions")
    public List<List<GrantSubmission>> grantSubmissionlist() {
        List<List<GrantSubmission>> grantSubmissions = new ArrayList<>();

        for (Nonprofit nonprofit : nonprofits) {
            grantSubmissions.add(nonprofit.getGrantSubmissions());
        }

        return grantSubmissions;
    }

    public void checkForValid(int nonprofitId, int submissionId) {
        // check for valid nonprofitId
        getNonprofitById(nonprofitId);

        List<GrantSubmission> grantSubmissions = nonprofits.get(nonprofitId).grantSubmissions;

        if (submissionId < 0 || submissionId >= grantSubmissions.size()) {
            throw new NotFoundException("invalid submission Id");
        }
    }
}
