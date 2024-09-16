package NEGOCIO;

import java.util.Random;

public class Die {
    Random random = new Random();
    private int valueD20;
    private int valueD12;
    private int valueD100;
    private int valueD500;

    public Die() {
        this.valueD20 = random.nextInt(21);
        this.valueD12 = random.nextInt(13);
        this.valueD100=random.nextInt(101);
        this.valueD500 = random.nextInt(501);
    }

    public int getValueD20() {
        return valueD20;
    }

    public int getValueD12() {
        return valueD12;
    }

    public int getValueD100() {
        return valueD100;
    }
    public int getValueD500() {
        return valueD500;
    }
}
