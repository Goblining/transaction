package com.hsbc.transactionsystem.repository;

import com.hsbc.transactionsystem.bean.TransactionRecord;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TransactionSystemCacheService {

    private static LinkedHashMap<String, TransactionRecord> TRANSACTION_MAP = new LinkedHashMap<>();

    public boolean put(TransactionRecord transactionRecord) {
        return TRANSACTION_MAP.put(transactionRecord.getTransactionId(), transactionRecord) != null;
    }

    public TransactionRecord get(String transactionId) {
        return TRANSACTION_MAP.get(transactionId);
    }

    public boolean delete(String transactionId) {
        return TRANSACTION_MAP.remove(transactionId) != null;
    }

    public List<TransactionRecord> queryPage(int startIndex, int endIndex) {
        List<TransactionRecord> transactionRecords = TRANSACTION_MAP.values().stream().toList();
        return transactionRecords.subList(startIndex, endIndex);
    }

    public int size() {
        return TRANSACTION_MAP.size();
    }

}
