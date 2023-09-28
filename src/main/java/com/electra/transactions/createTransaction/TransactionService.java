package com.electra.transactions.createTransaction;


import com.electra.transactions.api.caller.TransactionApiCaller;
import com.electra.transactions.createTransaction.dto.TransactionRequest;
import com.electra.transactions.createTransaction.dto.TransactionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class TransactionService {

    private TransactionApiCaller transactionApiCaller;

    public TransactionService(TransactionApiCaller transactionApiCaller) {
        this.transactionApiCaller = transactionApiCaller;
    }

    public TransactionResponse callTransactionBss(TransactionRequest transactionRequest) throws IOException {
        com.electra.transactions.api.signature.TransactionResponse transactionResponse = null;
        try {
            transactionResponse = transactionApiCaller.createTransaction(transactionRequest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return TransactionResponse.builder()
                .transactionStatus(transactionResponse.transactionStatus())
                .transactionId(transactionResponse.transactionId())
                .build();
    }

}
