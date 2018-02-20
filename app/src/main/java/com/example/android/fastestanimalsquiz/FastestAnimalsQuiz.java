package com.example.android.fastestanimalsquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class FastestAnimalsQuiz extends AppCompatActivity {
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private boolean checkBox6_1;
    private boolean checkBox6_2;
    private boolean checkBox6_3;
    private boolean checkBox6_4;
    private boolean checkBox6_5;
    private String answer6;
    private String answer7;
    private String answer8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fastest_animals_quiz);
    }

    //first answer
    public void check1(){
        EditText viewFirstAnswer = (EditText) findViewById(R.id.answer_1);
        if (getString(R.string.answer_1).equalsIgnoreCase(viewFirstAnswer.getText().toString().trim())){
            answer1 = "right";
        }
        else if (!viewFirstAnswer.getText().toString().equals("")){
            answer1 = "wrong";
        }
    }

    //second answer
    public void onRadioButtonClicked2(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.answer_2_3)
                answer2 = "right";
            else
                answer2 = "wrong";
        }

    }

    //third answer
    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.answer_3_3)
                answer3 = "right";
            else
                answer3 = "wrong";
        }

    }

    //fourth answer
    public void onRadioButtonClicked4(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.answer_4_4)
                answer4 = "right";
            else
                answer4 = "wrong";
        }

    }

    //fifth answer
    public void onRadioButtonClicked5(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.answer_5_1)
                answer5 = "right";
            else
                answer5 = "wrong";
        }
    }

    //sixth answer
    public void onCheckBoxClicked6(View view) {
        // Is the button now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if (checked) {
            switch (view.getId()){
                case R.id.answer_6_1: checkBox6_1 = true;
                    break;
                case R.id.answer_6_2: checkBox6_2 = true;
                    break;
                case R.id.answer_6_3: checkBox6_3 = true;
                    break;
                case R.id.answer_6_4: checkBox6_4 = true;
                    break;
                case R.id.answer_6_5: checkBox6_5 = true;
                    break;
            }
        } else {
            switch (view.getId()) {
                case R.id.answer_6_1:
                    checkBox6_1 = false;
                    break;
                case R.id.answer_6_2:
                    checkBox6_2 = false;
                    break;
                case R.id.answer_6_3:
                    checkBox6_3 = false;
                    break;
                case R.id.answer_6_4:
                    checkBox6_4 = false;
                    break;
                case R.id.answer_6_5:
                    checkBox6_5 = false;
                    break;
            }
        }
    }

    //seventh answer
    public void onRadioButtonClicked7(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.answer_7_3)
                answer7 = "right";
            else
                answer7 = "wrong";
        }
    }

    //eigth answer
    public void onRadioButtonClicked8(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        if (checked) {
            if (view.getId() == R.id.answer_8_2)
                answer8 = "right";
            else
                answer8 = "wrong";
        }
    }

    private String checkFulfilment(){
        String toastMessage = "";
        String newLine = "\n";
        if (answer1 == null)
            toastMessage += getString(R.string.suggestion_to_answer_1) + newLine;
        if (answer2 == null)
            toastMessage += getString(R.string.suggestion_to_answer_2) + newLine;
        if (answer3 == null)
            toastMessage += getString(R.string.suggestion_to_answer_3) + newLine;
        if (answer4 == null)
            toastMessage += getString(R.string.suggestion_to_answer_4) + newLine;
        if (answer5 == null)
            toastMessage += getString(R.string.suggestion_to_answer_5) + newLine;
        if (!checkBox6_1 & !checkBox6_2 & !checkBox6_3 & !checkBox6_4 & !checkBox6_5)
            toastMessage += getString(R.string.suggestion_to_answer_6) + newLine;
        if (answer7 == null)
            toastMessage += getString(R.string.suggestion_to_answer_7) + newLine;
        if (answer8 == null)
            toastMessage += getString(R.string.suggestion_to_answer_8);
        return toastMessage;
    }

    //Check answer with checkBoxes
    private void check6(){
        if (checkBox6_1 & checkBox6_3 & checkBox6_4 & !checkBox6_2 & !checkBox6_5)
            answer6 = "right";
        else
            answer6 = "wrong";
    }

    //assign text to results textveiw
    private int assignResMess(){
        //setting visible header and footer text
        ((CustomFontTextView) findViewById(R.id.results_sentence)).setVisibility(View.VISIBLE);
        ((CustomFontTextView) findViewById(R.id.conclusion)).setVisibility(View.VISIBLE);
        int result = 0;
        String[] answers = {answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8};
        CustomFontTextView[] rightAnswViews =  {(CustomFontTextView) findViewById(R.id.right_answer_1),
                (CustomFontTextView) findViewById(R.id.right_answer_2),
                (CustomFontTextView) findViewById(R.id.right_answer_3),
                (CustomFontTextView) findViewById(R.id.right_answer_4),
                (CustomFontTextView) findViewById(R.id.right_answer_5),
                (CustomFontTextView) findViewById(R.id.right_answer_6),
                (CustomFontTextView) findViewById(R.id.right_answer_7),
                (CustomFontTextView) findViewById(R.id.right_answer_8)};

        for (int i=0; i<8; i++){
            if (answers[i].equalsIgnoreCase("right")){
                rightAnswViews[i].setVisibility(View.VISIBLE);
                rightAnswViews[i].setText((i+1) + ". Yep, right answer :)");
                rightAnswViews[i].setTextColor(Color.parseColor("#1E4620"));
                result ++;
            } else {
                rightAnswViews[i].setVisibility(View.VISIBLE);
                rightAnswViews[i].setText((i+1) + ". Nope, you were wrong here.");
                rightAnswViews[i].setTextColor(Color.RED);
            }
        }

        return result;
    }

    //restart app
    public void recreateActivity(View view){
        this.recreate();
        ((ScrollView)findViewById(R.id.activity_fastest_animals_quiz)).scrollTo(0, 0);

        answer1 = null;
        answer2 = null;
        answer3 = null;
        answer4 = null;
        answer5 = null;
        checkBox6_1 = false;
        checkBox6_2 = false;
        checkBox6_3 = false;
        checkBox6_4 = false;
        checkBox6_5 = false;
        answer6 = null;
        answer7 = null;
        answer8 = null;

        //clear edditText
        ((EditText) findViewById(R.id.answer_1)).setText("");

        //clear check from all radiogroups
        ((RadioGroup) findViewById(R.id.answer_2)).clearCheck();
        ((RadioGroup) findViewById(R.id.answer_3)).clearCheck();
        ((RadioGroup) findViewById(R.id.answer_4)).clearCheck();
        ((RadioGroup) findViewById(R.id.answer_5)).clearCheck();
        ((RadioGroup) findViewById(R.id.answer_7)).clearCheck();
        ((RadioGroup) findViewById(R.id.answer_8)).clearCheck();

        //uncheck all checkboxes
        ((CheckBox) findViewById(R.id.answer_6_1)).setChecked(false);
        ((CheckBox) findViewById(R.id.answer_6_2)).setChecked(false);
        ((CheckBox) findViewById(R.id.answer_6_3)).setChecked(false);
        ((CheckBox) findViewById(R.id.answer_6_4)).setChecked(false);
        ((CheckBox) findViewById(R.id.answer_6_5)).setChecked(false);
    }

    //check results
    public void checkResults(View view){
        //checking 1 question
        check1();
        String toastMessage = checkFulfilment();
        if (!toastMessage.equals("")){
            Toast.makeText(this, toastMessage,
                    Toast.LENGTH_LONG).show();
        } else {
            //firstly assign answer for question with  checkboxes
            check6();
            //assigning result messages
            int totalResult = assignResMess();
            //showing total result
            ((CustomFontTextView)findViewById(R.id.total_result)).setVisibility(View.VISIBLE);
            ((CustomFontTextView)findViewById(R.id.total_result)).setText("!!!You answered right for "
                    + totalResult + " from 8 questions.");
            ((ScrollView)findViewById(R.id.activity_fastest_animals_quiz)).fullScroll(ScrollView.FOCUS_DOWN);
            ((Button) findViewById(R.id.recreateActivity)).setVisibility(View.VISIBLE);
            Toast.makeText(this, "!!!You answered right for "
                    + totalResult + " from 8 questions.", Toast.LENGTH_LONG).show();
        }
    }
}
