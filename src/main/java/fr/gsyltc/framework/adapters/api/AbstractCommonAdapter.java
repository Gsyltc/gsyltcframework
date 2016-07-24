/*
 * @(#)AbstractCommandableAdapter.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.api;

/**
 * Abstract adapter for applicationq
 *
 * @author Goubaud Sylvain
 *
 */
public interface AbstractCommonAdapter {
    
    
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
