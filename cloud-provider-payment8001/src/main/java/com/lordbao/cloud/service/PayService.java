package com.lordbao.cloud.service;


import com.lordbao.cloud.entities.Pay;

import java.util.List;

/**
 * @Author Lord_Bao
 * @Date 2024/12/6 17:04
 * @Version 1.0
 */
public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);
    public Pay getById(Integer id);

    public List<Pay> getAll();
}
