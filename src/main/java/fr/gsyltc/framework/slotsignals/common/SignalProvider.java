/*
 * @(#)SignalProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.slotsignals.signals.Signal;

/**
 * This class is for register all signals of the application.
 *
 * @author Goubaud Sylvain
 *
 */
public final class SignalProvider {
    
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SignalProvider.class);
    
    /** List of signals registered. */
    private static final Map<String, Signal> SIGNALS = new ConcurrentHashMap<String, Signal>();
    
    /**
     * Register a signal.
     *
     * @param newSignal
     *            the signal to register.
     * @return the registered signal.
     */
    public static Signal addSignal(final Signal newSignal) {
        Signal signal = findSignalByTopicName(newSignal.getTopicName());
        if (null == signal) {
            signal = newSignal;
            SIGNALS.put(signal.getTopicName(), signal);
        } else {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("The signal is already registered");
            }
        }
        return signal;
    }
    
    /**
     * Register multiple signals.
     *
     * @param signalsMap
     *            map of signals to register.
     */
    public static void registerSignals(final Map<String, Signal> signalsMap) {
        SIGNALS.putAll(signalsMap);
    }
    
    /**
     * Find a registered signal by his topic name.
     *
     * @param topicName
     *            the topic of the signal
     * @return the registered signal.
     */
    public static Signal findSignalByTopicName(final String topicName) {
        return SIGNALS.get(topicName);
    }
    
    /**
     * Protected Constructor
     */
    private SignalProvider() {
        // Nothing to do.
    }
}
