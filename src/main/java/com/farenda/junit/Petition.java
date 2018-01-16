package com.farenda.junit;

public class Petition {
    private boolean signed;
    private boolean agreed;

    public void sign(boolean agreed) {
        signed = true;
        this.agreed = agreed;
    }

    public boolean isSigned() {
        return signed;
    }

    public boolean isAgreed() {
        return agreed;
    }
}
