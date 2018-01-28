package com.zhongyu.common.util;

import com.zhongyu.common.bean.Pager;

/**
 * Created by ZhongYu on 4/18/2017.
 */
public class PagerUtil {

    public static final String PAGE_SIZE = "10";

    public static Pager getPager(int pageNo, int total) {
        return getPager(pageNo, 0, total);
    }

    public static Pager getPager(int pageNo, int pageSize, int total) {
        if (pageNo <= 0) {
            pageNo = 1;
        }
        if (pageSize <= 0) {
            pageSize = Integer.parseInt(PAGE_SIZE);
        }
        return new Pager(pageNo, pageSize, total);
    }

    public static Pager getPager(String pageNo, String pageSize, int total) {
        if (pageNo != null && pageSize != null) {
            return getPager(Integer.valueOf(pageNo), Integer.valueOf(pageSize), total);
        }
        return getPager(1, 0, total);
    }

}