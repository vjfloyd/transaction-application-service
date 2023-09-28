package com.electra.transactions.util.globalVariables;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PropertiesEnv {

    @Value("${api.internal-services.transaction-api.base-url}")
    private String apiPath;

}