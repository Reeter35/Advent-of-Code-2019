package fr.reeter.advent2019.day2.opcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
public class OpCodeRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpCodeRunner.class);

    @Autowired
    private OpCodeConfiguration config;

    /**
     * Runs the code described in the OpCode input
     * @return
     */
    @Override
    public void run(String...args) {
        int[] opCodes = config.getOpCodes();

        // Gravity fix:
        opCodes[1] = 12;
        opCodes[2] = 2;

        LOGGER.info("Op Code result: " + read(opCodes));
    }

    protected int read(int[] opCodes) {
        int index=0;
        boolean stopCode=false;

        while(!stopCode && index < opCodes.length) {
            // Read command
            int command = opCodes[index];
            LOGGER.info("Command: " + command + " at index: " + index);

            if(command == 99) {
                LOGGER.info("Stop code found");
                stopCode = true;
            }
            else {
                LOGGER.info("Read: " + opCodes[index+1] + "," + opCodes[index+2] + "," + opCodes[index+3]);
                int resultIndex = opCodes[index+3];
                int operand1 =opCodes[opCodes[index+1]];
                int operand2 =opCodes[opCodes[index+2]];
                if(command == 1) {
                    LOGGER.info("Add: " + operand1 + " and " + operand2);
                    opCodes[resultIndex] = operand1+operand2;
                }
                else if (command == 2) {
                    LOGGER.info("Multiply: " + operand1 + " and " + operand2);
                    opCodes[resultIndex] = operand1*operand2;
                }
                else {
                    LOGGER.error("Unknown Command: " + command);
                    return -1;
                }
            }

            index+=4;

        }
        LOGGER.info("Index 0: " + opCodes[0]);
        return opCodes[0];
    }
}
