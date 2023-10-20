package com.example.ordering_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chkbox_item1, chkbox_item2, chkbox_item3;
    CheckBox chkbox_opt1, chkbox_opt2, chkbox_opt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_order = findViewById(R.id.btn_add);
        EditText input_payment = findViewById(R.id.input_payment);
        TextView text_order = findViewById(R.id.text_order);
        text_order.append("\n");

        chkbox_item1 = findViewById(R.id.chkbox_item1);
        chkbox_item2 = findViewById(R.id.chkbox_item2);
        chkbox_item3 = findViewById(R.id.chkbox_item3);

        chkbox_opt1 = findViewById(R.id.chkbox_opt1);
        chkbox_opt2 = findViewById(R.id.chkbox_opt2);
        chkbox_opt3 = findViewById(R.id.chkbox_opt3);

        CheckBox items[] = {chkbox_item1, chkbox_item2, chkbox_item3};
        CheckBox opts[] = {chkbox_opt1, chkbox_opt2, chkbox_opt3};

        disable_checkboxes();

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String payment = input_payment.getText().toString();
                for (int i = 0; i < 3; ++i) {
                    if (items[i].isChecked()) {
                        text_order.append(items[i].getText());
                        text_order.append(": ");
                        for (int j = 0; j < 3; ++j) {
                            if (opts[j].isChecked()) {
                                text_order.append(opts[j].getText());
                                text_order.append("\n");
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        });
    }

    void disable_checkboxes() {
        chkbox_item1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkbox_item1.isChecked()) {
                    chkbox_item2.setEnabled(false);
                    chkbox_item3.setEnabled(false);
                } else {
                    chkbox_item2.setEnabled(true);
                    chkbox_item3.setEnabled(true);
                }
            }
        });
        chkbox_item2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkbox_item2.isChecked()) {
                    chkbox_item1.setEnabled(false);
                    chkbox_item3.setEnabled(false);
                } else {
                    chkbox_item1.setEnabled(true);
                    chkbox_item3.setEnabled(true);
                }
            }
        });
        chkbox_item3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkbox_item3.isChecked()) {
                    chkbox_item2.setEnabled(false);
                    chkbox_item1.setEnabled(false);
                } else {
                    chkbox_item2.setEnabled(true);
                    chkbox_item1.setEnabled(true);
                }
            }
        });

        chkbox_opt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkbox_opt1.isChecked()) {
                    chkbox_opt2.setEnabled(false);
                    chkbox_opt3.setEnabled(false);
                } else {
                    chkbox_opt2.setEnabled(true);
                    chkbox_opt3.setEnabled(true);
                }
            }
        });
        chkbox_opt2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkbox_opt2.isChecked()) {
                    chkbox_opt1.setEnabled(false);
                    chkbox_opt3.setEnabled(false);
                } else {
                    chkbox_opt1.setEnabled(true);
                    chkbox_opt3.setEnabled(true);
                }
            }
        });
        chkbox_opt3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkbox_opt3.isChecked()) {
                    chkbox_opt1.setEnabled(false);
                    chkbox_opt2.setEnabled(false);
                } else {
                    chkbox_opt1.setEnabled(true);
                    chkbox_opt2.setEnabled(true);
                }
            }
        });
    }
}