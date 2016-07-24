/*
 * @(#)SlotAction.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.action.api;

import java.io.Serializable;

/**
 * The action to do when a signal is received by a slot.
 *
 * @author Goubaud Sylvain
 * @param <E>
 *            type of sended object.
 */
public interface SlotAction<E extends Object> extends Serializable {


    /**
     * Execute the action
     *
     * @param arg
     *            an object.
     */
    void doAction(E arg);

}
