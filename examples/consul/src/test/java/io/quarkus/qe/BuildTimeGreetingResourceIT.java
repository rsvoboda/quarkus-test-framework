package io.quarkus.qe;

import static org.hamcrest.Matchers.is;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import io.quarkus.test.bootstrap.RestService;
import io.quarkus.test.scenarios.QuarkusScenario;
import io.quarkus.test.services.QuarkusApplication;

@QuarkusScenario
public class BuildTimeGreetingResourceIT {

    @QuarkusApplication
    static final RestService app = new RestService()
            .withProperty("quarkus.consul-config.enabled", "false")
            .withProperty("quarkus.http.root-path", "/root"); // property to force build app at test time.

    @Test
    public void shouldFindPropertyFromCustomSource() {
        app.given().get("/root/api/from-custom-source")
                .then().statusCode(HttpStatus.SC_OK).body(is("Hello Config Source!"));
    }
}
