package com.temelio;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import io.swagger.annotations.SwaggerDefinition;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

@SwaggerDefinition
public class DropWizardConfiguration extends Configuration {
    // TODO: implement service configuration
    @Valid
    @NotNull
    @JsonProperty("swagger")
    private SwaggerBundleConfiguration swaggerBundleConfiguration;
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }

    public SwaggerBundleConfiguration getSwaggerBundleConfiguration() {
        return swaggerBundleConfiguration;
    }

    public void setSwaggerBundleConfiguration(SwaggerBundleConfiguration swaggerBundleConfiguration) {
        this.swaggerBundleConfiguration = swaggerBundleConfiguration;
    }
}
