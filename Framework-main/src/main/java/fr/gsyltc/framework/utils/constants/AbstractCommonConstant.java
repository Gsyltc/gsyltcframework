/*
 * @(#)AbstractCommonConstant.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 9 août 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.utils.constants;

import fr.gsyltc.framework.adapters.AdaptersProvider;
import fr.gsyltc.framework.models.ModelsProvider;

/**
 *
 * @author Goubaud Sylvain
 *
 */
public interface AbstractCommonConstant {
    
    
    /** the new line caracter. */
    String NEW_LINE = "\n";
    /** The adapter provider instance. */
    AdaptersProvider ADAPTERS_PROVIDER = AdaptersProvider.INSTANCE;

    /** The models provider instance. */
    ModelsProvider MODELS_PROVIDER = ModelsProvider.INSTANCE;

    /** Default adapters bean name. */
    String ADAPTERS_BEAN = "id-Adapters";
    /** Default models bean name. */
    String MODELS_BEAN = "id-Models";
}
