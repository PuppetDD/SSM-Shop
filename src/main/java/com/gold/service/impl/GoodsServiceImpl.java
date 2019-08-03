package com.gold.service.impl;

import com.gold.dao.GoodsDao;
import com.gold.entity.Goods;
import com.gold.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * SSM-Shop
 * com.gold.service.impl
 *
 * @author GOLD
 * @date 2019/8/2
 */

@Service
public class GoodsServiceImpl implements GoodsService {

    @Resource
    private GoodsDao goodsDao;

    @Override
    public Goods showDetails(String g_id) {
        return goodsDao.selectById(g_id);
    }

    @Override
    public String showGoods(HttpServletRequest request, String key, String style) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String path = null;
        if (key != null) {
            System.out.println("Index1");
            request.setAttribute("g_list", goodsDao.showGoodsListBySearch(key));
            path = "index.jsp?styleShow=7";
        } else if (style == null || style.compareTo("1") == 0 && key == null) {
            System.out.println("Index2");
            request.setAttribute("g_list", goodsDao.showGoodsList());
            path = "index.jsp?styleShow=1";
        } else if (style != null && key == null) {
            if (style.compareTo("2") == 0) {
                System.out.println("Index3");
                request.setAttribute("g_list", goodsDao.showGoodsListByType("日用品"));
                path = "index.jsp?styleShow=2";
            }
            if (style.compareTo("3") == 0) {
                System.out.println("Index4");
                request.setAttribute("g_list", goodsDao.showGoodsListByType("电子科技"));
                path = "index.jsp?styleShow=3";
            }
            if (style.compareTo("4") == 0) {
                System.out.println("Index5");
                request.setAttribute("g_list", goodsDao.showGoodsListByType("零食小吃"));
                path = "index.jsp?styleShow=4";
            }
        }
        return path;
    }

}
