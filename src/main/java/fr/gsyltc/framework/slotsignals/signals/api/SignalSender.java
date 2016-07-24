/*
 * @(#)SignalSender.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.signals.api;

import java.io.Serializable;

import fr.gsyltc.framework.slotsignals.common.api.TopicAttached;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotReceiver;

/**
 * @author Goubaud Sylvain
 * @param <E>
 *
 *
 */
public interface SignalSender extends Serializable, TopicAttached {
    
    
    /**
     * Create a new signal and attach a receiver.
     *
     * @param receiver
     *            The first receiver.
     */
    void attachSlotReceiver(SlotReceiver receiver);
    
    /**
     * Send signal.
     *
     * @param object
     *            Object.
     */
    void fireSignal(Object object);
}
