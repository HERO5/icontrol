package com.mrl.ai.baidu.asr.business;

public interface RecogListener {

    void onNluResult(String res);

    void onPartialResult(String res);

    void onFinalResult(String res);

    void onUnExcept(String res);
}
