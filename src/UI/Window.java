package UI;

import Items.Materials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
        JScrollPane multiItemsPanel = new JScrollPane();
        JPanel scrollPanelView = new JPanel();
        scrollPanelView.setVisible(true);
        multiItemsPanel.setViewportView(scrollPanelView);
        multiItemsPanel.setPreferredSize(new Dimension(512, getMaximumSize().height));
        multiItemsPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        multiItemsPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JList<ItemPanel> singleItemPanel = new JList<>();
        JPanel optionPanel = new JPanel();
        //testing grid bag layout
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
        constraints.anchor = GridBagConstraints.LAST_LINE_END;

        overallLayout.setConstraints(optionPanel, constraints);
        desktop.add(optionPanel);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 2;
        constraints.weightx = 0.33f;
        constraints.weighty = 1f;
        constraints.anchor = GridBagConstraints.FIRST_LINE_START;

        overallLayout.setConstraints(multiItemsPanel, constraints);
        desktop.add(multiItemsPanel);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.gridheight = 1;
        constraints.weightx = 0.66f;
        constraints.weighty = 0.66f;
        constraints.anchor = GridBagConstraints.FIRST_LINE_END;

        overallLayout.setConstraints(singleItemTestPanel, constraints);
        desktop.add(singleItemTestPanel);

        multiItemsPanel.setVisible(true);
        singleItemPanel.setVisible(true);
        optionPanel.setVisible(true);
        multiItemTestPanel.setVisible(true);
        singleItemTestPanel.setVisible(true);

        optionPanel.add(new JButton("option"));
        // multiItemsPanel.add(new JButton("list"));
    //    scrollPanelView.add(new JLabel ("hello1"));
    //    scrollPanelView.add(new JLabel ("hello2"));
    //    scrollPanelView.add(new JLabel ("hello3"));

        FlowLayout fl = new FlowLayout();
        scrollPanelView.setLayout(fl);
        scrollPanelView.setPreferredSize(new Dimension(512, getHeight()));
        fl.setAlignment(FlowLayout.LEFT);

        MaterialPanel mp0 = new MaterialPanel(new Materials ("male0", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, scrollPanelView.getWidth(), scrollPanelView.getHeight());
        MaterialPanel mp1 = new MaterialPanel(new Materials ("male1", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, scrollPanelView.getWidth(), scrollPanelView.getHeight());
        MaterialPanel mp2 = new MaterialPanel(new Materials ("male2", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, scrollPanelView.getWidth(), scrollPanelView.getHeight());
        MaterialPanel mp3 = new MaterialPanel(new Materials ("male3", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, scrollPanelView.getWidth(), scrollPanelView.getHeight());
        MaterialPanel mp4 = new MaterialPanel(new Materials ("male4", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, scrollPanelView.getWidth(), scrollPanelView.getHeight());
        MaterialPanel mp5 = new MaterialPanel(new Materials ("male4", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, scrollPanelView.getWidth(), scrollPanelView.getHeight());

/*
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weighty = 1;
        c.weightx = 1;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 4, 20, 0);


        scrollPanelView.add (mp0, c);

       ++c.gridy;
        scrollPanelView.add (mp1, c);

        ++c.gridy;
        scrollPanelView.add (mp2, c);

        ++c.gridy;
        scrollPanelView.add (mp3, c);

        ++c.gridy;
        scrollPanelView.add (mp4, c);

        ++c.gridy;
        scrollPanelView.add (mp5, c);

        scrollPanelView.add (mp0, c);

        */

        scrollPanelView.add (mp0);
        scrollPanelView.add (mp1);
        scrollPanelView.add (mp2);
        scrollPanelView.add (mp3);
        scrollPanelView.add (mp4);
        scrollPanelView.add (mp5);

        singleItemTestPanel.add(new JButton("single"));




    //    MaterialPanel matPan = new MaterialPanel(new Materials ("male0", 10.50, 5, "bitchen.co", "Hot Shit", "resources/dontUse.png", "The best in the west"), true, desktop.getWidth()/ 3, desktop.getHeight() / 10);
    //    matPan.setBounds(backGroundBoarderThickness, backGroundBoarderThickness, desktop.getWidth()/ 3, desktop.getHeight() / 10);
    //    desktop.add(matPan);

    }


}
