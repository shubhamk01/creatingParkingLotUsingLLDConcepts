package com.starter.demo.lld.services;

import com.starter.demo.lld.common.custom.exceptions.WrongVehicleTypeException;
import com.starter.demo.lld.common.enums.VehicleType;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class VehicleFareStrategy {
    public Map<String, Double> getFareStrategy(VehicleType vehicleType) {
        Map<String, Double> map = null;
        try{
            Method method = VehicleFareStrategy.this.getClass().getMethod("getFareStrategyFor"+vehicleType, VehicleType.class);
            map = (Map<String, Double>) method.invoke(this);
            return map;
        }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            return this.getFareStrategyForDefaultError(vehicleType);
        }
    }

    private Map<String, Double> getFareStrategyForDefaultError(VehicleType vehicleType) {
        throw new WrongVehicleTypeException("Wrong Vehicle Type - " + vehicleType + " Parking only available for - " + Arrays.toString(VehicleType.values()));
    }

    private Map<String, Double> getFareStrategyForBIKE() {
        Map<String, Double> fare = new HashMap<>();
        fare.put("baseAmountForFirst30Mins", 50.0);
        fare.put("baseAmountForEvery30Mins", 30.0);
        return fare;
    }

    private Map<String, Double> getFareStrategyForTRUCK() {
        Map<String, Double> fare = new HashMap<>();
        fare.put("baseAmountForFirst30Mins", 50.0);
        fare.put("baseAmountForEvery30Mins", 30.0);
        return fare;
    }

    private Map<String, Double> getFareStrategyForCAR() {
        Map<String, Double> fare = new HashMap<>();
        fare.put("baseAmountForFirst30Mins", 50.0);
        fare.put("baseAmountForEvery30Mins", 30.0);
        return fare;
    }

}
