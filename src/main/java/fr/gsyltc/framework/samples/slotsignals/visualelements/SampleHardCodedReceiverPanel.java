/*
 * @(#)SampleHardCodedReceiverPanel.java
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
public class SampleHardCodedReceiverPanel extends AbstractCommandablePanel {


    /** */
    private static final long serialVersionUID = -2157595278063874081L;
    /** */
    protected JTextField hardCodedTf;

    /**
     *
     */
    public SampleHardCodedReceiverPanel() {
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

        hardCodedTf = new JTextField();
        hardCodedTf.setEditable(false);
        add(hardCodedTf, "2, 2, fill, default");
        hardCodedTf.setColumns(10);

        setBorder(new TitledBorder("Hard coded signal panel recevier"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createSlots() {
        // Create an java hard coded slot
        super.createSlots();
        final Slot slot = new Slot(TopicName.HARD_CODED_TOPIC.name(), getClass().getSimpleName());
        slot.registerSlot();
        // attachSlot(TopicName.HARD_CODED_TOPIC.name());
        slot.setSlotAction(new SlotAction<String>() {


            /**
             *
             * {@inheritDoc}
             */
            @Override
            public void doAction(final String arg) {
                hardCodedTf.setText(arg);
            }
        });
    }
}
