package com.londonappbrewery.destini;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private Button choice1;
    private Button choice2;
    private TextView mTextView;
    private int mIndex = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        choice1 = (Button) findViewById(R.id.buttonTop);
        choice2 = (Button) findViewById(R.id.buttonBottom);
        mTextView = (TextView) findViewById(R.id.storyTextView);

        if(savedInstanceState != null) {
            mIndex = savedInstanceState.getInt("StoryIndex");
            if(mIndex == 1) {
                mTextView.setText(R.string.T1_Story);
                choice1.setText(R.string.T1_Ans1);
                choice2.setText(R.string.T1_Ans2);
            } else if(mIndex == 2) {
                mTextView.setText(R.string.T2_Story);
                choice1.setText(R.string.T2_Ans1);
                choice2.setText(R.string.T2_Ans2);
            } else if(mIndex == 3) {
                mTextView.setText(R.string.T3_Story);
                choice1.setText(R.string.T3_Ans1);
                choice2.setText(R.string.T3_Ans2);
            } else if(mIndex == 4) {
                mTextView.setText(R.string.T4_End);
                choice1.setText(R.string.Empty);
                choice2.setText(R.string.Empty);
            } else if(mIndex == 5) {
                mTextView.setText(R.string.T5_End);
                choice1.setText(R.string.Empty);
                choice2.setText(R.string.Empty);
            } else if(mIndex == 6) {
                mTextView.setText(R.string.T6_End);
                choice1.setText(R.string.Empty);
                choice2.setText(R.string.Empty);
            }
        } else {
            mIndex = 1;
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex == 1) {
                    mTextView.setText(R.string.T3_Story);
                    choice1.setText(R.string.T3_Ans1);
                    choice2.setText(R.string.T3_Ans2);
                    mIndex = 3;
                } else if(mIndex == 3) {
                    mTextView.setText(R.string.T6_End);
                    choice1.setText(R.string.Empty);
                    choice2.setText(R.string.Empty);
                    mIndex = 6;
                } else if(mIndex == 2) {
                    mTextView.setText(R.string.T3_Story);
                    choice1.setText(R.string.T3_Ans1);
                    choice2.setText(R.string.T3_Ans2);
                    mIndex = 3;
                }

            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mIndex == 1) {
                    mTextView.setText(R.string.T2_Story);
                    choice1.setText(R.string.T2_Ans1);
                    choice2.setText(R.string.T2_Ans2);
                    mIndex = 2;
                } else if(mIndex == 2) {
                    mTextView.setText(R.string.T4_End);
                    choice1.setText(R.string.Empty);
                    choice2.setText(R.string.Empty);
                    mIndex = 4;
                } else if(mIndex == 3) {
                    mTextView.setText(R.string.T5_End);
                    choice1.setText(R.string.Empty);
                    choice2.setText(R.string.Empty);
                    mIndex = 5;
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle other) {
        super.onSaveInstanceState(other);

        other.putInt("StoryIndex", mIndex);
    }
}
