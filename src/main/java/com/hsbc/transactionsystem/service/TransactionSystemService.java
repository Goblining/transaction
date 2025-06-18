package com.hsbc.transactionsystem.service;

import com.hsbc.transactionsystem.bean.TransactionRecord;
import com.hsbc.transactionsystem.common.PageResponse;
import com.hsbc.transactionsystem.exception.BusinessException;
import com.hsbc.transactionsystem.param.CreateTransactionRequest;
import com.hsbc.transactionsystem.param.DeleteTransactionRequest;
import com.hsbc.transactionsystem.param.QueryTransactionRecordRequest;
import com.hsbc.transactionsystem.param.UpdateTransactionRequest;
import com.hsbc.transactionsystem.repository.TransactionSystemCacheService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionSystemService {

    @Resource
    private TransactionSystemCacheService transactionSystemCacheService;

    /**
     * 创建交易记录
     * @param request
     * @return
     */
    public boolean createTransactionRecord(CreateTransactionRequest request) {
        if (transactionSystemCacheService.get(request.getTransactionId()) != null) {
            throw new BusinessException("current transaction record exists");
        }
        TransactionRecord transactionRecord = new TransactionRecord();
        BeanUtils.copyProperties(request, transactionRecord);
        return transactionSystemCacheService.put(transactionRecord);
    }

    /**
     * 更新交易记录
     * @param request
     * @return
     */
    public boolean updateTransactionRecord(UpdateTransactionRequest request) {
        TransactionRecord oldTransactionRecord = transactionSystemCacheService.get(request.getTransactionId());
        if (oldTransactionRecord == null) {
            throw new BusinessException("current transaction record not exists");
        }
        TransactionRecord transactionRecord = new TransactionRecord();
        BeanUtils.copyProperties(request, transactionRecord);
        return transactionSystemCacheService.put(transactionRecord);
    }

    /**
     * 删除交易记录
     * @param request
     * @return
     */
    public boolean deleteTransactionRecord(DeleteTransactionRequest request) {
        TransactionRecord transactionRecord = transactionSystemCacheService.get(request.getTransactionId());
        if (transactionRecord == null) {
            throw new BusinessException("current transaction record not exists");
        }
        return transactionSystemCacheService.delete(request.getTransactionId());
    }

    /**
     * 查询交易记录
     * @param request
     * @return
     */
    public PageResponse<TransactionRecord> queryTransactionRecord(QueryTransactionRecordRequest request) {
        int totalCount = transactionSystemCacheService.size();
        if ((request.getPageSize() - 1) * request.getCurrentPage() >= totalCount) {
            throw new BusinessException("pageNumber or pageSize more than total count");
        }
        int startIndex = (request.getPageSize() - 1) * request.getPageSize() >= totalCount ? totalCount - 1 : (request.getPageSize() - 1) * request.getPageSize();
        int endIndex = Math.min(request.getPageSize() * request.getPageSize(), totalCount);
        List<TransactionRecord> transactionRecords = transactionSystemCacheService.queryPage(startIndex, endIndex);
        PageResponse<TransactionRecord> pageResponse = new PageResponse<>();
        pageResponse.setTotal(totalCount);
        pageResponse.setData(transactionRecords);
        return pageResponse;
    }
}
