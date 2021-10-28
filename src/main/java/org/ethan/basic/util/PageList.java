package org.ethan.basic.util;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PageList<T> {

    private Integer totals = 0;

    private List<T> list = new ArrayList<>();

    public PageList() {
    }

    public PageList(Integer totals, List<T> list) {
        this.totals = totals;
        this.list = list;
    }
}
