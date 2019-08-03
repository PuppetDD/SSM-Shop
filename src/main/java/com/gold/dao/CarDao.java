package com.gold.dao;

import com.gold.entity.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SSM-Learn
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */
public interface CarDao {

    Integer findById(@Param("u_id") String u_id, @Param("g_id") String g_id);

    List<Car> selectById(String u_id);

    void insert(Car car);

    void update(@Param("c_id") String c_id, @Param("c_amount") long c_amount, @Param("u_id") String u_id, @Param("g_id") String g_id);

    void deleteById(String c_id);

}
