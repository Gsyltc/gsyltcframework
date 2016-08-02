/*
 * @(#)AbstractReceiverModelAdapterImpl.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 1 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
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
    
    
    /** Map of attached slots. */
    Map<String, Slot> slotsMap = new ConcurrentHashMap<String, Slot>();

    /** */
    private static final long serialVersionUID = -8721921882502026575L;

    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(AbstractReceiverModelAdapterImpl.class);

    /**
     * Constructor.
     *
     */
    public AbstractReceiverModelAdapterImpl() {
        this(null);
    }

    /**
     * Constructor.
     *
     * @param adapterName
     *            the adapter name.
     */
    public AbstractReceiverModelAdapterImpl(final String adapterName) {
        this(adapterName, null);
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
        final Slot slot = SlotsProvider.INSTANCE.findSlotBySlotName(topicName + "." + getAdapterName());
        slotsMap.put(topicName, slot);
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
     * Return a slot attached to the adapter by his topic name.
     *
     * @param topicName
     *            the topic name.
     * @return the desired slot.
     */
    public Slot findSlot(final String topicName) {
        return slotsMap.get(topicName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(30);
        stringBuilder//
                .append("Adapter  : ").append(this.getAdapterName()); //
        return stringBuilder.toString();
    }
}
