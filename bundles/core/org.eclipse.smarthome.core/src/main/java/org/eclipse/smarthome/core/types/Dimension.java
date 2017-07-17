/**
 * Copyright (c) 2014-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.smarthome.core.types;

import java.util.List;

import javax.measure.Unit;

import org.apache.commons.lang.StringUtils;

import com.google.common.collect.Lists;

import tec.uom.se.unit.Units;

/**
 * Dimension of the channel.
 *
 * @author Gaël L'hopital - Initial contribution .
 */
public enum Dimension {
    // ACCELERATION,
    // AMOUNT_OF_SUBSTANCE,
    // ANGLE,
    // AREA,
    // CATALIYTIC_ACTIVITY,
    DIMENSIONLESS(null),
    // ELECTRIC_CAPACITANCE,
    // ELECTRIC_CHARGE,
    // ELECTRIC_CONDUCTANCE,
    // ELECTRIC_CURRENT,
    // ELECTRIC_INDUCTANCE,
    // ELECTRIC_POTENTIAL,
    // ELECTRIC_RESISTANCE,
    // ENERGY,
    // FORCE,
    // FREQUENCY,
    // ILLUMINANCE,
    // LENGTH,
    // LUMINOUS_FLUX,
    // LUMINOUS_INTENSITY,
    // MAGNETIC_FLUX,
    // MAGNETIC_FLUX_DENSITY,
    // MASS,
    // POWER,
    PRESSURE(Units.PASCAL, UnitProvider.HECTO_PASCAL, UnitProvider.INCH_OF_MERCURY),
    // RADIATION_DOSE_ABSORBED,
    // RADIATION_DOSE_EFFECTIVE,
    // RADIO_ACTVITY,
    // SOLID_ANGLE,
    // SPEED,
    TEMPERATURE(Units.KELVIN, Units.CELSIUS, UnitProvider.FAHRENHEIT);
    // TIME,
    // VOLUME;

    private final Unit<?> defaultUnit;
    private final List<Unit<?>> units;

    private Dimension(Unit<?> defaultUnit, Unit<?>... units) {
        this.defaultUnit = defaultUnit;
        this.units = Lists.asList(defaultUnit, units);
    }

    public Unit<?> getDefaultUnit() {
        return defaultUnit;
    }

    public Unit<?> getLocaleUnit() {
        return units.get(1);
    }

    /**
     * Parses the input string into a {@link Dimension}.
     *
     * @param input the input string
     * @return the parsed ChannelDimension.
     * @throws IllegalArgumentException if the input couldn't be parsed.
     */
    public static Dimension parse(String input) {
        if (StringUtils.isBlank(input)) {
            return null;
        }
        for (Dimension value : values()) {
            if (value.name().equalsIgnoreCase(input)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown channel dimension: '" + input + "'");
    }

}
