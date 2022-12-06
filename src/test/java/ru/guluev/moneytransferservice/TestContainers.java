package ru.guluev.moneytransferservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.testcontainers.containers.GenericContainer;
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
    private GenericContainer<?> frontend = new GenericContainer<>("fronted").withExposedPorts(3000);


    @BeforeEach
    void start() {
     //   frontend.start();
        backend.start();
    }

    @Test
    void containerTest() throws URISyntaxException {
        Integer backendPort=backend.getMappedPort(5500);
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
