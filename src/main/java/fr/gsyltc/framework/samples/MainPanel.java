/*
 * @(#)MainPanel.java
 *
 * Goubaud Sylvain
 * Created : 2016
 * Modified : 24 juil. 2016.
 *
 * This code may be freely used and modified on any personal or professional
 * project.  It comes with no warranty.
 *
 */

package fr.gsyltc.framework.samples;

import javax.swing.JPanel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import fr.gsyltc.framework.samples.slotsignals.visualelements.SampleDualReceiverPanel;
import fr.gsyltc.framework.samples.slotsignals.visualelements.SampleHardCodedReceiverPanel;
import fr.gsyltc.framework.samples.slotsignals.visualelements.SampleInjectedReceiverPanel;
import fr.gsyltc.framework.samples.slotsignals.visualelements.SampleSenderPanel;

/**
 * @author Goubaud Sylvain
 *
 */
public class MainPanel extends JPanel {


    /**
     *
     */
    private static final long serialVersionUID = 2385349410839507600L;

    /**
     *
     */
    public MainPanel() {
        this.setLayout(new FormLayout(new ColumnSpec[] { //
                FormSpecs.RELATED_GAP_COLSPEC, //
                ColumnSpec.decode("pref:grow"), //
                FormSpecs.RELATED_GAP_COLSPEC, //
                ColumnSpec.decode("pref:grow"), //
                FormSpecs.RELATED_GAP_COLSPEC, }, //
                new RowSpec[] { //
                        FormSpecs.RELATED_GAP_ROWSPEC, //
                        RowSpec.decode("pref:grow"), //
                        FormSpecs.RELATED_GAP_ROWSPEC, //
                        RowSpec.decode("pref:grow"), //
                        FormSpecs.RELATED_GAP_ROWSPEC, //
                        RowSpec.decode("pref:grow"), //
                        FormSpecs.RELATED_GAP_ROWSPEC, //
                        RowSpec.decode("pref:grow"), //
                        FormSpecs.RELATED_GAP_ROWSPEC, }));

        final SampleSenderPanel sender = new SampleSenderPanel();
        sender.build();
        this.add(sender, "2,2");

        final SampleDualReceiverPanel dualReceiver = new SampleDualReceiverPanel();
        dualReceiver.build();
        this.add(dualReceiver, "2,4,3,1");

        final SampleInjectedReceiverPanel injectedReceiver = new SampleInjectedReceiverPanel();
        injectedReceiver.build();
        this.add(injectedReceiver, "2,6,3,1");

        final SampleHardCodedReceiverPanel hardCodedReceiver = new SampleHardCodedReceiverPanel();
        hardCodedReceiver.build();
        this.add(hardCodedReceiver, "2,8,3,1");
    }

}
