package org.example.util;

import org.example.singleton.GsonManager;

/**
 * Gson工具类
 */
public class GsonUtil {
    /**
     * 将对象转化为String
     *
     * @param t 任意对象
     * @return
     */
    public static <T> String toJson(T t) {
        return GsonManager.getInstance().getGson().toJson(t);
    }
}
