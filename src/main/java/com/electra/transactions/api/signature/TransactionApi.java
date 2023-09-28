package com.electra.transactions.api.signature;

import com.electra.transactions.createTransaction.dto.TransactionRequest;
import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface TransactionApi {
    @Headers({ "Accept: application/json" })
    @POST("v1/transactions")
    Call<TransactionResponse> createTransaction(@Body TransactionRequest transactionRequest);

}
