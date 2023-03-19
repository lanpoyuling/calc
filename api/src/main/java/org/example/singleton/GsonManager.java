package org.example.singleton;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

/**
 * Gson DCL单例
 */

@Slf4j
public class GsonManager {

    /**
     * 禁止重排序 线程可见
     */
    private static volatile GsonManager INSTANCE;

    private static  Gson gson;

    private GsonManager() {
        gson = new Gson();
    }

    public static GsonManager getInstance() {
        if (INSTANCE == null) {
            synchronized (GsonManager.class) {
                //（1给指令申请内存2成员变量初始化3.内存内容赋值给INSTANCE）
                INSTANCE = new GsonManager();
            }
        }
        return INSTANCE;
    }

    public Gson getGson() {
        return gson;
    }
}
