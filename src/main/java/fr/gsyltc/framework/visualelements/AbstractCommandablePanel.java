/*
 * @(#)java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.visualelements;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jgoodies.binding.PresentationModel;

import fr.gsyltc.framework.slotsignals.common.SignalProvider;
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
    private static final Log LOGGER = LogFactory.getLog(AbstractCommandablePanel.class);
    /** */
    private static final Object NEW_LINE = "\n";
    /** */
    private static final long serialVersionUID = 2794578279603616940L;
    /** Signals list. */
    private Map<String, Signal> signals;
    /** Slots list */
    private Map<String, Slot> slots;

    /**
     * Constructor.
     *
     * @param presentationModels
     *            Presentation Models list for the panel.
     */
    protected AbstractCommandablePanel(final PresentationModel<?>... presentationModels) {
        if (null != presentationModels) {
            for (final PresentationModel<?> presentationModel : presentationModels) {
                this.presenters.add(presentationModel);
            }
        }
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final void attachSignal(final String topicName) {
        final Signal signal = SignalProvider.findSignalByTopicName(topicName);
        registerSignal(signal);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final void registerSignal(final Signal newSignal) {
        if (null == this.signals) {
            this.signals = new ConcurrentHashMap<String, Signal>();
        }
        if (null == newSignal) {
            throw new NotImplementedException("No signal to regsiter");
        }
        final String topicName = newSignal.getTopicName();

        if (signals.containsKey(topicName)) {
            throw new NotImplementedException("Signal Already Exist");
        }

        final Signal signal = SignalProvider.findSignalByTopicName(topicName);
        if (null == signal) {
            SignalProvider.addSignal(newSignal);
        }

        this.signals.put(topicName, newSignal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final Slot attachSlot(final String topicName) {
        final Slot slot = SlotsProvider.findSlotByTopicName(topicName);
        registerSlot(slot);
        return slot;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void registerSlot(final Slot newSlot) {
        if (null == this.slots) {
            this.slots = new ConcurrentHashMap<String, Slot>();
        }
        final String topicName = newSlot.getTopicName();
        this.slots.put(topicName, newSlot);
        Signal signal = SignalProvider.findSignalByTopicName(topicName);
        if (null == signal) {
            final Signal newSignal = new Signal(topicName);
            signal = SignalProvider.addSignal(newSignal);
        }
        signal.attachSlotReceiver(newSlot);
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
     * {@inheritDoc}
     */
    @Override
    public Signal findSignal(final String topicName) {
        return signals.get(topicName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Slot findSlot(final String topicName) {
        return slots.get(topicName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createSignals() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Signals for" + this.getName());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createSlots() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Slots for" + this.getName());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder//
        .append("Component  : " + this.getName()) //
        .append("Nb adapters : " + this.adapters.size()).append(NEW_LINE) //
        .append("Nb presenters : " + this.presenters.size()).append(NEW_LINE) //
        .append("Nb signals : " + this.signals.size()).append(NEW_LINE) //
        .append("Nb signals : " + this.signals.size()).append(NEW_LINE) //
        .append("Nb signals : " + this.signals.size()).append(NEW_LINE) //
        .append("Nb signals : " + this.signals.size()).append(NEW_LINE);
        return stringBuilder.toString();
    }
}
