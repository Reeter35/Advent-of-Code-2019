package fr.reeter.advent2019.day2.opcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Parser of for OpCode inputs
 *
 */
@Service
public class OpCodeConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(OpCodeConfiguration.class);

    // OpCodes list to process
    private int[] opCodes;

    @PostConstruct
    public void init() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("opcodes.txt")));
            String line = reader.readLine();
            if(line != null) {
                String[] codes = line.split(",");
                opCodes = new int[codes.length];
                LOGGER.info("Parsing " + codes.length + " codes");
                for(int i=0; i<codes.length;i++) {
                    LOGGER.info("Code: " + codes[i]);
                    opCodes[i] = Integer.parseInt(codes[i]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getOpCodes() {
        return opCodes;
    }
}
