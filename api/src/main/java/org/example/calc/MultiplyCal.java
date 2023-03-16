package org.example.calc;

import org.example.factory.OperationStrategy;

import java.math.BigDecimal;

/**
 * 乘法运算
 */
public class MultiplyCal implements OperationStrategy {
    /**
     * 两数相乘
     *
     * @param leftOperator  左操作数
     * @param rightOperator 右操作数
     * @return
     */
    @Override
    public String calculateResults(String leftOperator, String rightOperator) {
        BigDecimal multiply = new BigDecimal(leftOperator).multiply(new BigDecimal(rightOperator));
        return String.valueOf(multiply);
    }
}
