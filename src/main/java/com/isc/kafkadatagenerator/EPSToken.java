package com.isc.kafkadatagenerator;

class EPSToken {
    private int tokenCount;
    private int messageKey;
    private boolean finished;

    public EPSToken() {
        tokenCount = 0;
        messageKey = 0;
        finished = false;
    }
    public synchronized void increaseTokens(int tokenNumber) { tokenCount += tokenNumber; }

    public synchronized boolean takeToken() {
        if(tokenCount != 0) {
            tokenCount--;
            return true;
        }
        return false;
    }

    public boolean complete() {
        if(getTokenCount() == 0 && getFinished() == true) { return true; }
        else {return false; }
    }
    public synchronized void toggleFinished() { finished = !finished; }
    public synchronized int getTokenCount() { return tokenCount; }
    public synchronized int getMessageKeyAndInc() { return ++messageKey; }
    public synchronized int getMessageKey() { return messageKey; }
    public synchronized boolean getFinished() { return finished; }
}