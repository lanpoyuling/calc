package org.example.singleton;

import org.example.constant.CalcSymbolConstant;

import java.util.Objects;

/**
 * 操作符号枚举
 * 意图借助本类 + 反射 生成对象
 */
public enum OperatorSymbolEnum {
    ADD("AddCal", CalcSymbolConstant.ADD),
    SUBTRACT("SubtractCal", CalcSymbolConstant.SUBTRACT),
    MULTIPLY("MultiplyCal", CalcSymbolConstant.MULTIPLY),
    DIVIDE("DivideCal", CalcSymbolConstant.DIVIDE);
    /**
     * 计算类名称
     */
    private String calClassName;

    /**
     * 计算符号
     */
    private String symbol;


    OperatorSymbolEnum(String calClassName, String symbol) {
        this.symbol = symbol;
        this.calClassName = calClassName;
    }

    /**
     * 根据 计算符号 获取 计算类名称
     *
     * @param symbol 计算符号
     * @return
     */
    public static String getBySymbol(String symbol) {
        OperatorSymbolEnum[] enums = OperatorSymbolEnum.values();
        for (OperatorSymbolEnum single : enums) {
            if (Objects.equals(single.symbol, symbol)) {
                return single.calClassName;
            }
        }
        return null;
    }

}
