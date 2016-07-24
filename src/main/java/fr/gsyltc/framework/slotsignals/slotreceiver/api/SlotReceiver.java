/*
 * @(#)SlotReceiver.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */


package fr.gsyltc.framework.slotsignals.slotreceiver.api;

import java.io.Serializable;
import java.util.Observer;

import fr.gsyltc.framework.slotsignals.action.api.SlotAction;
import fr.gsyltc.framework.slotsignals.common.api.TopicAttached;

/**
 * Implementing this interface allow component to receive slot
 * @author Goubaud Sylvain
 * @param <E>
 *
 *
 */
public interface SlotReceiver extends Serializable, Observer, TopicAttached {
    
    
    /**
     * Get the action attached to the slot.
     *
     * @return a slot action.
     *
     */
    SlotAction getSlotAction();
    
    /**
     * Set the axction attached to the slot
     *
     * @param slotAction
     *            the slot action.
     */
    void setSlotAction(final SlotAction slotAction);
}
