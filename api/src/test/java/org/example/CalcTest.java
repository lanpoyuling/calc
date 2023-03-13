package org.example;

import org.junit.jupiter.api.Test;

/**
 * 计算器测试类
 */
public class CalcTest {
    /**
     * 给出四则运算字符串        返回指定结果
     * input              output
     * 7 + 7   =          14
     * 7 + 7.5 =          14.5
     * 两数之和溢出          提示  溢出
     * <p>
     * 9 - 1 =             8
     * 9  - 1.5 =          7.5
     * <p>
     * 9 * 1 =             9
     * 9 * 1.2 =           10.8
     * <p>
     * 10 / 1 =            10
     * 10 / 2.5 =          4
     * 10 / 0   =          提示 除数不能为0
     */
    @Test
    void given_str_then_return_result() {
        //根据空格 解析字符串 解析出 左操作数  操作符   右操作数
        String[] arr = Parser.parseStr("");
        //调用匹配方法 返回结果


    }
}
