package j3a;

import java.util.Arrays;

public class ColourTable {

    private int paramAmount;
    private int[][] cPalette;



    public ColourTable (int paramAmount){
        if (!correctPaletteSize(paramAmount)) {
            throw new IllegalArgumentException("Incorrect palette size. It must be a power of two, > 1, and < 1025.");
        }
        this.paramAmount = paramAmount;
        this.cPalette = new int[paramAmount][3];

    }

    public void add(int[] checkColour) {
        if (!validColour(checkColour)) {
            throw new IllegalArgumentException("Invalid RGB color. Each component must be in the range [0, 255].");
        }
    }

    public boolean correctPaletteSize(int paramAmount) {
        return paramAmount > 1 && paramAmount < 1025 && (paramAmount & (paramAmount - 1)) == 0;
    }

    public boolean validColour(int[] checkColour) {
        return Arrays.stream(checkColour).allMatch(a -> a >= 0 && a <= 255);
    }
}
