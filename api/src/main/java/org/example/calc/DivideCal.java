package org.example.calc;

import org.example.factory.OperationStrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 除法运算
 */
public class DivideCal implements OperationStrategy {

    /**
     * 两数相除
     *
     * @param leftOperator  左操作数  除数
     * @param rightOperator 右操作数  被除数
     * @return
     */
    @Override
    public String calculateResults(String leftOperator, String rightOperator) {
        if ("0".equals(rightOperator)) {
            throw new ArithmeticException("除数不能为0");
        }
        BigDecimal divide = new BigDecimal(leftOperator)
                .divide(new BigDecimal(rightOperator), BigDecimal.ROUND_HALF_UP, RoundingMode.HALF_UP);

        return String.valueOf(divide);
    }
}
