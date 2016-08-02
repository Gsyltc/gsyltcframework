/*
 * @(#)AdaptersProvider.java
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

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.adapters.api.CommonAdapter;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;

/**
 * @author Goubaud Sylvain
 *
 */
public enum AdaptersProvider {
    /** the singleton instance. */
    INSTANCE;

    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SlotsProvider.class);
    /** List of slots registered. */
    private static final Map<String, CommonAdapter> ADAPTERS = new ConcurrentHashMap<String, CommonAdapter>();

    /**
     * Find a registered adapter by his name.
     *
     * @param name
     *            the name of the adapter
     * @return the registered adapter.
     */
    public CommonAdapter findAdapterByName(final String name) {
        return ADAPTERS.get(name);
    }

    /**
     * @return the slots
     */
    public Map<String, CommonAdapter> getAdapters() {
        return Collections.unmodifiableMap(ADAPTERS);
    }

    /**
     * Register a slot.
     *
     * @param newAdapter
     *            the adapter to register.
     */
    public void registerAdapter(final CommonAdapter newAdapter) {
        CommonAdapter adapter = findAdapterByName(newAdapter.getAdapterName());
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
    public void registerAdapters(final List<CommonAdapter> adapters) {
        for (final CommonAdapter adapter : adapters) {
            registerAdapter(adapter);
        }
    }
}
