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

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.gsyltc.framework.lifecycle.LifeCycleManager;

/**
 * @author Goubaud Sylvain
 *
 */
public final class Starter {
    
    
    /**
     * Protected constructor.
     */
    private Starter() {
        // Nothing to do
    }
    
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
        // Load spring configuration
        LifeCycleManager.initApplication();
        
        EventQueue.invokeLater(new Runnable() {
            
            
            /**
             *
             * {@inheritDoc}
             */
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    final JFrame mainFrame = new JFrame("Sample Panels");
                    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mainFrame.getContentPane().add(new MainPanel(), BorderLayout.CENTER);
                    mainFrame.pack();
                    mainFrame.setVisible(true);
                    
                    // LiveCycle attach register slots to signals
                    LifeCycleManager.registerBeans();
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
