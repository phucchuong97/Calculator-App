package com.example.npc.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnCong, btnTru, btnNhan, btnChia, btnPhay, btnBang, btnDel, btnDelAll;
    TextView txtInput, txtOutput;
    static int phepTinh = 0;

    // 1 : phép cộng
// 2 : phép trừ
    // 3 : phép nhân
    // 4 : phép chia

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

        btn0.setOnClickListener(xuLiPhim);
        btn1.setOnClickListener(xuLiPhim);
        btn2.setOnClickListener(xuLiPhim);
        btn3.setOnClickListener(xuLiPhim);
        btn4.setOnClickListener(xuLiPhim);
        btn5.setOnClickListener(xuLiPhim);
        btn6.setOnClickListener(xuLiPhim);
        btn7.setOnClickListener(xuLiPhim);
        btn8.setOnClickListener(xuLiPhim);
        btn9.setOnClickListener(xuLiPhim);

        btnDel.setOnClickListener(xuLiPhim);
        btnDelAll.setOnClickListener(xuLiPhim);
        btnCong.setOnClickListener(xuLiPhim);
        btnTru.setOnClickListener(xuLiPhim);
        btnNhan.setOnClickListener(xuLiPhim);
        btnChia.setOnClickListener(xuLiPhim);
        btnBang.setOnClickListener(xuLiPhim);
        btnPhay.setOnClickListener(xuLiPhim);
    }


    private float tinh() {
        float kq = 0;
        String s = txtInput.getText().toString();
        if (check(s)) {
            String arrStringNumber[] = s.split("[\\+\\-\\*\\/]");
            ArrayList<Float> arrNum = new ArrayList<>();
            for (String s1 : arrStringNumber) {
                try {
                    arrNum.add(Float.parseFloat(s1));
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }
            ArrayList<Character> arrOperation = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if ("+".equals(s.charAt(i) + "") || "-".equals(s.charAt(i) + "") || "*".equals(s.charAt(i) + "") || "/".equals(s.charAt(i) + "")) {
                    arrOperation.add(s.charAt(i));
                }
            }
            if (arrNum.size() - arrOperation.size() == 1) {
                boolean checkNhanChia = true;
                // thực hiện nhân chia trước cho đến khi không còn phép nhân chia

                for (int i = 0; i < arrOperation.size(); i++) {
                    if ("*".equals(arrOperation.get(i) + "")) {
                        // sau khi thực hiện nhân thì xóa đi số ở trước => i giảm
                        arrNum.set(i + 1, arrNum.get(i) * arrNum.get(i + 1));
                        arrNum.remove(i);
                        arrOperation.remove(i);
                        i--;
                    } else {
                        if ("/".equals(arrOperation.get(i) + "")) {
                            if (arrNum.get(i + 1) != 0) {
                                arrNum.set(i + 1, arrNum.get(i) / arrNum.get(i + 1));
                                arrNum.remove(i);
                                arrOperation.remove(i);
                                i--;
                            } else {
                                Toast.makeText(MainActivity.this, "Lỗi chia cho 0", Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                }

                for (int i = 0; i < arrOperation.size(); i++) {
                    if ("+".equals(arrOperation.get(i) + "")) {
                        // sau khi thực hiện nhân thì xóa đi số ở trước => i giảm
                        arrNum.set(i + 1, arrNum.get(i) + arrNum.get(i + 1));
                        arrNum.remove(i);
                        arrOperation.remove(i);
                        i--;
                    } else {
                        if ("-".equals(arrOperation.get(i) + "")) {
                            arrNum.set(i + 1, arrNum.get(i) - arrNum.get(i + 1));
                            arrNum.remove(i);
                            arrOperation.remove(i);
                            i--;
                        }
                    }
                }

                kq = arrNum.get(0);
            } else {
                Toast.makeText(MainActivity.this, "Lỗi định dạng chuỗi nhập vào", Toast.LENGTH_LONG).show();
            }


        } else {
            Toast.makeText(MainActivity.this, "Lỗi định dạng chuỗi nhập vào", Toast.LENGTH_LONG).show();
        }
        return kq;
    }

    private boolean check(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if ("+".equals(s.charAt(i) + "") || "-".equals(s.charAt(i) + "") || "*".equals(s.charAt(i) + "") || "/".equals(s.charAt(i) + "")) {
                if ("+".equals(s.charAt(i + 1) + "") || "-".equals(s.charAt(i + 1) + "") || "*".equals(s.charAt(i + 1) + "") || "/".equals(s.charAt(i + 1) + "")) {
                    return false;
                }
            }
        }
        return true;
    }


    View.OnClickListener xuLiPhim = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn0:
                    txtInput.append("0");
                    break;
                case R.id.btn1:
                    txtInput.append("1");
                    break;
                case R.id.btn2:
                    txtInput.append("2");
                    break;
                case R.id.btn3:
                    txtInput.append("3");
                    break;
                case R.id.btn4:
                    txtInput.append("4");
                    break;
                case R.id.btn5:
                    txtInput.append("5");
                    break;
                case R.id.btn6:
                    txtInput.append("6");
                    break;
                case R.id.btn7:
                    txtInput.append("7");
                    break;
                case R.id.btn8:
                    txtInput.append("8");
                    break;
                case R.id.btn9:
                    txtInput.append("9");
                    break;
                case R.id.btnCong:
                    txtInput.append("+");
                    break;
                case R.id.btnTru:
                    txtInput.append("-");
                    break;
                case R.id.btnNhan:
                    txtInput.append("*");
                    break;
                case R.id.btnChia:
                    txtInput.append("/");
                    break;
                case R.id.btnPhay:
                    txtInput.append(".");
                    break;
                case R.id.btnDel:
                    String s = txtInput.getText().toString();
                    int n = s.length();
                    if (n > 0) s = s.substring(0, n - 1);
                    txtInput.setText(s);
                    break;
                case R.id.btnDelAll:
                    txtOutput.setText("0");
                    txtInput.setText("");
                    break;
                case R.id.btnBang:
                    float kq = tinh();
                    if(kq%1.0 == 0){
                        txtOutput.setText("" + (int)kq);
                    }else {
                        txtOutput.setText("" + kq);
                    }
                    break;
            }
        }
    };

    private void addControls() {
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnBang = findViewById(R.id.btnBang);
        btnDel = findViewById(R.id.btnDel);
        btnDelAll = findViewById(R.id.btnDelAll);
        btnPhay = findViewById(R.id.btnPhay);

        txtInput = findViewById(R.id.txtInput);
        txtOutput = findViewById(R.id.txtOutput);
    }
}
