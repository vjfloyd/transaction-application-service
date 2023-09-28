package com.electra.transactions.api.signature;

import lombok.Builder;

@Builder
public record TransactionResponse (String transactionStatus, String transactionId){
}
