package org.example.interpreter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ClientDemo {


    @Test
    void test_interpreter() {
        Variables v = new Variables();
        Variable x = new Variable();
        Variable y = new Variable();
        Variable z = new Variable();
        v.put(x,10);
        v.put(y, 20);
        v.put(z,30);

        //计算  x *(y+z/x) -x

        ArithmeticExpression e = new Substract(new Multiply(x, new Plus(y, new Division(z, x))), x);
        int interpret = e.interpret(v);
        assertThat(interpret).isEqualTo(220);
    }
}
