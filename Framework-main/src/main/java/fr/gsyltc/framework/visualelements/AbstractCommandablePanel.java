/*
 * @(#)AbstractCommandablePanel.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 4 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.visualelements;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jgoodies.binding.PresentationModel;

import fr.gsyltc.framework.slotsignals.common.SignalsProvider;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.slotcommandable.api.SlotCommandable;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 *
 */
public abstract class AbstractCommandablePanel extends AbstractCommonPanel implements SlotCommandable {
    
    
    /** The logger of this class. */
    private static final Logger LOGGER = LogManager.getLogger(AbstractCommandablePanel.class);

    /** */
    private static final Object NEW_LINE = "\n";
    /** */
    private static final long serialVersionUID = 2794578279603616940L;
    /** Signals list. */
    private final Map<String, Signal> signals = new ConcurrentHashMap<String, Signal>();
    /** Signals list. */
    private final Map<String, Slot> slots = new ConcurrentHashMap<String, Slot>();

    /**
     * Constructor.
     *
     * @param presentationModels
     *            Presentation Models list for the panel.
     */
    protected AbstractCommandablePanel(final PresentationModel<?>... presentationModels) {
        super(presentationModels);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final void attachSignal(final String topicName) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Attach signal : " + topicName);
        }
        final Signal signal = SignalsProvider.INSTANCE.findSignalByTopicName(topicName);
        if (null == signal) {
            throw new NotImplementedException("No signal to regsiter");
        } else if (getSignals().containsKey(topicName)) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Signal already exist :" + topicName);
            }
        } else {
            signals.put(topicName, signal);
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public final Slot attachSlot(final String topicName) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Attach slot : " + topicName);
        }
        final Slot slot = SlotsProvider.INSTANCE.findSlotBySlotName(topicName + "." + getName());
        slots.put(topicName, slot);
        return slot;
    }

    /**
     * Build the visual element.
     */
    @Override
    public void build() {
        super.build();
        this.createSignals();
        this.createSlots();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void createSignals() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Signals for" + this.getName());
        }
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void createSlots() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Slots for" + this.getName());
        }
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public Signal findSignal(final String topicName) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Find signal : " + topicName);
        }
        return getSignals().get(topicName);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public final Slot findSlot(final String topicName) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Find slot : " + topicName);
        }
        return getSlots().get(topicName);
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final void registerSignal(final Signal newSignal) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Register signal : " + newSignal.getTopicName());
        }
        SignalsProvider.INSTANCE.registerSignal(newSignal);
        attachSignal(newSignal.getTopicName());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public final String toString() {
        final StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder//
                .append("Component  : ").append(this.getName()) //
                .append("Nb presenters : ").append(presenters.size()).append(NEW_LINE) //
                .append("Nb slots : ").append(slots.size()).append(NEW_LINE) //
                .append("Nb signals : ").append(signals.size()).append(NEW_LINE); //
        return stringBuilder.toString();
    }

    /**
     * Get the map of the attached signals.
     *
     * @return the signals
     */
    private Map<String, Signal> getSignals() {
        return Collections.unmodifiableMap(signals);
    }

    /**
     * Get the map of attached slots.
     *
     * @return the slots
     */
    private Map<String, Slot> getSlots() {
        return slots;
    }
}
