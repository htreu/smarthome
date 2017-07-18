package org.eclipse.smarthome.core.types;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import javax.measure.Quantity;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Temperature;

import org.junit.Test;

import tec.uom.se.quantity.Quantities;
import tec.uom.se.unit.Units;

public class UnitProviderTest {

    @Test
    public void testinHg2PascalConversion() {
        Quantity<Pressure> inHg = Quantities.getQuantity(BigDecimal.ONE, UnitProvider.INCH_OF_MERCURY);

        assertThat(inHg.to(Units.PASCAL), is(Quantities.getQuantity(new BigDecimal("3386.388"), Units.PASCAL)));
        assertThat(inHg.to(UnitProvider.HECTO_PASCAL),
                is(Quantities.getQuantity(new BigDecimal("33.86388"), UnitProvider.HECTO_PASCAL)));
    }
    
    @Test
    public void test_inHg_UnitSymbol() {
        assertThat(UnitProvider.INCH_OF_MERCURY.getSymbol(), is("inHg"));
        assertThat(UnitProvider.INCH_OF_MERCURY.toString(), is("inHg"));
    }

    @Test
    public void testPascal2inHgConversion() {
        Quantity<Pressure> pascal = Quantities.getQuantity(new BigDecimal("3386.388"), Units.PASCAL);

        assertThat(pascal.to(UnitProvider.INCH_OF_MERCURY),
                is(Quantities.getQuantity(new BigDecimal("1.000"), UnitProvider.INCH_OF_MERCURY)));
    }

    @Test
    public void testHectoPascal2Pascal() {
        Quantity<Pressure> pascal = Quantities.getQuantity(BigDecimal.valueOf(100), Units.PASCAL);

        assertThat(pascal.to(UnitProvider.HECTO_PASCAL),
                is(Quantities.getQuantity(BigDecimal.ONE, UnitProvider.HECTO_PASCAL)));
    }

    @Test
    public void test_hPa_UnitSymbol() {
        assertThat(UnitProvider.HECTO_PASCAL.toString(), is("hPa"));
    }
    
    @Test
    public void testKelvin2Fahrenheit() {
        Quantity<Temperature> kelvin = Quantities.getQuantity(BigDecimal.ZERO, UnitProvider.KELVIN);
        
        assertThat(kelvin.to(UnitProvider.FAHRENHEIT), is(Quantities.getQuantity(new BigDecimal("-459.67"), UnitProvider.FAHRENHEIT)));
    }

    @Test
    public void testKelvin2Fahrenheit2() {
        Quantity<Temperature> kelvin = Quantities.getQuantity(new BigDecimal(300), UnitProvider.KELVIN);
        
        assertThat(kelvin.to(UnitProvider.FAHRENHEIT), is(Quantities.getQuantity(new BigDecimal("80.33"), UnitProvider.FAHRENHEIT)));
    }
    
    @Test
    public void testFahrenheit2Kelvin() {
        Quantity<Temperature> fahrenheit = Quantities.getQuantity(new BigDecimal(100), UnitProvider.FAHRENHEIT);
        
        assertThat(fahrenheit.to(UnitProvider.KELVIN), is(Quantities.getQuantity(new BigDecimal("310.9277777777777777777777777777778"), UnitProvider.KELVIN)));
    }

    @Test
    public void test_fahrenheit_UnitSymbol() {
        assertThat(UnitProvider.FAHRENHEIT.getSymbol(), is("°F"));
        assertThat(UnitProvider.FAHRENHEIT.toString(), is("°F"));
    }

}
