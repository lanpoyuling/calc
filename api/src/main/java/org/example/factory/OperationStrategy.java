package org.example.factory;

/**
 * 运算策略
 */
public interface OperationStrategy {
    /**
     * 计算结果
     *
     * @param leftOperator  左操作数
     * @param rightOperator 右操作数
     * @return
     */
    String calculateResults(String leftOperator, String rightOperator);
}
