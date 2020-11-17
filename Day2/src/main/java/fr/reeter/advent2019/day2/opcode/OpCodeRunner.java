package fr.reeter.advent2019.day2.opcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OpCodeRun {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpCodeRun.class);

    /**
     * Runs the code described in the OpCode input
     * @return
     */
    public int run(int[] opCodes) {
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
