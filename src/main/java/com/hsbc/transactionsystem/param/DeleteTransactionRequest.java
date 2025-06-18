package com.hsbc.transactionsystem.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteTransactionRequest {

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
