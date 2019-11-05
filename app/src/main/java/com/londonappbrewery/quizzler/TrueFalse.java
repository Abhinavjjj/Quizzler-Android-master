package com.londonappbrewery.quizzler;

public class TrueFalse {

    private int MQuestionId;
    private boolean answer;

    public TrueFalse(int MQuestionId, boolean answer) {
        this.MQuestionId = MQuestionId;
        this.answer = answer;
    }

    public int getMQuestionId() {
        return MQuestionId;
    }

    public void setMQuestionId(int MQuestionId) {
        this.MQuestionId = MQuestionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
