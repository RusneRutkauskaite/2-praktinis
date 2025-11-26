package com.example.a2praktinis; // Pakeiskite paketą, jei reikia

import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

import com.google.firebase.firestore.util.Assert;

/**
 * Unit testai skirti Calculator klasei, padengiantys žodžių ir simbolių skaičiavimo funkcionalumą.
 */
public class CalculatorTest {

    // ====================================================================
    // 1. countCharacters(String text) testai
    // Testai padengia simbolių skaičiavimą (įskaitant tarpus).
    // ====================================================================

    @Test
    public void countCharacters_EmptyString_ReturnsZero() {
        // Tikrinama, ar tuščias String grąžina 0
        assertEquals(0, Calculator.countCharacters(""));
    }

    @Test
    public void countCharacters_Null_ReturnsZero() {
        // Tikrinama, ar null grąžina 0
        assertEquals(0, Calculator.countCharacters(null));
    }

    @Test
    public void countCharacters_NormalText_ReturnsCorrectCount() {
        // Tikrinama normalaus teksto su tarpu skaičiavimas
        // "Hello World" turi 11 simbolių (įskaitant tarpą)
        assertEquals(11, Calculator.countCharacters("Hello World"));
    }

    @Test
    public void countCharacters_OnlySpaces_ReturnsSpaceCount() {
        // Tikrinama, ar tarpai skaičiuojami kaip simboliai
        assertEquals(5, Calculator.countCharacters("     "));
    }

    @Test
    public void countCharacters_WithPunctuation_CountsAll() {
        // Tikrinama, ar skaičiuojami skirtukai
        assertEquals(18, Calculator.countCharacters("Kiek cia simboliu!"));
    }

    @Test
    public void countCharacters_LithuanianLetters_ReturnsCorrectCount() {
        // Tikrinama, ar lietuviškos raidės skaičiuojamos teisingai (kaip 1 simbolis)
        assertEquals(7, Calculator.countCharacters("Ąžuolai"));
    }


    // ====================================================================
    // 2. countWords(String text) testai
    // Testai padengia žodžių skaičiavimą.
    // ====================================================================

    @Test
    public void countWords_EmptyString_ReturnsZero() {
        // Tikrinama, ar tuščias String grąžina 0
        assertEquals(0, Calculator.countWords(""));
    }

    @Test
    public void countWords_Null_ReturnsZero() {
        // Tikrinama, ar null grąžina 0
        assertEquals(0, Calculator.countWords(null));
    }

    @Test
    public void countWords_NormalText_ReturnsCorrectCount() {
        // Normalus atvejis: 2 žodžiai
        assertEquals(2, Calculator.countWords("Labas rytas"));
    }

    @Test
    public void countWords_MultipleSpacesBetweenWords_ReturnsCorrectCount() {
        // Tikrinama, ar keli tarpai tarp žodžių skaičiuojami teisingai (turėtų būti 3 žodžiai)
        assertEquals(3, Calculator.countWords("Aš    esu  čia"));
    }

    @Test
    public void countWords_OnlySpaces_ReturnsZero() {
        // Tik tarpai neturi būti skaičiuojami kaip žodžiai
        assertEquals(0, Calculator.countWords("   "));
    }

    @Test
    public void countWords_LeadingAndTrailingSpaces_ReturnsCorrectCount() {
        // Tikrinama, ar tarpai pradžioje ir pabaigoje netrukdo skaičiuoti
        assertEquals(3, Calculator.countWords(" testuojame dabar   testą "));
    }

    // PASTABA: Jūsų implementacija split("\\s+") nenaudoja skirtukų (pvz., kablelių) kaip atskiriklių.
    // Ji skaičiuoja visą fragmentą su skirtuku kaip vieną žodį.
    // pvz. "žodis," bus skaičiuojamas kaip 1 žodis.

    @Test
    public void countWords_WithPunctuation_CountsPunctuationAsPartOfWord() {
        // Pagal Jūsų esamą kodą: "Kiek, čia; žodžių? yra!" bus 4 žodžiai, nes skirtukai nėra atskirikliai
        assertEquals(4, Calculator.countWords("Kiek, čia; žodžių? yra!"));
    }

    @Test
    public void countWords_OnlyPunctuation_ReturnsOneWord() {
        // Pagal Jūsų esamą kodą: ".,!?" yra ne tuščia eilutė po trim() ir bus laikoma 1 žodžiu
        // (nes split("\\s+") neatpažįsta skirtukų kaip atskiriklių)
        assertEquals(1, Calculator.countWords(".,!?"));
    }
}