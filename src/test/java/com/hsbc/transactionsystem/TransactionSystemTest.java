package com.hsbc.transactionsystem;

import com.hsbc.transactionsystem.bean.TransactionRecord;
import com.hsbc.transactionsystem.common.PageResponse;
import com.hsbc.transactionsystem.common.Result;
import com.hsbc.transactionsystem.controller.TransactionSystemController;
import com.hsbc.transactionsystem.param.CreateTransactionRequest;
import com.hsbc.transactionsystem.param.DeleteTransactionRequest;
import com.hsbc.transactionsystem.param.QueryTransactionRecordRequest;
import com.hsbc.transactionsystem.param.UpdateTransactionRequest;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class TransactionSystemTest {

    @Resource
    private TransactionSystemController transactionSystemController;

    @Test
    public void testCreateTransaction() {
        CreateTransactionRequest request = new CreateTransactionRequest();
        request.setTransactionId("001");
        request.setAmount(BigDecimal.ONE);
        request.setUserid("ncl");
        request.setDate(new Date());
        Result<Boolean> result = transactionSystemController.createTransactionRecord(request);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getData());
    }

    @Test
    public void testUpdateTransaction() {
        CreateTransactionRequest request = new CreateTransactionRequest();
        request.setTransactionId("001");
        request.setAmount(BigDecimal.ONE);
        request.setUserid("ncl");
        request.setDate(new Date());
        transactionSystemController.createTransactionRecord(request);

        UpdateTransactionRequest updateRequest = new UpdateTransactionRequest();
        updateRequest.setTransactionId("001");
        updateRequest.setAmount(BigDecimal.ONE);
        updateRequest.setUserid("ncl");
        updateRequest.setDate(new Date());
        Result<Boolean> result = transactionSystemController.updateTransactionRecord(updateRequest);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getData());
    }

    @Test
    public void testDeleteTransaction() {
        CreateTransactionRequest request = new CreateTransactionRequest();
        request.setTransactionId("001");
        request.setAmount(BigDecimal.ONE);
        request.setUserid("ncl");
        request.setDate(new Date());
        transactionSystemController.createTransactionRecord(request);

        DeleteTransactionRequest deleteRequest = new DeleteTransactionRequest();
        deleteRequest.setTransactionId("001");
        deleteRequest.setAmount(BigDecimal.ONE);
        deleteRequest.setUserid("ncl");
        deleteRequest.setDate(new Date());
        Result<Boolean> result = transactionSystemController.deleteTransactionRecord(deleteRequest);
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.getData());
    }

    @Test
    public void testQueryTransaction() {
        CreateTransactionRequest request = new CreateTransactionRequest();
        request.setTransactionId("001");
        request.setAmount(BigDecimal.ONE);
        request.setUserid("ncl");
        request.setDate(new Date());
        transactionSystemController.createTransactionRecord(request);
        QueryTransactionRecordRequest queryRequest = new QueryTransactionRecordRequest();
        queryRequest.setCurrentPage(1);
        queryRequest.setCurrentPage(10);

        Result<PageResponse<TransactionRecord>> pageResponseResult = transactionSystemController.queryTransactionRecord(queryRequest);
        Assertions.assertNotNull(pageResponseResult);
        Assertions.assertEquals(1, pageResponseResult.getData().getTotal());
    }
}
