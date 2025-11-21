import java.awt.*;
import javax.swing.*;

public class ToDoApp extends JFrame {

    private DefaultListModel<String> tasks;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton, deleteButton;

    public ToDoApp() {

        // Frame setup
        setTitle("To-Do List App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Top panel with text field + button
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        taskInput = new JTextField(20);
        addButton = new JButton("Add Task");

        topPanel.add(taskInput);
        topPanel.add(addButton);

        // Task list
        tasks = new DefaultListModel<>();
        taskList = new JList<>(tasks);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Delete button
        deleteButton = new JButton("Delete Selected Task");

        // Add components to frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);

        // Add task action
        addButton.addActionListener(e -> {
            String text = taskInput.getText().trim();
            if (!text.isEmpty()) {
                tasks.addElement(text);
                taskInput.setText("");
            }
        });

        // Delete task action
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
