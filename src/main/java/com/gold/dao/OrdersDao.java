package com.gold.dao;

import com.gold.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SSM-Learn
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */
public interface OrdersDao {

    List<Orders> selectByUserId(String u_id);

    void insert(Orders orders);

    void delete(String o_id);

    void update(@Param("method") String method, @Param("status") String status, @Param("o_id") String o_id);

}
