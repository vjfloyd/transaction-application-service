package com.electra.transactions.createTransaction.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TransactionRequest (@NotEmpty(message = "transactionType no puede ser vacio")
                                  @NotNull(message = "transactionType no puede ser nulo")
                                  @Pattern(regexp = "[a-zA-Z0-9_\\-]+",message = "TransactionType debe ser Alphanumerico")
                                  String transactionType,
                                  @NotEmpty(message = "destinationAccount no puede ser vacio")
                                  @NotNull(message = "destinationAccount no puede ser nulo")
                                  @Size(min=4, max= 12)
                                  String destinationAccount,
                                  @NotEmpty(message = "originAccount no puede ser vacio")
                                  @NotNull(message = "originAccount no puede ser nulo")
                                  @Size(min=4, max= 12) String originAccount,
                                  @NotNull(message = "amount no puede ser nulo")
                                  BigDecimal amount) {
}
