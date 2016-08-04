/*
 * @(#)SampleReceiverAdapter.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 4 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.samples.slotsignals.adapters;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jgoodies.binding.beans.Model;

import fr.gsyltc.framework.adapters.AbstractReceiverModelAdapterImpl;
import fr.gsyltc.framework.samples.slotsignals.types.TopicName;
import fr.gsyltc.framework.slotsignals.action.api.SlotAction;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 * @param <M>
 *            Model type.
 *
 */
public class SampleReceiverAdapter<M extends Model> extends AbstractReceiverModelAdapterImpl<M> {
    
    
    /** The logger of this class. */
    protected static final Logger LOGGER = LogManager.getLogger(SampleReceiverAdapter.class);
    
    /**
     *
     */
    private static final long serialVersionUID = 9062007717447227968L;
    
    /**
     * @param adapterName
     */
    public SampleReceiverAdapter(final String adapterName) {
        super(adapterName);
    }
    
    /**
     * {@inheritDoc}.
     */
    @Override
    public void createSlots() {
        final Slot hardCodedSlot = new Slot(TopicName.HARD_CODED_TOPIC.name(), getAdapterName());
        hardCodedSlot.registerSlot();
        hardCodedSlot.setSlotAction(new SlotAction<String>() {
            
            
            /**
             *
             */
            private static final long serialVersionUID = 4107279115915098256L;
            
            /**
             *
             * {@inheritDoc}
             */
            @Override
            public void doAction(final String arg) {
                if (LOGGER.isDebugEnabled()) {
                    LOGGER.debug("Hard coded signal received by :" + getAdapterName());
                }
            }
        });
        
        final Slot injectedSlot = attachSlot(TopicName.INJECTION_TOPIC.name());
        if (null != injectedSlot) {
            injectedSlot.setSlotAction(new SlotAction<String>() {
                
                
                /**
                 *
                 */
                private static final long serialVersionUID = 2239594398348315192L;
                
                /**
                 *
                 * {@inheritDoc}
                 */
                @Override
                public void doAction(final String arg) {
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("Injected signal received by :" + getAdapterName());
                    }
                }
            });
        }
    }
}
