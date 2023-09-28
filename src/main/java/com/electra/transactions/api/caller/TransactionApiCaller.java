package com.electra.transactions.api.caller;

import com.electra.transactions.api.signature.TransactionApi;
import com.electra.transactions.api.signature.TransactionResponse;
import com.electra.transactions.createTransaction.dto.TransactionApiRequest;
import com.electra.transactions.util.globalVariables.PropertiesEnv;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Component
public class TransactionApiCaller {
    private PropertiesEnv propertiesEnv;

    public TransactionApiCaller(PropertiesEnv propertiesEnv) {
        this.propertiesEnv = propertiesEnv;
    }

    public TransactionResponse createTransaction(TransactionApiRequest transactionRequest) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(propertiesEnv.getApiPath())
                 .addConverterFactory(GsonConverterFactory.create()).build();
        TransactionApi transactionApi = retrofit.create(TransactionApi.class);
        Call<TransactionResponse> transactionResponse = transactionApi.createTransaction(transactionRequest);
        return transactionResponse.execute().body();
    }
}
