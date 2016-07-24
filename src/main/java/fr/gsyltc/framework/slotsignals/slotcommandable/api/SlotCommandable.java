/*
 * @(#)SlotCommandable.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.slotcommandable.api;

import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.signals.api.SignalSender;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotReceiver;

/**
 * @author Goubaud Sylvain
 *
 */
public interface SlotCommandable extends SlotReceiver, SignalSender, SlotRegister {
    
    /**
     * Get a signal by his topic name.
     *
     * @param topicName
     *            Topic attached to the signal.
     * @return a Signal.
     */
    Signal findSignal(String topicName);
}
