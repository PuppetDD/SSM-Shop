package com.gold.service;

import com.gold.entity.Goods;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * SSM-Learn
 * com.gold.service
 *
 * @author GOLD
 * @date 2019/8/2
 */
public interface GoodsService {

    Goods showDetails(String g_id);

    String showGoods(HttpServletRequest request, String key, String style) throws IOException;

}
