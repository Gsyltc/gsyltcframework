/*
 * @(#)SlotCommandable.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.slotcommandable.api;

import fr.gsyltc.framework.slotsignals.signals.Signal;

/**
 * This interface make a component commandable by signal/slot.
 *
 * @author Goubaud Sylvain
 */
public interface SlotRegister {
    
    
    /**
     * Attach an existing (injected by spring) signal to a component. With this
     * method, the visual elements can send a signal event over a topic.
     *
     * @param topicName
     *            the topic name.
     */
    void attachSignal(String topicName);

    /**
     * Register an hard coded signal to a component.
     *
     * @param newSignal
     *            The signal to register.
     */
    void registerSignal(Signal newSignal);
}
