package com.electra.transactions.createTransaction;


import com.electra.transactions.api.caller.TransactionApiCaller;
import com.electra.transactions.createTransaction.dto.TransactionApiRequest;
import com.electra.transactions.createTransaction.dto.TransactionResponse;
import com.electra.transactions.exceptions.TransactionNotFoundException;
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

    public TransactionResponse callTransactionApi(TransactionApiRequest transactionRequest) {
        com.electra.transactions.api.signature.TransactionResponse transactionResponse = null;
        try {
            transactionResponse = transactionApiCaller.createTransaction(transactionRequest);
        } catch (NullPointerException e) {
            throw new TransactionNotFoundException(e.getMessage());
        } catch (IOException e) {
            log.error("Error in callTransactionApi ", e.getMessage());
        }
        return TransactionResponse.builder()
                .transactionStatus(transactionResponse.transactionStatus())
                .transactionId(transactionResponse.transactionId())
                .build();
    }

}
