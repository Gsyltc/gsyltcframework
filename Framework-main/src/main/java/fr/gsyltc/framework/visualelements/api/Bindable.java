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

import fr.gsyltc.framework.adapters.api.DomainModelAdapter;

/**
 * @author Goubaud Sylvain
 *
 */
public interface Bindable {
    
    
    /**
     * @param newAdapter
     */
    void addAdapter(DomainModelAdapter<?> newAdapter);

    /**
     * @param key
     * @return
     */
    DomainModelAdapter<?> getAdapterByName(String key);

    /**
     * @return
     */
    Map<String, DomainModelAdapter<?>> getAdapters();

    /**
     * @param flInfosPresenterIndex
     * @return
     */
    PresentationModel<?> getPresenter(int flInfosPresenterIndex);

    /**
     * @return
     */
    List<PresentationModel<?>> getPresenters();

    /**
     * @param newAdapter
     */
    void setAdapters(Map<String, DomainModelAdapter<?>> newAdapter);

}
