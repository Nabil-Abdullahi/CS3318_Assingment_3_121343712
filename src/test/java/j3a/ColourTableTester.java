package j3a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColourTableTester {
    @Test
    public void testNoOfColorInPaletteGood(){
        assertTrue(new ColourTable(2).correctPaletteSize(2));
        assertTrue(new ColourTable(1024).correctPaletteSize(1024));
    }
    @Test
    public void testNoOfColorInPaletteBad(){
        assertFalse(new ColourTable(5).correctPaletteSize(5));
        assertFalse(new ColourTable(1027).correctPaletteSize(1027));
    }
    @Test
    public void testColourIsValidSuccess(){
        ColourTable colourTable = new ColourTable(4);

        assertDoesNotThrow(()-> colourTable.add(new int[]{255,0,0})); // red
        assertDoesNotThrow(()-> colourTable.add(new int[]{0,255,0})); // green
        assertDoesNotThrow(()-> colourTable.add(new int[]{0,0,255})); // blue
        assertDoesNotThrow(()-> colourTable.add(new int[]{255,0,255})); //fuchsia
    }

    @Test
    public void testColourIsValidFail(){
        ColourTable colourTable = new ColourTable(4);

        assertDoesNotThrow(()-> colourTable.add(new int[]{-255,0,0})); // red
        assertDoesNotThrow(()-> colourTable.add(new int[]{0,-255,0})); // green
        assertDoesNotThrow(()-> colourTable.add(new int[]{0,0,-255})); // blue
        assertDoesNotThrow(()-> colourTable.add(new int[]{255,0,-255})); //fuchsia
    }
    @Test
    public void testColourBeingAddedS(){
        ColourTable colourTable = new ColourTable(4);
        
        assertDoesNotThrow(()-> colourTable.add(new int[]{255,0,0})); // red
        assertDoesNotThrow(()-> colourTable.add(new int[]{0,255,0})); // green
        assertDoesNotThrow(()-> colourTable.add(new int[]{0,0,255})); // blue
        assertDoesNotThrow(()-> colourTable.add(new int[]{255,0,255})); //fuchsia
    }
    @Test
    public void testColourBeingAddedF(){
        ColourTable colourTable = new ColourTable(2);

        colourTable.add(new int[]{255,0,0}); // red
        colourTable.add(new int[]{0,255,0}); // green
        colourTable.add(new int[]{0,0,255}); // blue
    }
}

