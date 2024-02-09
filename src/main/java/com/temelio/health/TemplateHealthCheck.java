package com.temelio.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * Health check for a template.
 */
public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    /**
     * Constructs a TemplateHealthCheck with the given template.
     *
     * @param template The template to be checked.
     */
    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    /**
     * Checks the health of the template.
     *
     * @return A health check result.
     * @throws Exception If an exception occurs during the health check.
     */
    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "John Doe");

        if (!saying.contains("John Doe")) {
            return Result.unhealthy("Template does not contain the expected placeholder for a name");
        }

        return Result.healthy();
    }
}
