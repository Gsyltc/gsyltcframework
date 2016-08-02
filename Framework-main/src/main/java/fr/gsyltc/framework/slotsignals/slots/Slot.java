/*
 * @(#)Slot.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 1 août 2016.
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
 * A slot. It receive a signal.
 *
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

    /** the slot action. */
    private SlotAction slotAction;
    /** The topic to . */
    private final String topicName;
    /** */
    private final String receiverName;
    /** true if slot is registered in the SlotProvider. */
    private boolean registered;

    /**
     * A slot can listen an event fire by a signal.
     *
     * @param newTopicName
     *            define the topic to listen.
     * @param newReceiverName
     *            Receiver Name.
     */
    public Slot(final String newTopicName, final String newReceiverName) {
        topicName = newTopicName;
        receiverName = newReceiverName;
        registerSlot();
    }

    /**
     * @return the receiverName
     */
    @Override
    public String getReceiverName() {
        return receiverName;
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public SlotAction getSlotAction() {
        return slotAction;
    }

    /**
     * @return the receiverName
     */
    public String getSlotName() {
        return topicName + "." + receiverName;
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public String getTopicName() {
        return topicName;
    }

    /**
     * Get the registration satus of the slot.
     *
     * @return the registered
     */
    public boolean isRegistered() {
        return registered;
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final void registerSlot() {
        if (!registered) {
            SlotsProvider.INSTANCE.registerSlot(this);
            setRegistered(true);
        }
    }

    /**
     * Set if the slot is registered.
     *
     * @param isRregistered
     *            is the slot registered
     */
    private void setRegistered(final boolean isRregistered) {
        registered = isRregistered;
    }

    /**
     * Define the action for the slot.
     *
     * @param newSlotAction
     *            the slot action.
     */
    @Override
    public void setSlotAction(final SlotAction newSlotAction) {
        slotAction = newSlotAction;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void update(final Observable signal, final Object toUpdate) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Signal received for topic : " + signal);
            LOGGER.debug("Object to update : " + toUpdate);
        }
        if (null == slotAction) {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("Slot " + getSlotName() + " has no slot action");
            }
        } else {
            slotAction.doAction(toUpdate);
        }
    }

}
