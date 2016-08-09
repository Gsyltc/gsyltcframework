/*
 * @(#)DomainModelAdapter.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 9 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.api;

import com.jgoodies.binding.beans.Model;

/**
 * This interface is used to provide method for the GraphicalModelAdapter.
 *
 * @author Goubaud Sylvain
 * @param <M>
 *            type of the mode.
 *
 */
public interface DomainModelAdapter<M extends Model> extends CommonAdapter {
    
    
    /**
     * Get the model adapter.
     *
     * @return The model.
     */
    M getModel();
    
    /**
     * Set the Model Adapter.
     *
     * @param model
     *            Model to set.
     */
    void setModel(M model);
    
}
