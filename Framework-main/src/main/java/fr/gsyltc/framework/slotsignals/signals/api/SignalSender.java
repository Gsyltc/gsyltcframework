/*
 * @(#)SignalSender.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 25 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.signals.api;

import fr.gsyltc.framework.slotsignals.signals.Signal;

/**
 * @author Goubaud Sylvain
 *
 */
public interface SignalSender {
    
    
    /**
     * Create a signal to the visual elements. With this method, the visual
     * elements can send a signal event over a topic.
     */
    void createSignals();

    /**
     * Get a signal by his topic name.
     *
     * @param topicName
     *            Topic attached to the signal.
     * @return a Signal.
     */
    Signal findSignal(String topicName);
}
