package com.electra.transactions.createTransaction;


import com.electra.transactions.createTransaction.dto.TransactionApiRequest;
import com.electra.transactions.createTransaction.dto.TransactionResponse;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/application-services/v1/transactions")
public class TransactionsResource {
    private TransactionService transactionService;
    public TransactionsResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @SneakyThrows
    @PostMapping
    private ResponseEntity<TransactionResponse> createTransaction(@Valid @RequestBody TransactionApiRequest transactionRequest){
        TransactionResponse transactionResponse = transactionService.callTransactionApi(transactionRequest);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

}
