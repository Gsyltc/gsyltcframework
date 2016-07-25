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
     * Initialize the adapter.
     */
    void init();

    /**
     * Get the Adapter Name.
     *
     * @return the Adapter Name.
     */
    String getAdapterName();
}
