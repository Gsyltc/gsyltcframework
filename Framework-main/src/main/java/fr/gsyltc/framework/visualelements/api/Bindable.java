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

import com.jgoodies.binding.PresentationModel;

/**
 * @author Goubaud Sylvain
 *
 */
public interface Bindable {
    
    
    /**
     * Get a presenter by his index.
     *
     * @param flInfosPresenterIndex
     *            index of the presenter.
     * @return a Presentation model.
     */
    PresentationModel<?> getPresenter(int flInfosPresenterIndex);

    /**
     * Get the presenters.
     *
     * @return list of presentation model.
     */
    List<PresentationModel<?>> getPresenters();
}
