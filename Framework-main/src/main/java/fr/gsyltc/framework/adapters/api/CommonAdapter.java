/*
 * @(#)CommonAdapter.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 25 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.api;

/**
 * Abstract adapter for application.
 *
 * @author Goubaud Sylvain
 *
 */
public interface CommonAdapter {
    
    
    /**
     * Get the Adapter Name.
     *
     * @return the Adapter Name.
     */
    String getAdapterName();

    /**
     * Initialize the adapter.
     */
    void init();

    /**
     * Set the name of the adapter.
     *
     * @param newAdapterName
     *            the parameter name.
     */
    void setAdapterName(String newAdapterName);
}
