package j3a;

import java.util.Arrays;

public class ColourTable {
    private final int paramAmount; //amount of items in palette
    private final int[][] cPalette; // representing colour code



    public ColourTable (int paramAmount){
        if (!correctPaletteSize(paramAmount)) { //check to make sure palette is correct size
            throw new IllegalArgumentException("Incorrect palette size. It must be a power of two, > 1, and < 1025.");
        }
        this.paramAmount = paramAmount;
        this.cPalette = new int[paramAmount][3]; // giving palette colour the three attributes it needs to represent the colours

    }
    public void add(int[] checkColour) {
        if (!validColour(checkColour)) { // check to make sure the colour is valid according to the 3 colour code
            throw new IllegalArgumentException("Invalid RGB color. Each component must be in the range [0, 255].");
        }
        int ind = availability();
        if (ind != -1){
            cPalette[ind] = Arrays.copyOf(checkColour, checkColour.length);
        }
        else {
            throw new IllegalArgumentException("Past max capacity of ColourTable");
        }
        
    }

    public int availability() {
        for (int i =0; i < paramAmount; i++){
            if (Arrays.equals(cPalette[i], new int[]{0, 0, 0})){
                return i;
            }
        }
        return -1;
    }

    public boolean correctPaletteSize(int paramAmount) {
        return paramAmount > 1 && paramAmount < 1025 && (paramAmount & (paramAmount - 1)) == 0; //check to make sure length of palette is greater than 1, less than 1025 and a multiple of 2
    }

    public boolean validColour(int[] checkColour) {
        return Arrays.stream(checkColour).allMatch(a -> a >= 0 && a <= 255); // check to make sure 3 colour code is in the range of 0 to 255
    }
}
