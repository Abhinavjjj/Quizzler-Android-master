package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
  Button mTrueButton;
  Button mFalseButton;
  TextView myTextView;
  int mIndex=0;
  int mScore=0;
  ProgressBar bar;
TextView Score;

    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    int step=(int)Math.ceil(100.0/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mScore=savedInstanceState.getInt("ScoreKey");
            mIndex=savedInstanceState.getInt("IndexKey");
        }

        mTrueButton=(Button) findViewById(R.id.true_button);
        mFalseButton=(Button) findViewById(R.id.false_button);
        myTextView=(TextView) findViewById(R.id.question_text_view);
        bar=(ProgressBar) findViewById(R.id.progress_bar);
        Score=(TextView) findViewById((R.id.score));

        myTextView.setText(mQuestionBank[mIndex].getMQuestionId());
        Score.setText("Score "+mScore+"/"+mQuestionBank.length);


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               score(true);
            update();

            }
        });
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score(false);
               update();

            }
        });



    }

    public void update(){
        mIndex=(mIndex+1)%(mQuestionBank.length);

        if(mIndex==0){
            AlertDialog.Builder alert=new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setTitle("Game Over");
            alert.setMessage("Your Score: " + mScore+" points!");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();
        }




        myTextView.setText(mQuestionBank[mIndex].getMQuestionId());
        bar.incrementProgressBy(step);
       Score.setText("Score "+mScore+"/"+mQuestionBank.length);
    }
    
    public void score(boolean ans){
        if(ans==mQuestionBank[mIndex].isAnswer()) {
            mScore++;
        }

    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey",mScore);
        outState.putInt("IndexKey",mIndex);
    }
}
