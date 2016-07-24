/*
 * @(#)SignalSender.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.signals.api;

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
}
