package com.temelio;

import com.codahale.metrics.health.HealthCheck;
import com.temelio.core.models.Nonprofit;
import com.temelio.health.TemplateHealthCheck;
import com.temelio.resources.HelloWorldResource;
import com.temelio.resources.NonprofitResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

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
        // TODO: implement application

        environment.jersey().register(new HelloWorldResource());
        environment.jersey().register(new NonprofitResource());

        // getting-started: HelloWorldApplication#run->TemplateHealthCheck
        TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        // getting-started: HelloWorldApplication#run->TemplateHealthCheck

    }
}
