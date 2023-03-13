package org.example;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.example.Parser.*;

class ParserTest {
    /**
     * 输入数据 及其期望值 集合
     *
     * @return
     */
    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of("7 + 7 = ", new String[]{"7", ADD_SYMBOL, "7"}),
                Arguments.of("7 + 7.5 = ", new String[]{"7", ADD_SYMBOL, "7.5"}),
                Arguments.of(" 9 - 1.5 = ", new String[]{"9", SUBTRACT_SYMBOL, "1.5"}),
                Arguments.of(" 9 - 1 = ", new String[]{"9", SUBTRACT_SYMBOL, "1"}),
                Arguments.of(" 9 * 1 = ", new String[]{"9", MULTIPLY_SYMBOL, "1"}),
                Arguments.of(" 9 * 1.2 =  ", new String[]{"9", MULTIPLY_SYMBOL, "1.2"}),
                Arguments.of(" 10 / 2.5 =   ", new String[]{"10", DIVIDE_SYMBOL, "2.5"}),
                Arguments.of("  10 / 1 =    ", new String[]{"10", DIVIDE_SYMBOL, "1"}),
                Arguments.of("  10 / 0 =    ", new String[]{"10", DIVIDE_SYMBOL, "0"})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void given_special_arithmetic_expression_string_then_return_leftOperator_operatorSymbol_rightOperator_array(String input, String[] expected) {

        assertThat(Parser.parseStr(input)).isEqualTo(expected);
    }
}