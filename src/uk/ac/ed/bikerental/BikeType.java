package uk.ac.ed.bikerental;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BikeType {
    // To avoid duplicate BikeTypes, keep a static map of them
    private static HashMap<String, BikeType> bikeTypes = new HashMap<>();
    private BigDecimal replacementValue;

    // This constructor is private because external classes should never directly initialize it
    private BikeType(BigDecimal replacementValue) {
        this.replacementValue = replacementValue;
    }

    // Look up an existing BikeType
    public static BikeType findType(String name) {
        return bikeTypes.get(name);
    }

    // Create a new BikeType or set the replacement value of an existing one
    public static BikeType setBikeType(String name, BigDecimal replacementValue) {
        // Ensure that the replacement value is greater than 0
        assert replacementValue.compareTo(BigDecimal.ZERO) > 0;

        // If a BikeType already exists, update the entry with the new replacement value.
        // Otherwise, add a new one
        if (bikeTypes.containsKey(name))
            bikeTypes.get(name).replacementValue = replacementValue;
        else
            bikeTypes.put(name, new BikeType(replacementValue));
        return findType(name);
    }

    public BigDecimal getReplacementValue() {
        return replacementValue;
    }
}