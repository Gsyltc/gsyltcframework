/*
 * @(#)IGraphicalModelAdapter.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.graphicaladapters.api;

/**
 * @author Goubaud Sylvain
 * @param <M>
 *            This interface is used to provide method for the
 *            GraphicalModelAdapter.
 *
 */
public interface IGraphicalModelAdapter<M> {


    /**
     * Get the Adapter Name.
     *
     * @return the Adapter Name.
     */
    String getAdapterName();

    /**
     * Get the model adapter.
     *
     * @return The model.
     */
    M getModel();

    /**
     * Set the Adapter Name.
     *
     * @param name
     *            the Adapter Name.
     */
    void setAdapterName(String name);

    /**
     * Set the Model Adapter.
     *
     * @param model
     *            Model to set.
     */
    void setModel(M model);

}
