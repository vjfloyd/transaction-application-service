package com.electra.transactions.createTransaction;

import com.electra.transactions.api.caller.TransactionApiCaller;
import com.electra.transactions.api.signature.TransactionResponse;
import com.electra.transactions.createTransaction.dto.TransactionApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.IOException;
import java.math.BigDecimal;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @InjectMocks
    private TransactionService transactionService;
    @Mock
    private TransactionApiCaller transactionApiCaller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenApiResponseIsSuccessfully_thenResponseStatusIsAccepted() throws IOException {
        TransactionResponse response = TransactionResponse.builder()
                .transactionId("1322312")
                .transactionStatus("ACCEPTED")
                .build();
        TransactionApiRequest transactionRequest = new TransactionApiRequest("4566","12345","1234", new BigDecimal(20.45));
        when(transactionApiCaller.createTransaction(transactionRequest)).thenReturn(response);
        com.electra.transactions.createTransaction.dto.TransactionResponse transactionResponse =
                transactionService.callTransactionApi(transactionRequest);
        Assertions.assertNotNull(transactionResponse);
        Assertions.assertEquals("ACCEPTED",transactionResponse.transactionStatus());
    }
}