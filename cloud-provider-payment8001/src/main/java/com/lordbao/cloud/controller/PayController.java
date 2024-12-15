package com.lordbao.cloud.controller;
import java.math.BigDecimal;
import java.util.Date;


import com.lordbao.cloud.dto.PayDTO;
import com.lordbao.cloud.entities.Pay;
import com.lordbao.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Lord_Bao
 * @Date 2024/12/15 16:18
 * @Version 1.0
 */
@RestController
@RequestMapping("pay")
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public String addPay(@RequestBody PayDTO payDTO){
        //数据脱敏
        Pay pay = new Pay();
        pay.setPayNo(payDTO.getPayNo());
        pay.setOrderNo(payDTO.getOrderNo());
        pay.setUserId(payDTO.getUserId());
        pay.setAmount(payDTO.getAmount());

        //下列数据无需设置,由底层数据库完成
//        pay.setId(null);
//        pay.setDeleted((byte)0);
//        pay.setCreateTime(new Date());
//        pay.setUpdateTime(new Date());
        int affectRows = payService.add(pay);
        return affectRows>0? "成功":"失败";
    }

    @DeleteMapping("/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public String deletePay(@PathVariable("id") Integer id){
        int affectRows = payService.delete(id);
        return affectRows>0? "成功":"失败";
    }

    @PutMapping("/update")
    @Operation(summary = "修改",description = "修改支付流水方法")
    public String updatePay(@RequestBody PayDTO payDTO){
        //数据脱敏
        Pay pay = new Pay();
        pay.setId(payDTO.getId());
        pay.setPayNo(payDTO.getPayNo());
        pay.setOrderNo(payDTO.getOrderNo());
        pay.setUserId(payDTO.getUserId());
        pay.setAmount(payDTO.getAmount());
        int affectRows = payService.update(pay);

        return affectRows>0? "成功":"失败";
    }

    @GetMapping("/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public Pay getPay(@PathVariable("id") Integer id){
        //数据脱敏
        Pay pay = new Pay();
        Pay result = payService.getById(id);
        if(result==null){
            return pay;
        }

        pay.setId(result.getId());
        pay.setPayNo(result.getPayNo());
        pay.setOrderNo(result.getOrderNo());
        pay.setUserId(result.getUserId());
        pay.setAmount(result.getAmount());
        return pay;
    }
}
