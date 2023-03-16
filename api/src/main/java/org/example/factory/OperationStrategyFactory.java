package org.example.factory;

import org.apache.commons.lang3.StringUtils;
import org.example.constant.CalcConstant;
import org.example.calc.AddCal;
import org.example.calc.DivideCal;
import org.example.calc.MultiplyCal;
import org.example.calc.SubtractCal;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 运算策略工厂
 */
public class OperationStrategyFactory {
    /**
     * 运算符 及其对应的 运算Class
     */
    protected static ConcurrentHashMap<String, OperationStrategy> operatorSymbolObj = new ConcurrentHashMap<>(16);


    static {
        operatorSymbolObj.put(CalcConstant.ADD_SYMBOL, new AddCal());
        operatorSymbolObj.put(CalcConstant.SUBTRACT_SYMBOL, new SubtractCal());
        operatorSymbolObj.put(CalcConstant.MULTIPLY_SYMBOL, new MultiplyCal());
        operatorSymbolObj.put(CalcConstant.DIVIDE_SYMBOL, new DivideCal());
    }

    /**
     * 根据操作符获取 对应的运算策略类
     *
     * @param operatorSymbol 操作运算符
     * @return
     */
    public static OperationStrategy getOperatorStrategy(String operatorSymbol) {
        if (StringUtils.isBlank(operatorSymbol)) {
            throw new IllegalArgumentException("操作符信息缺失");
        }
        return operatorSymbolObj.get(operatorSymbol);
    }
}
