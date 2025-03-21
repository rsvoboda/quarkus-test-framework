package io.quarkus.test.logging;

import io.quarkus.test.bootstrap.Service;
import io.quarkus.test.configuration.Configuration;

public abstract class ServiceLoggingHandler extends LoggingHandler {

    private final Service service;

    public ServiceLoggingHandler(Service service) {
        this.service = service;
    }

    @Override
    protected void logInfo(String line) {
        Log.info(service, line);
    }

    @Override
    protected boolean isLogEnabled() {
        return service.getConfiguration().isTrue(Configuration.Property.LOG_ENABLE);
    }

}
