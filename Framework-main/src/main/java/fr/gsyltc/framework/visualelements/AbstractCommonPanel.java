/*
 * @(#)AbstractCommonPanel.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 25 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.visualelements;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JPanel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jgoodies.binding.PresentationModel;

import fr.gsyltc.framework.adapters.api.DomainModelAdapter;
import fr.gsyltc.framework.visualelements.api.Bindable;

/**
 * @author Goubaud Sylvain
 *
 */
public abstract class AbstractCommonPanel extends JPanel implements Bindable {
    
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(AbstractCommonPanel.class);
    /** */
    private static final Object NEW_LINE = "\n";
    /** */
    private static final long serialVersionUID = 2794578279603616940L;

    /** Adapters for the visual elements. */
    protected Map<String, DomainModelAdapter<?>> adapters = new ConcurrentHashMap<String, DomainModelAdapter<?>>();
    /** */
    protected Map<String, ? extends Object> attributeMap = new ConcurrentHashMap<String, Object>();

    /** Presenters for the visual elements. */
    protected final List<PresentationModel<?>> presenters = new CopyOnWriteArrayList<PresentationModel<?>>();

    /**
     * Constructor.
     *
     * @param presentationModels
     *            Presentation Models list for the panel.
     */
    protected AbstractCommonPanel(final PresentationModel<?>... presentationModels) {
        super();
        if (null != presentationModels) {
            for (final PresentationModel<?> presentationModel : presentationModels) {
                this.presenters.add(presentationModel);
            }
        }
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public final void addAdapter(final DomainModelAdapter<?> adapter) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("DEBUG : set Adapter :" + adapter.getAdapterName());
        }
        this.adapters.put(adapter.getAdapterName(), adapter);
    }

    /**
     * Build the visual element.
     */
    public void build() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Build the panel");
        }
    }

    /**
     * Get an adapter by his name.
     *
     * @param key
     *            Name of the adapter.
     * @return A graphical adapter.
     */
    @Override
    public final DomainModelAdapter<?> getAdapterByName(final String key) {
        return this.getAdapters().get(key);
    }

    /**
     * @return the adapter
     */
    @Override
    public final Map<String, DomainModelAdapter<?>> getAdapters() {
        return Collections.unmodifiableMap(this.adapters);
    }

    /**
     * Get a Presenter by index.
     *
     * @param flInfosPresenterIndex
     *            Index of the presenter to return.
     * @return The presenter.
     */
    @Override
    public final PresentationModel<?> getPresenter(final int flInfosPresenterIndex) {
        return this.presenters.get(flInfosPresenterIndex);
    }

    /**
     * Get the list of presenters.
     *
     * @return the presenters
     */
    @Override
    public final List<PresentationModel<?>> getPresenters() {
        return Collections.unmodifiableList(this.presenters);
    }

    /**
     * Set the adapters for the visual element.
     *
     * @param newAdapters
     *            the adapters to set
     */
    @Override
    public final void setAdapters(final Map<String, DomainModelAdapter<?>> newAdapters) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("DEBUG : Set adapters : " + newAdapters);
        }
        this.adapters = newAdapters;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder//
                .append("Component  : ").append(getName()) //
                .append("Nb adapters : ").append(this.adapters.size()).append(NEW_LINE) //
                .append("Nb presenters : ").append(this.presenters.size()).append(NEW_LINE);
        return stringBuilder.toString();
    }
}
