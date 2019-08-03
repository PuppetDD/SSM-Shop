package com.gold.dao;

import com.gold.entity.Goods;

import java.util.List;

/**
 * SSM-Learn
 * com.gold.dao
 *
 * @author GOLD
 * @date 2019/8/2
 */
public interface GoodsDao {

    Goods selectById(String g_id);

    List<Goods> showGoodsList();

    List<Goods> showGoodsListByType(String type);

    List<Goods> showGoodsListBySearch(String s);

}
