package com.temelio;

import com.temelio.health.TemplateHealthCheck;
import com.temelio.resources.NonprofitResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

/**
 * Main Dropwizard application class.
 */
public class DropWizardApplication extends Application<DropWizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropWizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizard";
    }

    @Override
    public void initialize(Bootstrap<DropWizardConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<DropWizardConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(DropWizardConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(final DropWizardConfiguration configuration,
                    final Environment environment) {

        // Register JAX-RS resource classes
        environment.jersey().register(new NonprofitResource());

        // Register health check
        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
    }
}
