package org.example;

import org.example.factory.OperationStrategy;
import org.example.factory.OperationStrategyFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


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
     *
     * @param input
     */
    @ParameterizedTest
    @MethodSource("data")
    void given_operator_expression_then_return_operator_result(String input, String expect) {
        //根据空格 解析字符串 解析出 左操作数  操作符   右操作数
        String[] arr = Parser.parseStr(input);
        //调用匹配方法 返回结果
        String leftOperator = arr[0];
        String operatorSymbol = arr[1];
        String rightOperator = arr[2];

        OperationStrategy operatorStrategy = OperationStrategyFactory.getOperatorStrategy(operatorSymbol);
        String results = operatorStrategy.calculateResults(leftOperator, rightOperator);
        assertThat(results).isEqualTo(expect);

    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("7 + 7   = ", "14"),
                Arguments.of("7 + 7.5 =", "14.5"),
                //TODO 溢出
                Arguments.of("9 - 1 = ", "8"),
                Arguments.of("9 - 1.5 =", "7.5"),
                Arguments.of("9 * 1 =   ", "9"),
                Arguments.of("9 * 1.2 =", "10.8"),

                Arguments.of("10 / 1 = ", "10"),
                Arguments.of("10 / 3 = ", "3.3333333333333333333333333333333"),

                Arguments.of("10 / 2.5 =    ", "4"),
                //TODO  如何与异常捕获结合
                Arguments.of("10 / 0   =", "除数不能为0")
        );
    }
}
