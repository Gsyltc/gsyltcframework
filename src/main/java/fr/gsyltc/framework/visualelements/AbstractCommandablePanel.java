/*
 * @(#)AbstractCommandablePanel.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 25 juil. 2016.
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
    private final Map<String, Signal> signals = new ConcurrentHashMap<String, Signal>();

    /**
     * Constructor.
     *
     * @param presentationModels
     *            Presentation Models list for the panel.
     */
    protected AbstractCommandablePanel(final PresentationModel<?>... presentationModels) {
        super();
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
        if (null == signal) {
            throw new NotImplementedException("No signal to regsiter");
        }
        if (getSignals().containsKey(topicName)) {
            throw new NotImplementedException("Signal Already attached for " + getName());
        }
        this.signals.put(topicName, signal);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public final Slot attachSlot(final String topicName) {
        return SlotsProvider.findSlotBySlotName(topicName + "." + getName());
    }

    /**
     * Build the visual element.
     */
    @Override
    public void build() {
        super.build();
        this.createSignals();
        this.createSlots();
        // registerSlots();
    }

    /**
     * {@inheritDoc} >>>>>>> refs/remotes/origin/master
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
        return getSignals().get(topicName);
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final void registerSignal(final Signal newSignal) {
        SignalProvider.registerSignal(newSignal);
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
                .append("Nb adapters : ").append(this.adapters.size()).append(NEW_LINE) //
                .append("Nb presenters : ").append(this.presenters.size()).append(NEW_LINE) //
                .append("Nb signals : ").append(this.signals.size()).append(NEW_LINE); //
        return stringBuilder.toString();
    }

    /**
     * @return the signals
     */
    private Map<String, Signal> getSignals() {
        return Collections.unmodifiableMap(this.signals);
    }
}
