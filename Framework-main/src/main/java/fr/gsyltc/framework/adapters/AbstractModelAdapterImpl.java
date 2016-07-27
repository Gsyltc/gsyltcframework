/*
 * @(#)AbstractModelAdapterImpl.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 27 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters;

import fr.gsyltc.framework.adapters.api.DomainModelAdapter;

/**
 * Provide methods to update the graphical model for presenters.
 *
 * @author Goubaud Sylvain
 * @param <M>
 *            the model.
 */
public abstract class AbstractModelAdapterImpl<M> extends AbstractAdapterImpl implements DomainModelAdapter<M> {
    
    
    /**
     *
     */
    private static final long serialVersionUID = -8284760937318141343L;
    /**
     * The model.
     */
    private M model;

    /**
     *
     */
    public AbstractModelAdapterImpl() {
        super();
    }

    /**
     * Constructor.
     *
     * @param newAdapterName
     *            the adapter name.
     */
    public AbstractModelAdapterImpl(final String newAdapterName) {
        super(newAdapterName, null);
    }

    /**
     * Constructor.
     *
     * @param newAdapterName
     *            the adapter name.
     * @param newModel
     *            The model of the adapter.
     */
    public AbstractModelAdapterImpl(final String newAdapterName, final M newModel) {
        super(newAdapterName);
        this.model = newModel;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public final M getModel() {
        return this.model;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public abstract void init();

    /**
     * {@inheritDoc}.
     */
    @Override
    public final void setModel(final M newModel) {
        this.model = newModel;
    }
}
