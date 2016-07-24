/*
 * @(#)Bindable.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 23 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.visualelements.api;

import java.util.List;
import java.util.Map;

import com.jgoodies.binding.PresentationModel;

import fr.gsyltc.framework.adapters.graphicaladapters.api.IGraphicalModelAdapter;

/**
 * @author Goubaud Sylvain
 *
 */
public interface Bindable {

    /**
     * @param adapter
     */
    void addAdapter(IGraphicalModelAdapter<?> adapter);
    
    /**
     * @param adapters
     */
    void setAdapters(Map<String, IGraphicalModelAdapter<?>> adapters);
    
    /**
     * @return
     */
    List<PresentationModel<?>> getPresenters();
    
    /**
     * @param flInfosPresenterIndex
     * @return
     */
    PresentationModel<?> getPresenter(int flInfosPresenterIndex);
    
    /**
     * @return
     */
    Map<String, IGraphicalModelAdapter<?>> getAdapters();
    
    /**
     * @param key
     * @return
     */
    IGraphicalModelAdapter<?> getAdapterByName(String key);

}
