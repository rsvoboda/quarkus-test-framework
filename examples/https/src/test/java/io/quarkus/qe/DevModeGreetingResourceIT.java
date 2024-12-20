package io.quarkus.qe;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.quarkus.test.bootstrap.DevModeQuarkusService;
import io.quarkus.test.scenarios.QuarkusScenario;
import io.quarkus.test.services.Certificate;
import io.quarkus.test.services.DevModeQuarkusApplication;

@QuarkusScenario
public class DevModeGreetingResourceIT {
    @DevModeQuarkusApplication(ssl = true, certificates = @Certificate(configureKeystore = true, configureHttpServer = true, useTlsRegistry = false))
    static final DevModeQuarkusService app = new DevModeQuarkusService();

    @Test
    public void shouldOpenDevUi() {
        app.given().get("/q/dev").then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldOpenHttpsDevUi() {
        app.relaxedHttps().get("/q/dev").then().statusCode(HttpStatus.SC_OK);
    }
}
