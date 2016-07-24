/*
 * @(#)SlotsProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * This class is for register all slots of the application.
 *
 * @author Goubaud Sylvain
 *
 */
public final class SlotsProvider {


    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SlotsProvider.class);
    /** List of slots registered. */
    private static final Map<String, Slot> SLOTS = new ConcurrentHashMap<String, Slot>();

    /**
     * Register a slot.
     *
     * @param newSlot
     *            the slot to register.
     * @return the registered slot.
     */
    public static Slot addSlot(final Slot newSlot) {
        Slot slot = findSlotByTopicName(newSlot.getTopicName());
        if (null == slot) {
            slot = newSlot;
            SLOTS.put(slot.getTopicName(), slot);
        } else {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("The slot is already registered");
            }
        }
        return slot;
    }

    /**
     * Register multiple slot.
     *
     * @param slotsMap
     *            map of slots to register.
     */
    public static void createSlots(final Map<String, Slot> slotsMap) {
        SLOTS.putAll(slotsMap);
    }

    /**
     * Find a registered slot by his topic name.
     *
     * @param topicName
     *            the topic of the slot
     * @return the registered slot.
     */
    public static Slot findSlotByTopicName(final String topicName) {
        return SLOTS.get(topicName);
    }

    /**
     * Protected Constructor
     */
    private SlotsProvider() {
        // Nothing to do
    }
}
