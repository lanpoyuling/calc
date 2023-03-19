package org.example.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.calc.AddCal;
import org.example.calc.DivideCal;
import org.example.calc.MultiplyCal;
import org.example.calc.SubtractCal;
import org.example.constant.CalcSymbolConstant;
import org.example.util.GsonUtil;
import org.exception.UnregisteredException;

import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 运算策略工厂
 */

@Slf4j
public class OperationStrategyFactory {


    /**
     * 运算符 及其对应的 运算Class
     */
    protected static ConcurrentHashMap<String, OperationStrategy> operatorSymbolObj = new ConcurrentHashMap<>(16);

    /**
     * 注册运算策略对象
     */
    static {
        operatorSymbolObj.put(CalcSymbolConstant.ADD, new AddCal());
        operatorSymbolObj.put(CalcSymbolConstant.SUBTRACT, new SubtractCal());
        operatorSymbolObj.put(CalcSymbolConstant.MULTIPLY, new MultiplyCal());
        operatorSymbolObj.put(CalcSymbolConstant.DIVIDE, new DivideCal());
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
        boolean symbolExist = Boolean.FALSE;
        //map 已注册的类型集合（运算符）
        Enumeration<String> registeredSymbolList = operatorSymbolObj.keys();
        log.info("已注册的类型集合:{}", GsonUtil.toJson(registeredSymbolList));
        for (Enumeration<String> symbol = registeredSymbolList; registeredSymbolList.hasMoreElements(); ) {
            if (operatorSymbol.equals(symbol.nextElement())) {
                symbolExist = Boolean.TRUE;
            }
        }

        if (!symbolExist) {
            throw new UnregisteredException("未知的运算符类型");
        }
        return operatorSymbolObj.get(operatorSymbol);
    }
}
