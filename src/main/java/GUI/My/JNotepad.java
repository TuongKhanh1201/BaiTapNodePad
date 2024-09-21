/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.My;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import static javax.swing.KeyStroke.getKeyStroke;

/**
 *
 * @author ADMIN
 */
public class JNotepad extends JFrame {

    private JMenuBar menuBar;
    private JMenu mFile, MEdit, mView, mHelp, mFormat;
    private JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemPageSetup, itemPrint, itemExit, itemFont;
    private JMenuItem itemViewHelp,itemSend,itemAbout,itemZoom,itemStatus,itemZoomin;
    private JMenuItem itemUndo, itemCut, itemCopy, itemPaste, itemDelete, itemSearchWith, itemFind, itemFindNext, itemFindPrevious, itemReplace, itemGoto, itemSelectAll, itemTime;
    private JCheckBoxMenuItem itemWrap;
    
    private JTextArea txtEditor;

    public JNotepad(String title) {
        super(title);
        createMenu();
        createGUI();
        processEvent();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createMenu() {
        //tạo đối tượng thanh thực đơn
        menuBar = new JMenuBar();
        // tạo các thực và thêm vào thanh thực đơn
        menuBar.add(mFile = new JMenu("File"));
        menuBar.add(MEdit = new JMenu("Edit"));
        menuBar.add(mFormat = new JMenu("Format"));
        menuBar.add(mView = new JMenu("View"));
        menuBar.add(mHelp = new JMenu("Help"));

        // tạo các item Menu
        mFile.add(itemNew = new JMenuItem("New"));
        mFile.add(itemOpen = new JMenuItem("Open"));
        mFile.add(itemSave = new JMenuItem("Sava.."));
        mFile.add(itemSaveAs = new JMenuItem("Save As"));
        mFile.add(new JSeparator());
        mFile.add(itemPageSetup = new JMenuItem("PageSetup.."));
        mFile.add(itemPrint = new JMenuItem("Print.."));
        mFile.addSeparator();
        mFile.add(itemExit = new JMenuItem("Exit"));
        mFormat.add(itemWrap = new JCheckBoxMenuItem("Word Wrap", true));
        mFormat.add(itemFont = new JMenuItem("Font"));
        // tạo phím nóng cho các item
        itemNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        itemSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        itemSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        itemPageSetup.setAccelerator(getKeyStroke("F1"));
        itemPrint.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        itemExit.setAccelerator(getKeyStroke("F2"));
        // tạo các phím cho edit
        MEdit.add(itemUndo = new JMenuItem("Undo"));
        MEdit.add(itemCut = new JMenuItem("Cut"));
        MEdit.add(itemCopy = new JMenuItem("Copy"));
        MEdit.add(itemPaste = new JMenuItem("Paste"));
        MEdit.add(itemDelete = new JMenuItem("Delete"));
        MEdit.add(itemSearchWith = new JMenuItem("Search with Bing"));
        MEdit.add(itemFind = new JMenuItem("Find"));
        MEdit.add(itemFindNext = new JMenuItem("Find Next"));
        MEdit.add(itemFindPrevious = new JMenuItem("Find Previous"));
        MEdit.add(itemReplace = new JMenuItem("Replace"));
        MEdit.add(itemGoto = new JMenuItem("Go to"));
        MEdit.add(itemSelectAll = new JMenuItem("Select All"));
        MEdit.add(itemTime = new JMenuItem("Time"));
        // tạo phím nóng cho Edit
        itemUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        itemCut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        itemCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        itemDelete.setAccelerator(getKeyStroke("Delete"));
        itemPaste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        itemSearchWith.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        itemFind.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, KeyEvent.CTRL_DOWN_MASK));
        itemFindNext.setAccelerator(getKeyStroke("F3"));
        itemFindPrevious.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.SHIFT_DOWN_MASK));
        itemReplace.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.CTRL_DOWN_MASK));
        itemGoto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));
        itemSelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        itemTime.setAccelerator(getKeyStroke("F5"));
        // tạo các phím cho Help
        
        mHelp.add(itemViewHelp = new JMenuItem("View Help"));
        mHelp.add(itemSend = new JMenuItem("Send Feedback"));
        mHelp.add(itemAbout= new JMenuItem("About Notepad"));
        
        //tạo các phím cho view
        mView.add(itemZoom= new JMenuItem("Zoom"));
        mView.add(itemStatus = new JMenuItem("Statucs Bar"));
        
        setJMenuBar(menuBar);
    }

    private void processEvent() {
        // tiếp nhận sự kiện (event) cho itemExit
        itemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you to Exit") == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

    }

    private void createGUI() {
        txtEditor = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(txtEditor);
        add(scrollPane);
        txtEditor.setLineWrap(true);
        txtEditor.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    private KeyStroke keyStroke(String f4) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
