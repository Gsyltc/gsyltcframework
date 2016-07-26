/*
 * @(#)SlotReceiver.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.slotreceiver.api;

import java.io.Serializable;
import java.util.Observer;

import fr.gsyltc.framework.slotsignals.action.api.SlotAction;

/**
 * Implementing this interface allow component to receive slot.
 *
 * @author Goubaud Sylvain
 *
 *
 */
public interface SlotActionnable extends Serializable, Observer {
    
    
    /**
     * Get the name of the object who attached to the slot.
     *
     * @return the receiver name.
     */
    String getReceiverName();

    /**
     * Get the action attached to the slot.
     *
     * @return a slot action.
     *
     */
    SlotAction<?> getSlotAction();

    /**
     * Regsiter a slot to the Slot provider.
     */
    void registerSlot();

    /**
     * Set the action attached to the slot.
     *
     * @param slotAction
     *            the slot action.
     */
    void setSlotAction(final SlotAction<?> slotAction);
}
