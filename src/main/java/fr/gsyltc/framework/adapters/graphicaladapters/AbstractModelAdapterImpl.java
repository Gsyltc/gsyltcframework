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

import java.io.Serializable;

import fr.gsyltc.framework.adapters.graphicaladapters.api.IGraphicalModelAdapter;

/**
 * @author Goubaud Sylvain Provide methods to update the graphical model for
 *         presenters
 * @param <M>
 */
public abstract class AbstractModelAdapterImpl<M> implements IGraphicalModelAdapter<M>, Serializable {


    /**
     *
     */
    private static final long serialVersionUID = -8284760937318141343L;
    /**
     * The model.
     */
    private M model;
    /**
     * Name of the model.
     */
    private final String adapterName;

    /**
     * Constructor.
     *
     * @param adapterName
     *            the adapter name.
     * @param model
     *            The model of the adapter.
     */
    public AbstractModelAdapterImpl(final String adapterName, final M model) {
        this.model = model;
        this.adapterName = adapterName;
    }

    /**
     * Constructor.
     *
     * @param adapterName
     *            the adapter name.
     */
    public AbstractModelAdapterImpl(final String adapterName) {
        this(adapterName, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getAdapterName() {
        return this.adapterName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final M getModel() {
        return this.model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setModel(final M model) {
        this.model = model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public abstract void init();
}
