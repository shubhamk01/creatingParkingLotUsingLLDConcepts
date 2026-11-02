package com.starter.demo.lld.services;

import com.starter.demo.lld.common.custom.exceptions.WrongVehicleTypeException;
import com.starter.demo.lld.common.enums.VehicleType;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;

@Service
public class VehicleFareStrategy {
    
    private Map<String, Double> amountCalculationStrategy;

    public double getAmountFromStrategy(VehicleType vehicleType, Timestamp entryTime, Timestamp exitTime) {
        if(exitTime == null) {
            return 0.0;
        }else{
            getFareStrategy(vehicleType);
            int minutes = getTotalParkingMinutes(entryTime, exitTime);
            return amountCalculationStrategy.get("baseAmountForFirst30Mins")
                    + (((double) (minutes - 30) /30) * amountCalculationStrategy.get("baseAmountForEvery30Mins"));
        }
    }
    
    private void getFareStrategy(VehicleType vehicleType) {
        try{
            Method method = VehicleFareStrategy.this.getClass().getMethod("getFareStrategyFor"+vehicleType, VehicleType.class);
            method.invoke(this);
        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            this.getFareStrategyForDefaultError(vehicleType);
        }
    }

    private void getFareStrategyForDefaultError(VehicleType vehicleType) {
        throw new WrongVehicleTypeException("Wrong Vehicle Type - " + vehicleType + " Parking only available for - " + Arrays.toString(VehicleType.values()));
    }

    private void getFareStrategyForBIKE() {
        amountCalculationStrategy.put("baseAmountForFirst30Mins", 50.0);
        amountCalculationStrategy.put("baseAmountForEvery30Mins", 30.0);
    }

    private void getFareStrategyForTRUCK() {
        amountCalculationStrategy.put("baseAmountForFirst30Mins", 100.0);
        amountCalculationStrategy.put("baseAmountForEvery30Mins", 75.0);
    }

    private void getFareStrategyForCAR() {
        amountCalculationStrategy.put("baseAmountForFirst30Mins", 200.0);
        amountCalculationStrategy.put("baseAmountForEvery30Mins", 150.0);
    }

    private int getTotalParkingMinutes(Timestamp ticketEntryDateTime, Timestamp ticketExitDateTime) {
        if (ticketEntryDateTime == null || ticketExitDateTime == null) {
            throw new IllegalArgumentException("Entry and exit timestamps must not be null");
        }

        long elapsedMillis = ticketExitDateTime.getTime() - ticketEntryDateTime.getTime();
        return Math.toIntExact(elapsedMillis / 60_000L);
    }

}
