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

import fr.gsyltc.framework.slotsignals.signals.api.SignalSender;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotReceiver;

/**
 * Define a signal. A signal is an observable objet, attached to a topic. An
 * event is fire over the topix ro the attached {@SlotReceiver}.
 *
 * @author Goubaud Sylvain
 *
 */
public class Signal extends Observable implements SignalSender {


    /**
     *
     */
    private static final long serialVersionUID = -3262485442303240084L;
    /** */
    private final String topicName;

    /**
     *
     * @param topicName
     */
    public Signal(final String topicName) {
        super();
        this.topicName = topicName;
        // SignalProvider.addSignal(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void attachSlotReceiver(final SlotReceiver receiver) {
        this.addObserver(receiver);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void fireSignal(final Object object) {
        this.setChanged();
        this.notifyObservers(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTopicName() {
        return this.topicName;
    }}
