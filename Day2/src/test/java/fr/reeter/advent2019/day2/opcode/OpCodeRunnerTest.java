package fr.reeter.advent2019.day2.opcode;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
public class OpCodeRunnerTest {
    @Autowired
    private OpCodeRunner runner;

    //@Test
    public void testRunner() {
        // 1,9,10,3,2,3,11,0,99,30,40,50
        int[] test = new int[12];
        test[0]=1;
        test[1]=9;
        test[2]=10;
        test[3]=3;
        test[4]=2;
        test[5]=3;
        test[6]=11;
        test[7]=0;
        test[8]=99;
        test[9]=30;
        test[10]=40;
        test[11]=50;

        assertThat(runner.read(test)).isEqualTo(3500);
    }
}
