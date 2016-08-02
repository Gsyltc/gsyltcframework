/*
 * @(#)SlotCommandable.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 1 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.slotcommandable.api;

import fr.gsyltc.framework.slotsignals.signals.api.SignalSender;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotReceiver;

/**
 * @author Goubaud Sylvain
 *
 */
public interface SlotCommandable extends SlotReceiver, SignalSender, SlotRegister {
    
}
