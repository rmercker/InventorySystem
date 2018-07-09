package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dontf on 6/24/2018.
 */
public class Window extends JFrame{

    public Window (int width, int height) {
        initWindow(width, height);
        initMenu ();
        initDesktop ();
        initSections (getContentPane());
        validate();
        repaint();
    }

    private void initWindow (int width, int height) {
        setSize(width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inventory");
        setVisible(true);
    }

    private void initDesktop () {
        JDesktopPane desktop = new JDesktopPane();
        setContentPane(desktop);

        desktop.setVisible(true);
        desktop.setSize(this.getSize());
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktop.setBorder(BorderFactory.createLineBorder(Color.black, 5));
        desktop.setLocation(0, 0);
    }

    private void initMenu () {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.setVisible(true);

        JMenu productionOptions = new JMenu("Products");
        initProductionOptions (productionOptions);

        JMenu materialOptions = new JMenu("Materials");
        initMaterialOptions (materialOptions);

        JMenu searchOptions = new JMenu("Search");
        initSearchOptions (searchOptions);

        menuBar.add(productionOptions);
        menuBar.add(materialOptions);
        menuBar.add(searchOptions);
    }

    private void initProductionOptions(JMenu menu) {
        initItemOptions(menu);
    }

    private void initMaterialOptions(JMenu menu) {
        initItemOptions(menu);
    }

    private void initSearchOptions(JMenu menu) {
        JMenuItem allItems = new JMenuItem("All");
        JMenuItem productionItems = new JMenuItem("Products");
        JMenuItem materialItems = new JMenuItem ("Materials");
        JMenuItem lowOnItem = new JMenuItem("Low Stock");

        menu.add (allItems);
        menu.add (productionItems);
        menu.add (materialItems);
        menu.add (lowOnItem);
    }

    private void initItemOptions (JMenu menu) {
        JMenuItem increaseItem = new JMenuItem("Increase Stock");
        JMenuItem decreaseItem = new JMenuItem("Decrease Stock");
        JMenuItem updateItem = new JMenuItem("Update Details");
        JMenuItem newItem = new JMenuItem("Create New Item");
        JMenuItem deleteItem = new JMenuItem("Delete Item");

        menu.add(increaseItem);
        menu.add (decreaseItem);
        menu.add (updateItem);
        menu.add (newItem);
        menu.add (deleteItem);
    }

    // TODO: add all necessary panes!
    private void initSections (Container desktop) {
        JList<ItemPanel> multiItemsPanel = new JList<>();
        JList<ItemPanel> singleItemPanel = new JList<>();
        JPanel optionPanel = new JPanel();
        //testing gridbaglayout
        JPanel multiItemTestPanel = new JPanel();
        JPanel singleItemTestPanel = new JPanel();

        GridBagLayout overallLayout = new GridBagLayout();

        desktop.setLayout(overallLayout);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.66f;
        constraints.weighty = 0.33f;

        overallLayout.setConstraints(optionPanel, constraints);
        desktop.add(optionPanel);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0.33f;
        constraints.weighty = 1f;

        overallLayout.setConstraints(multiItemTestPanel, constraints);
        desktop.add(multiItemTestPanel);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.66f;
        constraints.weighty = 0.66f;

        overallLayout.setConstraints(singleItemTestPanel, constraints);
        desktop.add(singleItemTestPanel);

        multiItemsPanel.setVisible(true);
        singleItemPanel.setVisible(true);
        optionPanel.setVisible(true);
        multiItemTestPanel.setVisible(true);
        singleItemTestPanel.setVisible(true);

        optionPanel.add(new JButton("option"));
        multiItemTestPanel.add(new JButton("multi"));
        singleItemTestPanel.add(new JButton("single"));


    }

}
