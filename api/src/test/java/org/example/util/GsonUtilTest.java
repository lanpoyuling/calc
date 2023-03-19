package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Gson工具测试类
 */

@Slf4j
class GsonUtilTest {

    @Test
    void object2Json() {

    }


    @Test
    void get() {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> log.info("hashcode:{}",GsonUtil.get().hashCode())).run();
        }
    }
}