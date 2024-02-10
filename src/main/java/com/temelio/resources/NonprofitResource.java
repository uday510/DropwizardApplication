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
import java.util.UUID;

/**
 * REST resource for managing nonprofits.
 */
@Api()
@Path("/nonprofits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NonprofitResource {
    private final List<Nonprofit> nonprofits;

    public NonprofitResource() {
        this.nonprofits = new ArrayList<>();
    }

    /**
     * Get a list of all nonprofits.
     *
     * @return List of Nonprofit objects.
     */
    @GET
    public List<Nonprofit> getNonProfits() {
        return nonprofits;
    }

    /**
     * Get a nonprofit by its ID.
     *
     * @param id ID of the nonprofit to retrieve.
     * @return Nonprofit object.
     */
    @GET
    @Path("/{id}")
    public Nonprofit getNonprofitById(@PathParam("id") int id) {
        Nonprofit nonprofit = nonprofits.stream()
                .filter(np -> Objects.equals(np.getId(), id))
                .findFirst()
                .orElse(null);

        if (nonprofit == null) {
            throw new NotFoundException("Invalid nonprofit Id");
        }

        return nonprofit;
    }

    /**
     * Create a new nonprofit.
     *
     * @param incomingNonprofit Nonprofit object to create.
     * @return Nonprofit object.
     */
    @POST
    public int createNonprofit(Nonprofit incomingNonprofit) {
        // Generate a random int ID for the nonprofit should be positive
        int id = generateRandomId();

        // check if the nonprofit already exists
        if (nonprofits.stream().anyMatch(np -> Objects.equals(np.getEin(), incomingNonprofit.getEin()))) {
            throw new BadRequestException("Nonprofit with EIN already exists");
        }

       Nonprofit createdNonprofit = new NonprofitBuilder()
                .withId(id)
                .withLegalName(incomingNonprofit.getLegalName())
                .withEin(incomingNonprofit.getEin())
                .withMission(incomingNonprofit.getMission())
                .withAddress(incomingNonprofit.getAddress())
                .build();

        nonprofits.add(createdNonprofit);
        return createdNonprofit.getId();
    }

    /**
     * Update a nonprofit by its ID.
     */
    @PUT
    @Path("/{id}")
    public Nonprofit updateNonprofit(@PathParam("id") int nonprofitId, Nonprofit incomingNonprofit) {
        // Check if the nonprofit already exists
        Nonprofit existingNonprofit = getNonprofitById(nonprofitId);

        Nonprofit updatedNonprofit = new NonprofitBuilder(existingNonprofit)
                .updateFieldsFromUserInput(incomingNonprofit)
                .build();

        // Update the nonprofit in the list
        nonprofits.set(nonprofits.indexOf(existingNonprofit), updatedNonprofit);

        return updatedNonprofit;
    }

    /**
     * Generate a random int ID for the nonprofit should be positive
     *
     * @return int ID
     */
    /**
     * Get a list of grant submissions for a nonprofit.
     *
     * @param id ID of the nonprofit.
     * @return List of GrantSubmission objects.
     */
    @GET
    @Path("/{id}/submissions")
    public List<GrantSubmission> getSubmissions(@PathParam("id") int id) {
        Nonprofit nonprofit = getNonprofitById(id);
        return nonprofit.getGrantSubmissions();
    }

    /**
     * Create a new grant submission for a nonprofit.
     *
     * @param id               ID of the nonprofit.
     * @param incomingGrantSubmission  GrantSubmission object to be created.
     * @return ID of the created grant submission.
     */
    @POST
    @Path("/{id}/submissions")
    public int createSubmission(@PathParam("id") int id, GrantSubmission incomingGrantSubmission) {
        Nonprofit nonprofit = getNonprofitById(id);

        // print all data
        System.out.println("Grant submission creating: " + " " + incomingGrantSubmission.getGrantName() + " " + incomingGrantSubmission.getRequestedAmount() + " " + incomingGrantSubmission.getAwardedAmount() + " " + incomingGrantSubmission.getGrantType() + " " + incomingGrantSubmission.getTags() + " " + incomingGrantSubmission.getDuration() + " " + id);

        // check for the same name, assuming name is unique
        for (GrantSubmission currGrantSubmission : nonprofit.getGrantSubmissions()) {
            if (Objects.equals(currGrantSubmission, incomingGrantSubmission.getGrantName())) {
                throw new BadRequestException("Grant submission with the same name already exists");
            }
        }

        incomingGrantSubmission.setId(generateRandomId()); // Generate a random UUID as the ID
        incomingGrantSubmission.setNonprofitId(id);

        GrantSubmission updatedGrantSubmission = new GrantSubmissionBuilder(incomingGrantSubmission)
                .withId(incomingGrantSubmission.getId())
                .withNonprofitId(incomingGrantSubmission.getNonprofitId())
                .withGrantName(incomingGrantSubmission.getGrantName())
                .withRequestedAmount(incomingGrantSubmission.getRequestedAmount())
                .withAwardedAmount(incomingGrantSubmission.getAwardedAmount())
                .withGrantType(incomingGrantSubmission.getGrantType())
                .withTags(incomingGrantSubmission.getTags())
                .withDuration(incomingGrantSubmission.getDuration())
                .build();

        // set the grant submission
        nonprofit.getGrantSubmissions().add(updatedGrantSubmission);

        System.out.println("Grant submission created: " + " " + updatedGrantSubmission.getGrantName());

        return updatedGrantSubmission.getId();
    }
    /**
     * Get a grant submission by nonprofit ID and submission ID.
     *
     * @param nonprofitId ID of the nonprofit.
     * @param submissionId ID of the submission.
     * @return GrantSubmission object.
     */
    @GET
    @Path("/{nonprofitId}/submissions/{submissionId}")
    public GrantSubmission getSubmissionByNonprofitId(@PathParam("nonprofitId") int nonprofitId, @PathParam("submissionId") int submissionId) {
        Nonprofit nonprofit = getNonprofitById(nonprofitId);
        GrantSubmission grantSubmission = getGrantSubmissionById(nonprofit, submissionId);

        return grantSubmission;
    }

    /**
     * Update a grant submission by nonprofit ID and submission ID.
     *
     * @param nonprofitId      ID of the nonprofit.
     * @param submissionId     ID of the submission.
     * @param updatedSubmission Updated GrantSubmission object.
     * @return Updated GrantSubmission object.
     */
    @PUT
    @Path("/{nonprofitId}/submissions/{submissionId}")
    public GrantSubmission updateSubmissionByNonprofitId(@PathParam("nonprofitId") int nonprofitId, @PathParam("submissionId") int submissionId, GrantSubmission updatedSubmission) {
        Nonprofit nonprofit = getNonprofitById(nonprofitId);
        GrantSubmission grantSubmission = getGrantSubmissionById(nonprofit, submissionId);

        GrantSubmission updatedGrantSubmission = new GrantSubmissionBuilder(grantSubmission)
                .updateFieldsFromUserInput(updatedSubmission)
                .build();

        // Update the grant submission in the list
        nonprofit.getGrantSubmissions().set(nonprofit.getGrantSubmissions().indexOf(grantSubmission), updatedGrantSubmission);

        return updatedGrantSubmission;
    }

    /**
     * Get a list of all grant submissions for all nonprofits.
     *
     * @return List of Lists of GrantSubmission objects.
     */
    @GET
    @Path("/submissions")
    public List<List<GrantSubmission>> grantSubmissionList() {
        List<List<GrantSubmission>> grantSubmissions = new ArrayList<>();

        for (Nonprofit nonprofit : nonprofits) {
            grantSubmissions.add(nonprofit.getGrantSubmissions());
        }

        return grantSubmissions;
    }

    /**
     * Get a grant submission by its ID.
     *
     * @param id ID of the grant submission.
     * @return GrantSubmission object.
     */
    private GrantSubmission getGrantSubmissionById(Nonprofit nonprofit, int id) {
        GrantSubmission grantSubmission = nonprofit.getGrantSubmissions().stream()
                .filter(gs -> Objects.equals(gs.getId(), id))
                .findFirst()
                .orElse(null);

        if (grantSubmission == null) {
            throw new NotFoundException("Invalid submission Id");
        }

        return grantSubmission;
    }


    private int generateRandomId() {
        // id should be positive
        return Math.abs(UUID.randomUUID().hashCode() & 1000);
    }
}
