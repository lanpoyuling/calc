package org.example;


import org.example.constant.CalcConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * 操作符号枚举测试
 */
class OperatorSymbolEnumTest {

    @ParameterizedTest
    @MethodSource("data")

    void give_operator_str_then_return_cal_class_name_str(String bySymbol1, String multiplyCal) {
        assertThat(OperatorSymbolEnum.getBySymbol(bySymbol1)).isEqualTo(multiplyCal);
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(CalcConstant.ADD_SYMBOL, "AddCal"),
                Arguments.of(CalcConstant.SUBTRACT_SYMBOL, "SubtractCal"),
                Arguments.of(CalcConstant.MULTIPLY_SYMBOL, "MultiplyCal"),
                Arguments.of(CalcConstant.DIVIDE_SYMBOL, "DivideCal")
        );
    }
}