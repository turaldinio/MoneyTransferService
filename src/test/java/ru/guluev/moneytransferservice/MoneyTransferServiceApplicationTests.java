package ru.guluev.moneytransferservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import ru.guluev.moneytransferservice.beans.AmountManager;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;

import java.net.URI;
import java.net.URISyntaxException;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoneyTransferServiceApplicationTests {

    @LocalServerPort
    private String currentApplicationPort;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void receivingATransferRequest() {
        URI url = null;
        try {
            url = new URI(String.format("http://localhost:%s/transfer", currentApplicationPort));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        HttpEntity<TransferManager> entity = new HttpEntity<>(new TransferManager(
                "1231231231231231",
                "12/23",
                "123",
                "3378623487623476"
                , new AmountManager(2881, "rub")
        ));
        var result = restTemplate.postForEntity(url, entity, Operation.class);
        Assertions.assertEquals(200, result.getStatusCodeValue());

    }


}
