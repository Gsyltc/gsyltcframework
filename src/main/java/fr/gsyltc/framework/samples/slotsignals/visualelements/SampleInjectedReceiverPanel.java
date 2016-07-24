/*
 * @(#)SampleInjectedReceiverPanel.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.samples.slotsignals.visualelements;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import fr.gsyltc.framework.samples.slotsignals.types.TopicName;
import fr.gsyltc.framework.slotsignals.action.api.SlotAction;
import fr.gsyltc.framework.slotsignals.slots.Slot;
import fr.gsyltc.framework.visualelements.AbstractCommandablePanel;

/**
 * @author Goubaud Sylvain
 *
 */
public class SampleInjectedReceiverPanel extends AbstractCommandablePanel {


    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SampleInjectedReceiverPanel.class);
    /** */
    private static final long serialVersionUID = -2157595278063874081L;
    /** */
    protected JTextField injectTf;

    /**
     *
     */
    public SampleInjectedReceiverPanel() {
        super();
        setName(getClass().getSimpleName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void build() {
        super.build();

        setLayout(new FormLayout(new ColumnSpec[] { //
                FormSpecs.RELATED_GAP_COLSPEC, //
                ColumnSpec.decode("pref:grow"), //
                FormSpecs.RELATED_GAP_COLSPEC, }, //
                new RowSpec[] { //
                        FormSpecs.RELATED_GAP_ROWSPEC, //
                        FormSpecs.PREF_ROWSPEC, //
                        FormSpecs.RELATED_GAP_ROWSPEC, }));

        injectTf = new JTextField();
        injectTf.setEditable(false);
        add(injectTf, "2, 2, fill, default");
        injectTf.setColumns(10);

        setBorder(new TitledBorder("Injected signal panel receiver"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createSlots() {
        // Create an java hard coded slot
        super.createSlots();
        final Slot injectedSlot = attachSlot(TopicName.INJECTION_TOPIC.name());
        if (null != injectedSlot) {
            injectedSlot.setSlotAction(new SlotAction<String>() {


                /**
                 *
                 * {@inheritDoc}
                 */
                @Override
                public void doAction(final String arg) {
                    injectTf.setText(arg);
                }
            });
        }
    }
}
