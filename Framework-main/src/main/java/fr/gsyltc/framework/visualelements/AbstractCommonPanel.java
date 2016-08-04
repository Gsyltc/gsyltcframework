/*
 * @(#)AbstractCommonPanel.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 4 août 2016.
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

import org.apache.commons.lang3.NotImplementedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jgoodies.binding.PresentationModel;

import fr.gsyltc.framework.adapters.AdaptersProvider;
import fr.gsyltc.framework.adapters.api.Adaptable;
import fr.gsyltc.framework.adapters.api.CommonAdapter;
import fr.gsyltc.framework.visualelements.api.Bindable;

/**
 * @author Goubaud Sylvain
 *
 */
public abstract class AbstractCommonPanel extends JPanel implements Bindable, Adaptable {
    
    
    /** The logger of this class. */
    private static final Logger LOGGER = LogManager.getLogger(AbstractCommonPanel.class);

    /** */
    private static final String NEW_LINE = "\n";
    /** */
    private static final long serialVersionUID = 2794578279603616940L;

    /** */
    protected Map<String, ? extends Object> attributeMap = new ConcurrentHashMap<String, Object>();

    /** Presenters for the visual elements. */
    protected final List<PresentationModel<?>> presenters = new CopyOnWriteArrayList<PresentationModel<?>>();
    /** Signals list. */
    private final Map<String, CommonAdapter> adapters = new ConcurrentHashMap<String, CommonAdapter>();

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
                presenters.add(presentationModel);
            }
        }

    }

    /**
     * Build the visual element.
     */
    public void build() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Build the panel");
        }
        createAdapters();
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final PresentationModel<?> getPresenter(final int flInfosPresenterIndex) {
        return presenters.get(flInfosPresenterIndex);
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final List<PresentationModel<?>> getPresenters() {
        return Collections.unmodifiableList(presenters);
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder//
                .append("Component  : ").append(getName()) //
                .append("Nb presenters : ").append(presenters.size()).append(NEW_LINE)//
                .append("Nb adapters : ").append(adapters.size()).append(NEW_LINE);
        return stringBuilder.toString();
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final CommonAdapter findAdapter(final String adapterName) {
        return getAdapters().get(adapterName);
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public void createAdapters() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Create Adapters");
        }
    }

    /**
     *
     * {@inheritDoc}.
     */
    @Override
    public final CommonAdapter attachAdapter(final String adapterName) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Attach adapter" + adapterName);
        }
        final CommonAdapter adapter = AdaptersProvider.INSTANCE.findAdapterByName(adapterName);
        if (null == adapter) {
            throw new NotImplementedException("No signal to regsiter");
        } else if (getAdapters().containsKey(adapterName)) {
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Adapter already exist :" + adapterName);
            }
        } else {
            adapters.put(adapterName, adapter);
        }
        return adapter;
    }

    /**
     * Get the map of attached adapters.
     *
     * @return the adapters
     */
    private Map<String, CommonAdapter> getAdapters() {
        return Collections.unmodifiableMap(adapters);
    }
}
