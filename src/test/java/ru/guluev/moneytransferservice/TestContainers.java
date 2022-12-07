package ru.guluev.moneytransferservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import ru.guluev.moneytransferservice.beans.AmountManager;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestContainers {
    @Autowired
    private TestRestTemplate restTemplate;
    private static URI uri;


    private GenericContainer<?> backend = new GenericContainer<>("backend").withExposedPorts(5500);
    private GenericContainer<?> frontend = new GenericContainer<>("front:v1").withExposedPorts(3000);

    @Test
    void containerFrontendTest() throws URISyntaxException {
        frontend.start();

        frontend.waitingFor(Wait.forLogMessage("Compiled", 3));

        String backendPort = String.valueOf(frontend.getMappedPort(3000));
        uri = new URI(String.format("http://localhost:%s", backendPort));

        Assertions.assertEquals(200, restTemplate.getForEntity(uri, String.class).getStatusCodeValue());


    }


    @Test
    void containerTest() throws URISyntaxException {
        backend.start();

        Integer backendPort = backend.getMappedPort(5500);
        uri = new URI(String.format("http://localhost:%s/transfer", backendPort));

        var entity = new HttpEntity<>(new TransferManager(
                "1231231231231231",
                "12/23",
                "123",
                "3378623487623476"
                , new AmountManager("2881", "rub")

        ));
        Assertions.assertEquals(200, requestResponse(entity));

    }

    public int requestResponse(HttpEntity<?> entity) {
        return restTemplate.postForEntity(uri, entity, Operation.class).getStatusCodeValue();
    }
}
