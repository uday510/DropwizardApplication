package com.temelio;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

import javax.validation.constraints.NotEmpty;

/**
 * Dropwizard configuration class.
 */
public class DropWizardConfiguration extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    /**
     * Get the template value.
     *
     * @return The template value.
     */
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    /**
     * Set the template value.
     *
     * @param template The template value.
     */
    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    /**
     * Get the default name value.
     *
     * @return The default name value.
     */
    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    /**
     * Set the default name value.
     *
     * @param name The default name value.
     */
    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}
