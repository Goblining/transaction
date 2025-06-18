package com.hsbc.transactionsystem.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRecord {

    /**
     * 交易id
     */
    private String transactionId;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 交易日期
     */
    private Date date;

    /**
     * 交易金额
     */
    private BigDecimal amount;

}
