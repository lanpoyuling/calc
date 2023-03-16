package org.example.calc;

import org.example.factory.OperationStrategy;

import java.math.BigDecimal;

/**
 * 减法运算
 */
public class SubtractCal implements OperationStrategy {
    /**
     * 减数 - 被减数
     *
     * @param leftOperator  左操作数 减数
     * @param rightOperator 右操作数 被减数
     * @return
     */
    @Override
    public String calculateResults(String leftOperator, String rightOperator) {
        BigDecimal divide = new BigDecimal(leftOperator).subtract(new BigDecimal(rightOperator));
        return String.valueOf(divide);
    }
}
