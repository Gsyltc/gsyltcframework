/*
 * @(#)ModelsProvider.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 4 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.models;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jgoodies.binding.beans.Model;

/**
 * @author Goubaud Sylvain
 *
 */
public enum ModelsProvider {
    /** the singleton instances. */
    INSTANCE;
    
    /** The logger of this class. */
    private static final Logger LOGGER = LogManager.getLogger(ModelsProvider.class);
    /** List of signals registered. */
    private static final Map<String, Model> MODELS = new ConcurrentHashMap<String, Model>();
    
    /**
     * Find a registered model by his topic name.
     *
     * @param name
     *            the topic of the model
     * @return the registered model.
     */
    public Model findModelByName(final String name) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Find model : " + name());
        }
        return MODELS.get(name);
    }
    
    /**
     * @return the slots
     */
    public Map<String, Model> getModels() {
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
    public Model registerModel(final String name, final Model newModel) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Register model : " + newModel.toString());
        }
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
    public void registerModels(final Map<String, Model> models) {
        MODELS.putAll(models);
    }
}
