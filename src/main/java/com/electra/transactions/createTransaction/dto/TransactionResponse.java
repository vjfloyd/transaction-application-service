package com.electra.transactions.createTransaction.dto;


import lombok.Builder;

@Builder
public record TransactionResponse(String transactionId, String transactionStatus) {

}
