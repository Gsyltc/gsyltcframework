/*
 * @(#)SampleReceiverAdapter.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.samples.slotsignals.adapters;

import fr.gsyltc.framework.adapters.graphicaladapters.AbstractReceiverModelAdapterImpl;
import fr.gsyltc.framework.samples.slotsignals.types.TopicName;
import fr.gsyltc.framework.slotsignals.action.api.SlotAction;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 * @param <M>
 *            Model type.
 *
 */
public class SampleReceiverAdapter<M> extends AbstractReceiverModelAdapterImpl<M> {
    
    
    /**
     * @param adapterName
     */
    public SampleReceiverAdapter(final String adapterName) {
        super(adapterName);
    }
    
    /**
     *
     */
    private static final long serialVersionUID = 9062007717447227968L;
    
    /**
     *
     */
    @Override
    public void init() {
        super.init();
    }
    
    /**
     * {@inheritDoc}
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
                System.out.println("Hard coded signal received by :" + getAdapterName());
                
            }
        });
        
        final Slot injectedSlot = attachSlot(TopicName.INJECTION_TOPIC.name());
        if (null != injectedSlot) {
            injectedSlot.setSlotAction(new SlotAction<String>() {
                
                
                /**
                 *
                 * {@inheritDoc}
                 */
                @Override
                public void doAction(final String arg) {
                    System.out.println("Injected signal received by :" + getAdapterName());
                }
            });
        }
    }
}
