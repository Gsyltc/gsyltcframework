/*
 * @(#)Signal.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.signals;

import java.util.Observable;

import fr.gsyltc.framework.slotsignals.common.api.TopicAttached;
import fr.gsyltc.framework.slotsignals.signals.api.SignalActionner;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotActionnable;

/**
 * Define a signal. A signal is an observable objet, attached to a topic. An
 * event is fire over the topic to the attached slot receiver.
 *
 * @author Goubaud Sylvain
 *
 */
public class Signal extends Observable implements SignalActionner, TopicAttached {
    
    
    /**
     *
     */
    private static final long serialVersionUID = -3262485442303240084L;
    /** */
    private final String topicName;

    /**
     * Construct a signal.
     *
     * @param newTopicName
     *            the topic name.
     */
    public Signal(final String newTopicName) {
        super();
        this.topicName = newTopicName;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void attachSlotReceiver(final SlotActionnable receiver) {
        this.addObserver(receiver);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void fireSignal(final Object object) {
        this.setChanged();
        this.notifyObservers(object);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getTopicName() {
        return this.topicName;
    }
}
