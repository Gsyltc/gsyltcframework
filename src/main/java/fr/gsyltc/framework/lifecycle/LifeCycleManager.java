/*
 * @(#)LifeCycleManager.java
 *
 * Goubaud Sylvain - 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

/*
 * @(#)LifeCycleManager.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.lifecycle;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gsyltc.framework.adapters.AdaptersProvider;
import fr.gsyltc.framework.adapters.api.AbstractCommonAdapter;
import fr.gsyltc.framework.slotsignals.common.SignalProvider;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 *
 */

/**
 * @author Goubaud Sylvain
 *
 */
public class LifeCycleManager {


    /** */
    public static final String SIGNALS_BEAN = "id-Signals";
    /** */
    public static final String SLOTS_BEAN = "id-Slots";
    /** */
    public static final String ADAPTERS_BEAN = "id-Adapters";

    /** */
    protected final static ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("./config/imports.xml");

    /**
     *
     */
    public static final void initApplication() {

        final List<Signal> signals = (List<Signal>) CONTEXT.getBean(SIGNALS_BEAN);
        SignalProvider.registerSignals(signals);

        final List<Slot> slots = (List<Slot>) CONTEXT.getBean(SLOTS_BEAN);
        SlotsProvider.regsiterSlots(slots);

        final List<AbstractCommonAdapter> adapters = (List<AbstractCommonAdapter>) CONTEXT.getBean(ADAPTERS_BEAN);
        AdaptersProvider.registerAdapters(adapters);
    }

    /**
     *
     */
    public static void registerBeans() {
        System.out.println("Register Beans");

        final Map<String, Slot> slots = SlotsProvider.getSlots();

        for (final Entry<String, Slot> entry : slots.entrySet()) {
            final Slot slot = entry.getValue();
            final Signal signal = SignalProvider.findSignalByTopicName(slot.getTopicName());
            signal.attachSlotReceiver(slot);
        }

    }
}
