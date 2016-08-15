/*
 * @(#)DomainType.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 14 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.domaintypes;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.regex.Pattern;

import javax.measure.DecimalMeasure;
import javax.measure.quantity.Quantity;
import javax.measure.unit.Unit;

/**
 * @author Goubaud Sylvain
 * @param <Q>
 *
 */

public abstract class DomainType<Q extends Quantity> extends DecimalMeasure<Q> {
    
    
    /** */
    private DecimalMeasure<Q> value;
    /** */
    protected Pattern pattern;
    /**
    *
    */
    private static final long serialVersionUID = -1744971492271796186L;
    
    /**
     * @param bgValue
     * @param unit
     */
    private DomainType(final BigDecimal bgValue, final Unit<Q> unit) {
        super(bgValue, unit);
        
    }
    
    /**
     * @param dValue
     * @param unit
     */
    public DomainType(final Double dValue, final Unit<Q> unit) {
        this(BigDecimal.valueOf(dValue), unit);
        value = DecimalMeasure.valueOf(getValue(), unit);
    }
    
    /**
     * @return
     */
    public Double getSIValue() {
        return getValue(getSIUnit());
    }
    
    public abstract Unit<Q> getSIUnit();
    
    /**
     * @param unit
     * @return
     */
    public Double getValue(final Unit<Q> unit) {
        final DecimalMeasure<Q> convertedValue = value.to(unit, MathContext.DECIMAL32);
        return convertedValue.doubleValue(unit);
    }
    
    /**
     *
     * @return
     */
    public Pattern getPattern() {
        return pattern;
    }
    
    /**
     *
     * @param newPattern
     */
    public void setPattern(final Pattern newPattern) {
        this.pattern = newPattern;
    }
}
