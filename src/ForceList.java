import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.event.*;


public class ForceList extends JPanel implements ListSelectionListener {
    private static final String addString = "ADD", removeString = "REMOVE";

    public static HashMap<String, Force> forceMap = new HashMap<>();
    public static JList<String> list;

    private static JButton removeButton;
    private static JTextField forceField;

    private DefaultListModel<String> listModel;

    public ForceList() {
        super(null);

        listModel = new DefaultListModel<>();
        listModel.addElement("Net Force");

        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(JList.VERTICAL);
        list.setFont(new Font("Arial", Font.BOLD, 24 ));

        JScrollPane listScrollPane = new JScrollPane(list);

        JButton addButton = new JButton(addString);
        AddListener addListener = new AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(addListener);
        addButton.setEnabled(false);

        removeButton = new JButton(removeString);
        removeButton.setActionCommand(removeString);
        removeButton.addActionListener(new RemoveListener());

        forceField = new JTextField();
        forceField.addActionListener(addListener);
        forceField.getDocument().addDocumentListener(addListener);
        String name = listModel.getElementAt(list.getSelectedIndex()).toString();

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(removeButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(addButton);

        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.Y_AXIS));
        fieldPane.add(buttonPane);
        fieldPane.add(Box.createVerticalStrut(5));
        fieldPane.add(forceField);
        fieldPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        listScrollPane.setBounds(0,0,200,500);
        fieldPane.setBounds(0,500,200,80);
        add(listScrollPane);
        add(fieldPane);
    }


    class AddListener implements ActionListener, DocumentListener {
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        public void actionPerformed(ActionEvent e) {

        }
        public void insertUpdate(DocumentEvent e) {}
        public void removeUpdate(DocumentEvent e) {}
        public void changedUpdate(DocumentEvent e) {}
    }

    class RemoveListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }

    public void valueChanged(ListSelectionEvent e) {}
}
