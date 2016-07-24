/*
 * @(#)Slot.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.slots;

import java.util.Observable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.slotsignals.action.api.SlotAction;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
import fr.gsyltc.framework.slotsignals.common.api.TopicAttached;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotActionnable;

/**
 * @author Goubaud Sylvain
 *
 */
public class Slot implements SlotActionnable, TopicAttached {
    
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(Slot.class);
    
    /**
     *
     */
    private static final long serialVersionUID = 7440550503924717386L;
    
    /** the slot action */
    private SlotAction slotAction;
    /** The topic to listen */
    private final String topicName;
    /** */
    private final String receiverName;
    /** true if slot is registered in the SlotProvider */
    private boolean registered = false;
    
    /**
     * A slot can listen an event fire by a signal.
     *
     * @param newTopicName
     *            define the topic to listen.
     * @param receiverName
     *            Receiver Name.
     */
    public Slot(final String newTopicName, final String receiverName) {
        this.topicName = newTopicName;
        this.receiverName = receiverName;
        registerSlot();
    }
    
    /**
     * Return receiver *
     *
     * @return the slotAction
     */
    @Override
    public SlotAction getSlotAction() {
        return this.slotAction;
    }
    
    /**
     * Return the topic name of the slotslotAction
     *
     * @return the topic name.
     */
    @Override
    public String getTopicName() {
        return this.topicName;
    }
    
    /**
     * @return the receiverName
     */
    public String getSlotName() {
        return topicName + "." + receiverName;
    }
    
    /**
     * Define the action for the slot.
     *
     * @param newSlotAction
     */
    @Override
    public void setSlotAction(final SlotAction newSlotAction) {
        this.slotAction = newSlotAction;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Observable signal, final Object toUpdate) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Signal received for topic : " + signal);
            LOGGER.debug("Object to update : " + toUpdate);
        }
        this.slotAction.doAction(toUpdate);
    }
    
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final void registerSlot() {
        if (!registered) {
            SlotsProvider.registerSlot(this);
            setRegistered(true);
        }
    }
    
    /**
     * @return the registered
     */
    public boolean isRegistered() {
        return registered;
    }
    
    /**
     * @param registered
     *            the registered to set
     */
    private void setRegistered(final boolean registered) {
        this.registered = registered;
    }
    
}
