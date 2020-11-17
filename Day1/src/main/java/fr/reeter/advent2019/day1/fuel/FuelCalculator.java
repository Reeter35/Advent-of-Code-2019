package fr.reeter.advent2019.day1.fuel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FuelCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(FuelCalculator.class);

    /**
     * Compute necessary fuel from mass
     * @param mass
     * @return the necessary fuel given to module mass
     */
    public int fuelCompute(final int mass) {
        int fuel = (int) Math.floor(((double) mass / 3.0)) - 2;
        LOGGER.info("Fuel compute: " + fuel);
        // Compute additional fuel for this fuel
        if(fuel > 0) {
            LOGGER.info("Compute additional fuel for this fuel: " + fuel);
            return fuel + fuelCompute(fuel);
        }
        else return 0;
    }
}