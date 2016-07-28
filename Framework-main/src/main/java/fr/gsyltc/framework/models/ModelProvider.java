/*
 * @(#)ModelProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 28 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.models;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jgoodies.binding.beans.Model;

import fr.gsyltc.framework.slotsignals.common.SignalProvider;

/**
 * @author Goubaud Sylvain
 *
 */
public final class ModelProvider {
    
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SignalProvider.class);

    /** List of signals registered. */
    private static final Map<String, Model> MODELS = new ConcurrentHashMap<String, Model>();

    /**
     * Find a registered model by his topic name.
     *
     * @param name
     *            the topic of the model
     * @return the registered model.
     */
    public static Model findModelByName(final String name) {
        return MODELS.get(name);
    }

    /**
     * @return the slots
     */
    public static Map<String, Model> getModels() {
        return Collections.unmodifiableMap(MODELS);
    }

    /**
     * Register a model.
     *
     * @param name
     *            name of the model
     *
     * @param newModel
     *            the model to register.
     * @return the registered model.
     */
    public static Model registerModel(final String name, final Model newModel) {
        Model model = findModelByName(name);
        if (null == model) {
            model = newModel;
            MODELS.put(name, model);
        } else {
            if (LOGGER.isErrorEnabled()) {
                LOGGER.error("The model is already registered : " + name);
            }
        }
        return model;
    }

    /**
     * Register multiple models.
     *
     * @param models
     *            map of models to register.
     */
    public static void registerModels(final Map<String, Model> models) {
        MODELS.putAll(models);
    }

    /**
     * Protected Constructor.
     */
    private ModelProvider() {
        // Nothing to do.
    }
}
