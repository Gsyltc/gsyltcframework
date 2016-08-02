/*
 * @(#)SignalsProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 1 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.slotsignals.common;

import java.util.Collections;
import java.util.List;
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
public enum SignalsProvider {
    /** The singleton instance. */
    INSTANCE;

    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SignalsProvider.class);

    /** List of signals registered. */
    private static final Map<String, Signal> SIGNALS = new ConcurrentHashMap<String, Signal>();

    /**
     * Find a registered signal by his topic name.
     *
     * @param topicName
     *            the topic of the signal
     * @return the registered signal.
     */
    public Signal findSignalByTopicName(final String topicName) {
        return SIGNALS.get(topicName);
    }

    /**
     * @return the slots
     */
    public Map<String, Signal> getSignals() {
        return Collections.unmodifiableMap(SIGNALS);
    }

    /**
     * Register a signal.
     *
     * @param newSignal
     *            the signal to register.
     * @return the registered signal.
     */
    public Signal registerSignal(final Signal newSignal) {
        final String topicName = newSignal.getTopicName();
        Signal signal = findSignalByTopicName(topicName);
        if (null == signal) {
            signal = newSignal;
            SIGNALS.put(topicName, signal);
        } else {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("The signal is already registered : " + topicName);
            }
        }
        return signal;
    }

    /**
     * Register multiple signals.
     *
     * @param signals
     *            map of signals to register.
     */
    public void registerSignals(final List<Signal> signals) {
        for (final Signal signal : signals) {
            SIGNALS.put(signal.getTopicName(), signal);
        }
    }

}
