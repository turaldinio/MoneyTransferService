package ru.guluev.moneytransferservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import ru.guluev.moneytransferservice.beans.AmountManager;
import ru.guluev.moneytransferservice.beans.ConfirmOperation;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferServiceApplicationTests {

    @LocalServerPort
    private String port;
    private static URI uri;
    private HttpEntity<?> entity;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void receivingATransferRequest() throws URISyntaxException {
        uri = new URI(String.format("http://localhost:%s/transfer", port));

        entity = new HttpEntity<>(new TransferManager(
                "1231231231231231",
                "12/23",
                "123",
                "3378623487623476"
                , new AmountManager("2881", "rub")
        ));
        Assertions.assertEquals(200, requestResponse(entity));
    }

    @Test
    public void receivingAConfirmOperationRequest() throws URISyntaxException {
        uri = new URI(String.format("http://localhost:%s/confirmOperation", port));

        entity = new HttpEntity<>(new ConfirmOperation(
                "1", "0000"
        ));
        Assertions.assertEquals(200, requestResponse(entity));

    }


    @Test
    public void responseErrorBadRequest() throws URISyntaxException {
        uri = new URI(String.format("http://localhost:%s/transfer", port));

        entity = new HttpEntity<>(new TransferManager(
                "12312312312312312",
                "12/23",
                "1231",
                "3378623487623476"
                , new AmountManager("2881", "rub")
        ));
        Assertions.assertEquals(400, requestResponse(entity));
    }

    @Test
    public void responseErrorInternalErrorServer() throws URISyntaxException {
        uri = new URI(String.format("http://localhost:%s/confirmOperation", port));

        entity = new HttpEntity<>(new ConfirmOperation(
                "1", "0001"
        ));
        Assertions.assertEquals(500, requestResponse(entity));
    }


    public int requestResponse(HttpEntity<?> entity) {
        return restTemplate.postForEntity(uri, entity, Operation.class).getStatusCodeValue();
    }

}
