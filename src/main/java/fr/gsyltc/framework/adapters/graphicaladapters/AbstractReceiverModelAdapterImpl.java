/*
 * @(#)AbstractCommandableAdapterImpl.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.graphicaladapters;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.slotreceiver.api.SlotReceiver;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 * @param <M>
 *            Model type.
 *
 */
public abstract class AbstractReceiverModelAdapterImpl<M> extends AbstractModelAdapterImpl<M> //
        implements SlotReceiver {
    
    
    /**
     *
     */
    private static final long serialVersionUID = -8721921882502026575L;
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(AbstractReceiverModelAdapterImpl.class);
    
    /** */
    private static final Object NEW_LINE = "\n";
    /** Signals list. */
    private Map<String, Signal> signals;

    // /** Slots list */
    // private List<Slot> slots;
    /**
     * Constructor.
     *
     * @param adapterName
     *            the adapter name.
     */
    public AbstractReceiverModelAdapterImpl(final String adapterName) {
        super(adapterName);
    }

    /**
     * Constructor.
     *
     * @param adapterName
     *            the adapter name.
     * @param model
     *            The model of the adapter.
     */
    public AbstractReceiverModelAdapterImpl(final String adapterName, final M model) {
        super(adapterName, model);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public final Slot attachSlot(final String topicName) {
        final Slot slot = SlotsProvider.findSlotBySlotName(topicName + "." + getAdapterName());
        return slot;
    }
    
    /**
     * {@inheritDoc}
     */
    // @Override
    @Override
    public void createSlots() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Slots for" + this.getAdapterName());
        }
    }
    
    /**
     * Build the visual element.
     */
    @Override
    public void init() {
        this.createSlots();
    }
    
    /**
     * @param slots
     *            the slots to set
     */
    public void setSlots(final Slot... slots) {
        for (final Slot slot : slots) {
            slot.registerSlot();
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder//
                .append("Adapter  : " + this.getAdapterName()) //
                .append("Nb signals : " + this.signals.size()).append(NEW_LINE); //
        // .append("Nb slots : " + this.slots.size()).append(NEW_LINE); //
        return stringBuilder.toString();
    }
}
