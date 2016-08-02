/*
 * @(#)LifeCycleManager.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 29 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.lifecycle;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jgoodies.binding.beans.Model;

import fr.gsyltc.framework.adapters.AdaptersProvider;
import fr.gsyltc.framework.adapters.api.CommonAdapter;
import fr.gsyltc.framework.models.ModelsProvider;
import fr.gsyltc.framework.slotsignals.common.SignalsProvider;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 *
 */
public enum LifeCycleManager {
    /** the singleton instance. */
    INSTANCE;

    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(LifeCycleManager.class);

    /** */
    public static final String MODELS_BEAN = "id-Models";
    /** */
    public static final String SIGNALS_BEAN = "id-Signals";
    /** */
    public static final String SLOTS_BEAN = "id-Slots";
    /** */
    public static final String ADAPTERS_BEAN = "id-Adapters";
    /** */
    private static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("./config/imports.xml");

    /**
     * Lifecycle init. Must be the first method of the main.
     */
    public static void initApplication() {
        // LogFactory logFactory = LogFactory.getFactory();
        // logFactory.setAttribute(, value);

        if (CONTEXT.containsBean(MODELS_BEAN)) {
            final Map<String, Model> models = (Map<String, Model>) CONTEXT.getBean(MODELS_BEAN);
            ModelsProvider.INSTANCE.registerModels(models);
        }

        if (CONTEXT.containsBean(SIGNALS_BEAN)) {
            final List<Signal> signals = (List<Signal>) CONTEXT.getBean(SIGNALS_BEAN);
            SignalsProvider.INSTANCE.registerSignals(signals);
        }

        if (CONTEXT.containsBean(SLOTS_BEAN)) {
            final List<Slot> slots = (List<Slot>) CONTEXT.getBean(SLOTS_BEAN);
            SlotsProvider.INSTANCE.regsiterSlots(slots);
        }

        if (CONTEXT.containsBean(ADAPTERS_BEAN)) {
            final List<CommonAdapter> adapters = (List<CommonAdapter>) CONTEXT.getBean(ADAPTERS_BEAN);
            AdaptersProvider.INSTANCE.registerAdapters(adapters);
        }
    }

    /**
     * Register beans in the providers.
     */
    public static void registerSlots() {
        final Map<String, Slot> slots = SlotsProvider.INSTANCE.getSlots();

        for (final Entry<String, Slot> entry : slots.entrySet()) {
            final Slot slot = entry.getValue();
            final Signal signal = SignalsProvider.INSTANCE.findSignalByTopicName(slot.getTopicName());
            if (null == signal) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("Slot " + slot.getSlotName() + " cannot be registered. Signal not exist");
                }
            } else {
                signal.attachSlotReceiver(slot);
            }
        }
    }

    // public statistic void

    /**
     * Protected constructor.
     */
    private LifeCycleManager() {
        // Noting to do
    }

}
