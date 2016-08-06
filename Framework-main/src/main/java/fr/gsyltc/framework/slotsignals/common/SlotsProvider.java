/*
 * @(#)SlotsProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 6 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.common;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * This class is for register all slots of the application.
 *
 * @author Goubaud Sylvain
 *
 */
public enum SlotsProvider {
    /** The singleton instance. */
    INSTANCE;

    /** The logger of this class. */
    private static final Logger LOGGER = LogManager.getLogger(SlotsProvider.class);

    /** List of slots registered. */
    private static final Map<String, Slot> SLOTS = new ConcurrentHashMap<String, Slot>();

    /**
     * Find a registered slot by his topic name.
     *
     * @param topicName
     *            the topic of the slot
     * @return the registered slot.
     */
    public Slot findSlotBySlotName(final String topicName) {
        return SLOTS.get(topicName);
    }

    /**
     * Get the slots map.
     *
     * @return the slots
     */
    public Map<String, Slot> getSlots() {
        return Collections.unmodifiableMap(SLOTS);
    }

    /**
     * Register a slot.
     *
     * @param newSlot
     *            the slot to register.
     */
    public void registerSlot(final Slot newSlot) {
        Slot slot = findSlotBySlotName(newSlot.getSlotName());
        if (null == slot) {
            slot = newSlot;
            SLOTS.put(slot.getSlotName(), slot);
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("The slot is already registered : " + slot.getSlotName());
            }
        }
    }

    /**
     * Register multiple slot.
     *
     * @param slots
     *            list of slots to register.
     */
    public void regsiterSlots(final List<Slot> slots) {
        for (final Slot slot : slots) {
            registerSlot(slot);
        }
    }
}
