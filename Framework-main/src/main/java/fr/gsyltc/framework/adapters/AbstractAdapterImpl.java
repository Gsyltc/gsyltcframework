/*
 * @(#)AbstractAdapterImpl.java
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

import java.io.Serializable;

import fr.gsyltc.framework.adapters.api.CommonAdapter;

/**
 * Provide methods to update the simple adapter.
 *
 * @author Goubaud Sylvain
 */
public abstract class AbstractAdapterImpl implements CommonAdapter, Serializable {
    
    
    /** */
    private static final long serialVersionUID = -8284760937318141343L;
    
    /**
     * Name of the model.
     */
    protected String adapterName;
    
    /**
     * Constructor.
     *
     */
    public AbstractAdapterImpl() {
        this(null);
    }
    
    /**
     * Constructor.
     *
     * @param newAdapterName
     *            the adapter name.
     */
    public AbstractAdapterImpl(final String newAdapterName) {
        this.adapterName = newAdapterName;
    }
    
    /**
     * {@inheritDoc}.
     */
    @Override
    public final String getAdapterName() {
        return this.adapterName;
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
    public void setAdapterName(final String newAdapterName) {
        this.adapterName = newAdapterName;
    }
}
