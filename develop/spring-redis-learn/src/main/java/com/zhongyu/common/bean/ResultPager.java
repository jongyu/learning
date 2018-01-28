package com.zhongyu.common.bean;

import java.util.List;

/**
 * Created by ZhongYu on 4/18/2017.
 */
public class ResultPager<T> {

    private Integer total;

    private List<T> rows;

    public ResultPager() {

    }

    public ResultPager(Integer total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
