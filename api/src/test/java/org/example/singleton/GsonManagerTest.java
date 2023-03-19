package org.example.singleton;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
class GsonManagerTest {
    /**
     * 只创建一个Gson对象
     * 测试未通过
     */

    @Test
    void test_singleton_gson() {
        int count = 0;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 100; i++) {
            int hashCode = GsonManager.getInstance().getGson().hashCode();
            new Thread(() -> {
                copyOnWriteArrayList.add(hashCode);
                log.info("hashCode:{}", hashCode);
            }).start();
            count++;
        }
        assertThat(count).isEqualTo(100);
        assertThat(copyOnWriteArrayList.size()).isEqualTo(100);
    }

    /**
     * 直接new Gson 产生不同的对象
     */
    @Test
    void test_gson() {
        for (int i = 0; i < 10; i++) {
            int hashCode = new Gson().hashCode();
            new Thread(() -> log.info("hashCode:{}", hashCode)).start();
        }
    }
}