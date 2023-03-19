package org.example.util;

import com.google.gson.Gson;

import java.util.Enumeration;

public class GsonUtil {


    /**
     * 构建Gson
     *
     * @return
     */
    private static Gson buildGson() {
        return new Gson();
    }

    public static Gson get(){
        return buildGson();
    }



    public static  String toJson(Enumeration<String> enumeration){
        return buildGson().toJson(enumeration);
    }
}
