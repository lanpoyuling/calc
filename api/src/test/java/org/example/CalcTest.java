package org.example;

import org.example.factory.OperationStrategy;
import org.example.factory.OperationStrategyFactory;
import org.exception.DataException;
import org.exception.UnregisteredException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.*;


/**
 * 计算器测试类
 */
public class CalcTest {
    /**
     * 给出四则运算字符串        返回指定结果
     *
     * @param input 输入
     */
    @ParameterizedTest
    @MethodSource("dataWithoutDivide")
    void given_operator_expression_then_return_operator_result_without_divide(String input, String expect) {
        assertThat(getResults(input)).isEqualTo(expect);

    }
    @ParameterizedTest
    @MethodSource("dataWithDivide")
    void given_operator_expression_then_return_operator_result_with_divide(String input, String expect) {
        BigDecimal operand = new BigDecimal(expect);
        BigDecimal error = new BigDecimal("0.001");
        BigDecimal actual =new BigDecimal(getResults(input));
        assertThat(actual).isCloseTo(operand, within(error));
    }

    /**
     * 除数为0抛出算数异常
     */
    @Test
    void give_right_operator_is_zero_then_throw_ArithmeticException() {
        assertThatThrownBy(() -> {
            getResults("10 / 0   =");
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("除数不能为0");
    }
   @Test
    void give_isEmpty_then_throw_DataException() {
        assertThatThrownBy(() -> {
            getResults(" ");
        }).isInstanceOf(DataException.class)
                .hasMessageContaining(Parser.INPUT_INFORMATION_IS_EMPTY);
    }



    /**
     * 提供未注册到策略工厂的运算符 抛出UnregisteredException异常
     */
    @Test
    void give_unregistered_operator_symbol_then_throw_UnregisteredException() {
        assertThatThrownBy(() -> {
            getResults("10 ： 0   =");
        }).isInstanceOf(UnregisteredException.class)
                .hasMessageContaining(OperationStrategyFactory.UNKNOWN_OPERATOR_TYPE);
    }


    private static String getResults(String input) {
        //根据空格 解析字符串 解析出 左操作数  操作符   右操作数
        String[] arr = Parser.parseStr(input);
        //调用匹配方法 返回结果
        String leftOperator = arr[0];
        String operatorSymbol = arr[1];
        String rightOperator = arr[2];

        OperationStrategy operatorStrategy = OperationStrategyFactory.getOperatorStrategy(operatorSymbol);
        String results = operatorStrategy.calculateResults(leftOperator, rightOperator);
        return results;
    }

    public static Stream<Arguments> dataWithoutDivide() {
        return Stream.of(
                Arguments.of("7 + 7   = ", "14"),
                Arguments.of("7 + 7.5 =", "14.5"),
                //TODO 溢出
                Arguments.of("9 - 1 = ", "8"),
                Arguments.of("9 - 1.5 =", "7.5"),
                Arguments.of("9 * 1 =   ", "9"),
                Arguments.of("9 * 1.2 =", "10.8")
        );
    }

    public static Stream<Arguments> dataWithDivide() {
        return Stream.of(
                Arguments.of("10 / 1 = ", "10"),
                Arguments.of("10 / 3 = ", "3.3333333333333333333333333333333"),
                Arguments.of("10 / 2.5 =    ", "4")
        );
    }

    /**
     * 浮点类型测试
     */
    @Test
    public void givenADouble_whenCloseTo_thenCorrect() {
        double actual = 1.3;
        double operand = 1;
        double error = 0.5;
        assertThat(actual).isCloseTo(operand, within(error));
    }
    @Test
    public void given_result_is_floatingPoint_whenCloseTo_thenCorrect() {
        BigDecimal operand = new BigDecimal("10");
        BigDecimal error = new BigDecimal("0.001");

        BigDecimal actual =new BigDecimal(getResults("10 / 1 = "));
        assertThat(actual).isCloseTo(operand, within(error));
    }

    /**
     * 异常测试
     */
    @Test
    void exception_example() {
        assertThatThrownBy(() -> {
            throw new Exception("boom!");
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("boom");
    }
}
