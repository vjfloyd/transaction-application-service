//package com.electra.transactions.createTransaction;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//
//import static org.hamcrest.Matchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//
//class TransactionServiceTest {
//
//    @InjectMocks
//    private TransactionService transactionService;
//    @Mock
//    private TransactionRequest transactionRequest;
//
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    void callTransctionBss() {
//       TransactionResponse transactionResponse = transactionService.callTransctionBss(transactionRequest)  ;
//        Assertions.assertNotNull(transactionResponse);
//    }
//}