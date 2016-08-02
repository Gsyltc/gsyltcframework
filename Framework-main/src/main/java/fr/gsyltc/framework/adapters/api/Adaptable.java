/*
 * @(#)Adaptable.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 1 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.adapters.api;

/**
 * @author Goubaud Sylvain
 *
 */
public interface Adaptable {
    
    
    /**
     * Attach an adapter to the component.
     *
     * @param adapter
     *            the adapter to attach.
     * @return return the newly attached adapter.
     */
    CommonAdapter attachAdapter(String adapter);

    /**
     * Find an attached adapter by his name.
     *
     * @param adapterName
     *            the name of the adapter.
     * @return the adapter.
     */
    CommonAdapter findAdapter(String adapterName);

    /**
     * Create and Attach Adapters.
     */
    void createAdapters();
}
