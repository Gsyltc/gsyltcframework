/*
 * @(#)AbstractCommonPanelConstant.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 9 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.utils.constants;

import fr.gsyltc.framework.slotsignals.common.SignalsProvider;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;

/**
 * @author Goubaud Sylvain
 *
 */

public interface AbstractCommandableConstant extends AbstractCommonConstant {
    
    
    /** Instance of the signal provider. */
    SignalsProvider SIGNAL_PROVIDER = SignalsProvider.INSTANCE;
    /** Instance of the slot provider. */
    SlotsProvider SLOT_PROVIDER = SlotsProvider.INSTANCE;

    /** Default signal bean name. */
    String SIGNALS_BEAN = "id-Signals";
    /** Default signal bean name. */
    String SLOTS_BEAN = "id-Slots";

}
