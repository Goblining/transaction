package com.hsbc.transactionsystem.controller;

import com.hsbc.transactionsystem.bean.TransactionRecord;
import com.hsbc.transactionsystem.common.PageResponse;
import com.hsbc.transactionsystem.common.Result;
import com.hsbc.transactionsystem.exception.BusinessException;
import com.hsbc.transactionsystem.param.CreateTransactionRequest;
import com.hsbc.transactionsystem.param.DeleteTransactionRequest;
import com.hsbc.transactionsystem.param.QueryTransactionRecordRequest;
import com.hsbc.transactionsystem.param.UpdateTransactionRequest;
import com.hsbc.transactionsystem.service.TransactionSystemService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transaction")
public class TransactionSystemController {

    @Resource
    private TransactionSystemService transactionSystemService;

    @RequestMapping("/createTransaction")
    public Result<Boolean> createTransactionRecord(@RequestBody CreateTransactionRequest request) {
        try {
            boolean result = transactionSystemService.createTransactionRecord(request);
            return Result.success(result);
        } catch (BusinessException e) {
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            return Result.systemFail();
        }
    }

    @RequestMapping("/createTransaction")
    public Result<Boolean> updateTransactionRecord(@RequestBody UpdateTransactionRequest request) {
        try {
            boolean result = transactionSystemService.updateTransactionRecord(request);
            return Result.success(result);
        } catch (BusinessException e) {
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            return Result.systemFail();
        }

    }

    @RequestMapping("/createTransaction")
    public Result<Boolean> deleteTransactionRecord(@RequestBody DeleteTransactionRequest request) {
        try {
            boolean result = transactionSystemService.deleteTransactionRecord(request);
            return Result.success(result);
        } catch (BusinessException e) {
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            return Result.systemFail();
        }
    }

    @RequestMapping("/queryTransactionRecord")
    public Result<PageResponse<TransactionRecord>> queryTransactionRecord(@RequestBody QueryTransactionRecordRequest request) {
        try {
            PageResponse<TransactionRecord> pageResponse = transactionSystemService.queryTransactionRecord(request);
            return Result.success(pageResponse);
        } catch (BusinessException e) {
            return Result.fail(e.getMessage());
        } catch (Exception e) {
            return Result.systemFail();
        }
    }


}
