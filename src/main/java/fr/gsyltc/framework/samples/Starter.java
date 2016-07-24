/*
 * @(#)Starter.java
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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gsyltc.framework.slotsignals.common.SignalProvider;
import fr.gsyltc.framework.slotsignals.common.SlotsProvider;
import fr.gsyltc.framework.slotsignals.signals.Signal;
import fr.gsyltc.framework.slotsignals.slots.Slot;

/**
 * @author Goubaud Sylvain
 *
 */
public class Starter {
    
    
    /** */
    protected final static ClassPathXmlApplicationContext CONTEXT = new ClassPathXmlApplicationContext("./config/imports.xml");
    
    /** The logger of this class. */
    private static final Log LOGGER = LogFactory.getLog(Starter.class);
    
    /**
     * @return the logger
     */
    public static Log getLogger() {
        return LOGGER;
    }
    
    /**
     * @param args
     */
    public static void main(final String... args) {
        
        EventQueue.invokeLater(new Runnable() {
            
            
            /**
             *
             * {@inheritDoc}
             */
            @Override
            public void run() {
                try {
                    
                    final Map<String, Slot> slots = (Map<String, Slot>) CONTEXT.getBean("id-Slots");
                    final Map<String, Signal> signals = (Map<String, Signal>) CONTEXT.getBean("id-Signals");
                    SignalProvider.registerSignals(signals);
                    SlotsProvider.createSlots(slots);
                    
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    final JFrame mainFrame = new JFrame("Sample Panels");
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
                    mainFrame.pack();
                    //                    mainFrame.setMinimumSize(mainFrame.getPreferredSize());
                    mainFrame.setVisible(true);
                    
                } catch (final UnsupportedLookAndFeelException | //
                        ClassNotFoundException | //
                        InstantiationException | //
                        IllegalAccessException e) {
                    if (getLogger().isErrorEnabled()) {
                        getLogger().error("Look and feel error : ", e);
                    }
                }
            }
        });
    }
    
}
