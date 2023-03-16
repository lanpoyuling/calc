package org.example.calc;

import org.example.factory.OperationStrategy;

import java.math.BigDecimal;

/**
 * 相加运算
 */
public class AddCal implements OperationStrategy {
    /**
     * 两数相加
     *
     * @param leftOperator  左操作数
     * @param rightOperator 右操作数
     * @return
     */
    @Override
    public String calculateResults(String leftOperator, String rightOperator) {
        BigDecimal add = new BigDecimal(leftOperator).add(new BigDecimal(rightOperator));
        return String.valueOf(add);
    }
}
