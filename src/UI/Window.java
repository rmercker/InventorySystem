package UI;

import Items.Materials;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dontf on 6/24/2018.
 */
public class Window extends JFrame{

    private final int backGroundBoarderThickness = 5;

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
        setResizable(true);
        setVisible(true);
    }

    private void initDesktop () {
        JDesktopPane desktop = new JDesktopPane();
        setContentPane(desktop);

        desktop.setVisible(true);
        desktop.setSize(this.getSize());
        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        desktop.setBorder(BorderFactory.createLineBorder(Color.black, backGroundBoarderThickness));
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
        desktop.setLayout(new GridBagLayout());

        setUpMultiItemPanel (desktop);
        setUpSingleItemPanel (desktop);
        setUpOptionsPanel (desktop);
    }

    private void setUpMultiItemPanel (Container desktop) {
        JScrollPane multiItemsPanel = new JScrollPane();
        JPanel scrollPanelView = new JPanel();
        scrollPanelView.setVisible(true);
        multiItemsPanel.setVisible(true);
        multiItemsPanel.setWheelScrollingEnabled(true);
        multiItemsPanel.setViewportView(scrollPanelView);
        multiItemsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        multiItemsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0.33f;
        constraints.weighty = 1f;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        desktop.add(multiItemsPanel, constraints);

        scrollPanelView.setLayout(new GridLayout(0, 1));

        MaterialPanel mp0 = new MaterialPanel(new Materials ("male0", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp0.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp1 = new MaterialPanel(new Materials ("male1", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp1.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp2 = new MaterialPanel(new Materials ("male2", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp2.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp3 = new MaterialPanel(new Materials ("male3", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp3.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp4 = new MaterialPanel(new Materials ("male4", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp4.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp5 = new MaterialPanel(new Materials ("male5", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp5.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp6 = new MaterialPanel(new Materials ("female0", 10.50, 5, "Itchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true);
        mp4.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));
        MaterialPanel mp7 = new MaterialPanel(new Materials ("female1", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "This is a tes of how much description I cam get into this beast with out causing appearance issues and making it look bad!!!"), true);
        mp5.setPreferredSize(new Dimension(getWidth() / 3, getHeight() / 6));

        scrollPanelView.add (mp0);
        scrollPanelView.add (mp1);
        scrollPanelView.add (mp2);
        scrollPanelView.add (mp3);
        scrollPanelView.add (mp4);
        scrollPanelView.add (mp5);
        scrollPanelView.add (mp6);
        scrollPanelView.add (mp7);
    }

    private void setUpSingleItemPanel (Container desktop) {
        JScrollPane singleItemsPanel = new JScrollPane();
        JPanel scrollPanelView = new JPanel();
        scrollPanelView.setVisible(true);
        singleItemsPanel.setVisible(true);
        singleItemsPanel.setWheelScrollingEnabled(true);
        singleItemsPanel.setViewportView(scrollPanelView);
        singleItemsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        singleItemsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.66f;
        constraints.weighty = 1f;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        desktop.add(singleItemsPanel, constraints);

        scrollPanelView.setLayout(new GridLayout(0, 1));

        MaterialPanel mp0 = new MaterialPanel(new Materials ("male0", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp0.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp1 = new MaterialPanel(new Materials ("male1", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp1.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp2 = new MaterialPanel(new Materials ("male2", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp2.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp3 = new MaterialPanel(new Materials ("male3", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp3.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp4 = new MaterialPanel(new Materials ("male4", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp4.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp5 = new MaterialPanel(new Materials ("male5", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp5.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp6 = new MaterialPanel(new Materials ("female0", 10.50, 5, "Itchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), false);
        mp4.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));
        MaterialPanel mp7 = new MaterialPanel(new Materials ("female1", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "This is a tes of how much description I cam get into this beast with out causing appearance issues and making it look bad!!!"), false);
        mp5.setPreferredSize(new Dimension(2 * getWidth() / 3, (getHeight() / 2)));

        scrollPanelView.add (mp0);
        scrollPanelView.add (mp1);
        scrollPanelView.add (mp2);
        scrollPanelView.add (mp3);
        scrollPanelView.add (mp4);
        scrollPanelView.add (mp5);
        scrollPanelView.add (mp6);
        scrollPanelView.add (mp7);
    }

    private void setUpOptionsPanel (Container desktop) {
        JPanel placeHolder = new JPanel();
        placeHolder.setVisible(true);

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.66f;
        constraints.weighty = 1f;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.NORTHWEST;

        desktop.add(placeHolder, constraints);
    }

}
