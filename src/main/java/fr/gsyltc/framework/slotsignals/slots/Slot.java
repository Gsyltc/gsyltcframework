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
import fr.gsyltc.framework.slotsignals.common.api.TopicAttached;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotReceiver;

/**
 * @author Goubaud Sylvain
 *
 */
public class Slot implements SlotReceiver, TopicAttached {


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

    /**
     * A slot can listen an event fire by a signal.
     *
     * @param newTopicName
     *            define the topic to listen.
     */
    public Slot(final String newTopicName) {
        this.topicName = newTopicName;
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
}
