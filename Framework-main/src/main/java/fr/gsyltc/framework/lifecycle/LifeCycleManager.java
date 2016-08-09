/*
 * @(#)LifeCycleManager.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 9 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.lifecycle;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jgoodies.binding.beans.Model;

import fr.gsyltc.framework.adapters.api.CommonAdapter;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.slots.Slot;
import fr.gsyltc.framework.utils.constants.AbstractCommandableConstant;

/**
 * @author Goubaud Sylvain
 *
 */
public enum LifeCycleManager implements AbstractCommandableConstant {
    /** the singleton instance. */
    INSTANCE;
    
    /** The logger of this class. */
    private static final Logger LOGGER = LogManager.getLogger(LifeCycleManager.class);
    /** */
    public static final String LOGGER_BEAN = "id-Logger";
    /** */
    private static final ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("./config/imports.xml");
    
    /**
     * Lifecycle init. Must be the first method of the main.
     */
    public static void initApplication() {
        
        if (CONTEXT.containsBean(LOGGER_BEAN)) {
            final ClassLoader loader = CONTEXT.getClassLoader();
            final URL res = loader.getResource((String) CONTEXT.getBean(LOGGER_BEAN));
            final LoggerContext context = (LoggerContext) LogManager.getContext(false);
            try {
                if (null != res) {
                    context.setConfigLocation(res.toURI());
                }
            } catch (final URISyntaxException e) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("Error while loading configuration file for logger");
                }
            }
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Initialize application");
        }

        if (CONTEXT.containsBean(MODELS_BEAN)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initialize MODELS_BEAN");
            }
            final Map<String, Model> models = (Map<String, Model>) CONTEXT.getBean(MODELS_BEAN);
            MODELS_PROVIDER.registerModels(models);
        }

        if (CONTEXT.containsBean(SIGNALS_BEAN)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initialize SIGNALS_BEAN");
            }
            final List<Signal> signals = (List<Signal>) CONTEXT.getBean(SIGNALS_BEAN);
            SIGNAL_PROVIDER.registerSignals(signals);
        }

        if (CONTEXT.containsBean(SLOTS_BEAN)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initialize SLOTS_BEAN");
            }
            final List<Slot> slots = (List<Slot>) CONTEXT.getBean(SLOTS_BEAN);
            SLOT_PROVIDER.regsiterSlots(slots);
        }

        if (CONTEXT.containsBean(ADAPTERS_BEAN)) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Initialize ADAPTERS_BEAN");
            }
            final List<CommonAdapter> adapters = (List<CommonAdapter>) CONTEXT.getBean(ADAPTERS_BEAN);
            ADAPTERS_PROVIDER.registerAdapters(adapters);
        }

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("End of Initialization");
        }
    }
    
    /**
     * Register beans in the providers.
     */
    public static void registerSlots() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Register slots");
        }
        final Map<String, Slot> slots = SLOT_PROVIDER.getSlots();
        
        for (final Entry<String, Slot> entry : slots.entrySet()) {
            final Slot slot = entry.getValue();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Slot to register :" + slot);
            }
            final Signal signal = SIGNAL_PROVIDER.findSignalByTopicName(slot.getTopicName());
            if (null == signal) {
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error("Slot " + slot.getSlotName() + " cannot be registered. Signal not exist");
                }
            } else {
                signal.attachSlotReceiver(slot);
            }
        }
    }
}
