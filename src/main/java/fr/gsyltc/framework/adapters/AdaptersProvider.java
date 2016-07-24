/*
 * @(#)AdaptersProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.adapters.api.AbstractCommonAdapter;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;

/**
 * @author Goubaud Sylvain
 *
 */
public class AdaptersProvider {


    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SlotsProvider.class);
    /** List of slots registered. */
    private static final Map<String, AbstractCommonAdapter> ADAPTERS = new ConcurrentHashMap<String, AbstractCommonAdapter>();

    /**
     * Register a slot.
     *
     * @param newAdapter
     *            the adapter to register.
     */
    public static void registerAdapter(final AbstractCommonAdapter newAdapter) {
        AbstractCommonAdapter adapter = findAdapterByName(newAdapter.getAdapterName());
        if (null == adapter) {
            adapter = newAdapter;
            ADAPTERS.put(adapter.getAdapterName(), adapter);
        } else {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("The slot is already registered : " + adapter.getAdapterName());
            }
        }
    }

    /**
     * Register multiple adapters.
     *
     * @param adapters
     *            list of adapters to register.
     */
    public static void registerAdapters(final List<AbstractCommonAdapter> adapters) {
        for (final AbstractCommonAdapter adapter : adapters) {
            registerAdapter(adapter);
        }
    }

    /**
     * Find a registered adapter by his name.
     *
     * @param name
     *            the name of the adapter
     * @return the registered adapter.
     */
    public static AbstractCommonAdapter findAdapterByName(final String name) {
        return ADAPTERS.get(name);
    }

    /**
     * @return the slots
     */
    public static Map<String, AbstractCommonAdapter> getSlots() {
        return Collections.unmodifiableMap(ADAPTERS);
    }

    /**
     * Protected Constructor
     */
    private AdaptersProvider() {
        // Nothing to do
    }
}
