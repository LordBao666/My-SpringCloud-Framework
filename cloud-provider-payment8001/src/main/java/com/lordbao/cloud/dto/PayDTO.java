package com.lordbao.cloud.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author Lord_Bao
 * @Date 2024/12/6 16:55
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PayDTO implements Serializable {
    private static final long serialVersionUID = 1871674223552571451L;
    private Integer id;
    //支付流水号
    private String payNo;
    //订单流水号
    private String orderNo;
    //用户账号ID
    private Integer userId;
    //交易金额
    private BigDecimal amount;
}
