package com.good0520.reactadmin.utils;

import java.util.List;

/**
 * @author Good0520
 * @date 2019/9/17
 */
public class ListUtils {

    public static boolean isEmpty(List list) {
        return !isNotEmpty(list);
    }

    public static boolean isNotEmpty(List list) {
        return list != null && list.size() > 0;
    }
}
