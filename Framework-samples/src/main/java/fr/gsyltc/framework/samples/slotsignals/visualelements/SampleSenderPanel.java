/*
 * @(#)SampleSenderPanel.java
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import fr.gsyltc.framework.samples.slotsignals.types.TopicName;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.visualelements.AbstractCommandablePanel;

/**
 * @author Goubaud Sylvain
 *
 */
public class SampleSenderPanel extends AbstractCommandablePanel {
    
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(SampleSenderPanel.class);

    /**
     *
     */
    private static final long serialVersionUID = 5305653932218673701L;

    /**
     * Get the logger.
     *
     * @return the logger
     */
    protected static final Log getLogger() {
        return LOGGER;
    }

    /**
     *
     */
    public SampleSenderPanel() {
        super();
        setName(getClass().getSimpleName());
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void build() {
        super.build();

        setBorder(new TitledBorder("Sender signal panel"));

        this.setLayout(new FormLayout(new ColumnSpec[] { //
                FormSpecs.UNRELATED_GAP_COLSPEC, //
                ColumnSpec.decode("97px"), //
                FormSpecs.UNRELATED_GAP_COLSPEC, //
                ColumnSpec.decode("97px"), }, //
                new RowSpec[] { //
                        FormSpecs.UNRELATED_GAP_ROWSPEC, //
                        RowSpec.decode("25px"), }));

        final JButton hardCodedButton = new JButton("Hard coded signal sender");
        this.add(hardCodedButton, "2, 2, left, top");
        hardCodedButton.addActionListener(new ActionListener() {
            
            
            /**
             *
             * {@inheritDoc}.
             */
            @Override
            public void actionPerformed(final ActionEvent event) {
                final Signal signal = findSignal(TopicName.HARD_CODED_TOPIC.name());
                if (null != signal) {
                    signal.fireSignal(TopicName.HARD_CODED_TOPIC.name().replace("_", " "));
                }
            }
        });

        final JButton injectionButton = new JButton("Injected signal sender");
        this.add(injectionButton, "4, 2, left, top");
        injectionButton.addActionListener(new ActionListener() {
            
            
            /**
             *
             * {@inheritDoc}.
             */
            @Override
            public void actionPerformed(final ActionEvent event) {
                final Signal signal = findSignal(TopicName.INJECTION_TOPIC.name());
                if (null != signal) {
                    signal.fireSignal(TopicName.INJECTION_TOPIC.name().replace("_", " "));
                }
            }
        });

    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void createSignals() {
        // Create an java coded signal
        super.createSignals();
        final Signal hardCodedSignal = new Signal(TopicName.HARD_CODED_TOPIC.name());
        registerSignal(hardCodedSignal);
        
        // attach an injected signal
        attachSignal(TopicName.INJECTION_TOPIC.name());
    }
}
