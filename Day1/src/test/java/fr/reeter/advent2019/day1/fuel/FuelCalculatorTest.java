package fr.reeter.advent2019.day1.fuel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FuelCalculatorTest {

    @Autowired
    FuelCalculator calculator;

    @Test
    void fuelCompute() {
        assertThat(calculator.fuelCompute(14)).isEqualTo(2);
        assertThat(calculator.fuelCompute(1969)).isEqualTo(966);
        assertThat(calculator.fuelCompute(100756)).isEqualTo(50346);
    }


}
