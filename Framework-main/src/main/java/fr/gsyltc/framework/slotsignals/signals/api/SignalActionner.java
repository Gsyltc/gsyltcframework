/*
 * @(#)SignalSender.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.signals.api;

import java.io.Serializable;

import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotActionnable;

/**
 * @author Goubaud Sylvain
 *
 *
 */
public interface SignalActionner extends Serializable {
    
    
    /**
     * Create a new signal and attach a receiver.
     *
     * @param receiver
     *            The first receiver.
     */
    void attachSlotReceiver(SlotActionnable receiver);
    
    /**
     * Send signal.
     *
     * @param object
     *            Object.
     */
    void fireSignal(Object object);
}
