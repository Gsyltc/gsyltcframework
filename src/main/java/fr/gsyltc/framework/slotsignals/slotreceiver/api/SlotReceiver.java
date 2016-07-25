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

import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 *
 */
public interface SlotReceiver {


    /**
     * Create a slot to the visual elements. With this method, the visual
     * elements can receive a signal event over a topic.
     */
    void createSlots();

    /**
     * Attach an existing (injected by spring) signal to a component. With this
     * method, the visual elements can receive a signal event over a topic.
     *
     * @param topicName
     *            the topicName.
     * @return the slot.
     */
    Slot attachSlot(String topicName);
}
