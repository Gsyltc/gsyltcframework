/*
 * @(#)GraphicalModelAdapterImpl.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.graphicaladapters;

import fr.gsyltc.framework.adapters.graphicaladapters.api.IGraphicalModelAdapter;

/**
 * @author Goubaud Sylvain Provide methods to update the graphical model for
 *         presenters
 * @param <M>
 */
public class GraphicalModelAdapterImpl<M> implements IGraphicalModelAdapter<M> {

    /**
     * The model.
     */
    private M model;
    /**
     * Name of the model.
     */
    private String name;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAdapterName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public M getModel() {
        return this.model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAdapterName(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setModel(final M model) {
        this.model = model;
    }
}
