package nl.visser.joram.mathapp;

import android.os.CountDownTimer;

public abstract class CustomTimer {

    private CountDownTimer cdt;
    private long millisInFuture;
    private long countDownInterval;

    public CustomTimer(long millisInFuture, long countDownInterval) {
        this.millisInFuture = millisInFuture;
        this.countDownInterval = countDownInterval;

        recreateCounter(millisInFuture, countDownInterval);
    }

    public abstract void onFinish();

    public abstract void onTick(long millisUntilFinished);

    public void start(){
        cdt.start();
    }

    private void setMillisInFuture(long millisInFuture){
        this.millisInFuture = millisInFuture;
    }

    public void onIncrement(long millis){
        millisInFuture += millis;
        recreateCounter(millisInFuture, countDownInterval);
    }

    private void recreateCounter(long millisInFuture, long countDownInterval){
        if(cdt != null){
            try {
                cdt.cancel();
            } catch (Exception e) {
            }
        }

        cdt = new CountDownTimer(millisInFuture, countDownInterval) {

            @Override
            public void onTick(long millisUntilFinished) {
                setMillisInFuture(millisUntilFinished);
                CustomTimer.this.onTick(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                CustomTimer.this.onFinish();
            }
        };

    }
}



