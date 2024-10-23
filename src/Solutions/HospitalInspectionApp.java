package Solutions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HospitalInspectionApp
{
    // Components
    private JFrame frame;
    private JTextField txtHospitalName, txtLocation;
    private JComboBox<Integer> cmbYears;
    private JTextArea textAreaDetails;
    private ArrayList<String> inspections;
    private static final int MAX_INSPECTIONS = 5;

    public HospitalInspectionApp()
    {
        // Frame settings (Sleek and minimalist look)
        frame = new JFrame("Hospital Inspection Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);  // Set a larger frame size
        frame.setResizable(false);  // Prevent resizing
        frame.setLayout(new BorderLayout());

        // Panel for input fields (Hospital name, Location, Years since inspection)
        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Spacing

        // Hospital Name and Location fields
        txtHospitalName = new JTextField(15);
        txtLocation = new JTextField(15);
        JLabel lblName = new JLabel("Hospital Name:");
        JLabel lblLocation = new JLabel("Location:");
        inputPanel.add(lblName);
        inputPanel.add(txtHospitalName);
        inputPanel.add(lblLocation);
        inputPanel.add(txtLocation);

        // ComboBox for years since last inspection
        JLabel lblYears = new JLabel("Years since last inspection:");
        Integer[] years = {1, 2, 3, 4, 5};
        cmbYears = new JComboBox<>(years);
        inputPanel.add(lblYears);
        inputPanel.add(cmbYears);

        frame.add(inputPanel, BorderLayout.NORTH);

        // Panel for buttons (Save, Print, Clear)
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        JButton btnSave = new JButton("Save");
        JButton btnPrint = new JButton("Print");
        JButton btnClear = new JButton("Clear");
        buttonPanel.add(btnSave);
        buttonPanel.add(btnPrint);
        buttonPanel.add(btnClear);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Text area for displaying inspections (using JTextArea for multiline support)
        textAreaDetails = new JTextArea();
        textAreaDetails.setEditable(false);  // Set it to be read-only
        JScrollPane scrollPane = new JScrollPane(textAreaDetails);
        scrollPane.setPreferredSize(new Dimension(500, 200));  // Increase the size of the text area
        frame.add(scrollPane, BorderLayout.CENTER);

        // Menu Bar (File and Tools)
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem printItem = new JMenuItem("Print");
        JMenuItem clearItem = new JMenuItem("Clear");
        toolsMenu.add(saveItem);
        toolsMenu.add(printItem);
        toolsMenu.add(clearItem);
        menuBar.add(toolsMenu);

        frame.setJMenuBar(menuBar);

        // ArrayList to store inspections
        inspections = new ArrayList<>();

        // Button Action Listeners
        btnSave.addActionListener(e -> saveInspection());
        btnPrint.addActionListener(e -> printInspections());
        btnClear.addActionListener(e -> clearFields());

        // Menu Action Listeners
        saveItem.addActionListener(e -> saveInspection());
        printItem.addActionListener(e -> printInspections());
        clearItem.addActionListener(e -> clearFields());
        exitItem.addActionListener(e -> System.exit(0));

        // Show the frame with Apple-like look and feel
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Apple-like system look
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        SwingUtilities.updateComponentTreeUI(frame);

        frame.setVisible(true);
    }

    // Save inspection details in the specified format
    private void saveInspection()
    {
        if (inspections.size() >= MAX_INSPECTIONS)
        {
            JOptionPane.showMessageDialog(frame, "Error: Maximum of 5 inspections allowed.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String hospitalName = txtHospitalName.getText();
        String location = txtLocation.getText();
        int yearsSince = (int) cmbYears.getSelectedItem();

        if (!hospitalName.isEmpty() && !location.isEmpty())
        {
            // Format the saved inspection details as requested
            String details = "Hospital Name: " + hospitalName + "\n" +
                             "Hospital Location: " + location + "\n" +
                             "Years Since Inspection: " + yearsSince + "\n" +
                             "***********************************************************\n";
            
            inspections.add(details);
            JOptionPane.showMessageDialog(frame, "Inspection saved successfully!");
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Print inspection details in the text area
    private void printInspections()
    {
        textAreaDetails.setText("");  // Clear the current text
        for (String inspection : inspections)
        {
            textAreaDetails.append(inspection + "\n");  // Append each inspection on a new line
        }
    }

    // Clear all input fields
    private void clearFields()
    {
        txtHospitalName.setText("");
        txtLocation.setText("");
        cmbYears.setSelectedIndex(0);
        textAreaDetails.setText("");  // Clear the text area as well
    }

    public static void main(String[] args)
    {
        new HospitalInspectionApp();
    }
}
