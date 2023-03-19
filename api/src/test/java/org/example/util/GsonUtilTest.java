package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.example.calc.AddCal;
import org.example.calc.DivideCal;
import org.example.calc.MultiplyCal;
import org.example.calc.SubtractCal;
import org.example.constant.CalcSymbolConstant;
import org.example.factory.OperationStrategy;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Gson工具测试类
 */

@Slf4j
class GsonUtilTest {
    @Test
    void toJson() {
        ConcurrentHashMap<String, OperationStrategy> operatorSymbolObj = new ConcurrentHashMap<>();
        operatorSymbolObj.put(CalcSymbolConstant.ADD, new AddCal());
        operatorSymbolObj.put(CalcSymbolConstant.SUBTRACT, new SubtractCal());
        operatorSymbolObj.put(CalcSymbolConstant.MULTIPLY, new MultiplyCal());
        operatorSymbolObj.put(CalcSymbolConstant.DIVIDE, new DivideCal());
        Enumeration<String> keys = operatorSymbolObj.keys();
        String s = GsonUtil.toJson(keys);
        assertThat(s).contains(CalcSymbolConstant.ADD);
        assertThat(s).contains(CalcSymbolConstant.SUBTRACT);
        assertThat(s).contains(CalcSymbolConstant.MULTIPLY);
        assertThat(s).contains(CalcSymbolConstant.DIVIDE);
    }
}