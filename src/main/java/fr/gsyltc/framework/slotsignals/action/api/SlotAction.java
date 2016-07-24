/*
 * @(#)SlotAction.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.action.api;

/**
 * @author Goubaud Sylvain
 * @param <E>
 *            type of sended object
 */
public interface SlotAction<E extends Object> {


    /**
     *
     * @param arg
     *            an object.
     */
    void doAction(E arg);

}
