import javax.swing.*;
import java.awt.event.*;
import java.util.Arrays;

public class removeduplicatesofdata extends JFrame implements ActionListener {

    JTextField inputField;
    JTextArea resultArea;
    JButton removeBtn;

    public removeduplicatesofdata() {

        setTitle("Duplicate Remover");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lbl = new JLabel("Enter numbers (space separated):");
        lbl.setBounds(20, 20, 300, 30);
        add(lbl);

        inputField = new JTextField();
        inputField.setBounds(20, 60, 340, 30);
        add(inputField);

        removeBtn = new JButton("Remove Duplicates");
        removeBtn.setBounds(20, 100, 200, 30);
        removeBtn.addActionListener(this);
        add(removeBtn);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane sp = new JScrollPane(resultArea);
        sp.setBounds(20, 150, 340, 100);
        add(sp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String[] parts = inputField.getText().trim().split("\\s+");
            int n = parts.length;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(parts[i]);

            // SAME LOGIC AS YOUR CODE
            int[] res = new int[n];
            int k = 0;

            for (int i = 0; i < n; i++) {
                int f = 0;
                for (int j = 0; j < k; j++) {
                    if (arr[i] == res[j]) {
                        f = 1;
                        break;
                    }
                }
                if (f == 0)
                    res[k++] = arr[i];
            }

            int[] finalArray = Arrays.copyOfRange(res, 0, k);
            resultArea.setText("After Removing Duplicates:\n" + Arrays.toString(finalArray));

        } catch (Exception ex) {
            resultArea.setText("Invalid Input! Enter only integers.");
        }
    }

    public static void main(String[] args) {
        new removeduplicatesofdata();
    }
}
