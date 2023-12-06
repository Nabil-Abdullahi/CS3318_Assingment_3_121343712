package j3a;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
//    @Test
//    public void test
}
