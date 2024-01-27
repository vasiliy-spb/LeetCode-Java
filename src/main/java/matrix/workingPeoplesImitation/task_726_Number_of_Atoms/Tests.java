package matrix.workingPeoplesImitation.task_726_Number_of_Atoms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();

    @Test
    public void checkTestcase1() {
        String formula = "H2O";
        String expected = "H2O";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

    @Test
    public void checkTestcase2() {
        String formula = "Mg(OH)2";
        String expected = "H2MgO2";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

    @Test
    public void checkTestcase3() {
        String formula = "K4(ON(SO3)2)2";
        String expected = "K4N2O14S4";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

    @Test // Time Limit Exceeded
    public void checkTestcase4() { // 24 / 32 testcases passed
        String formula = "(((U42Se42Fe10Mc31Rh49Pu49Sb49)49V39Tm50Zr44Og6)33((W2Ga48Tm14Eu46Mt12)23(RuRnMn11)7(Yb15Lu34Ra19CuTb2)47(Md38BhCu48Db15Hf12Ir40)7CdNi21(Db40Zr24Tc27SrBk46Es41DsI37Np9Lu16)46(Zn49Ho19RhClF9Tb30SiCuYb16)15)37(Cr48(Ni31)25(La8Ti17Rn6Ce35)36(Sg42Ts32Ca)37Tl6Nb47Rh32NdGa18Cm10Pt49(Ar37RuSb30Cm32Rf28B39Re7F36In19Zn50)46)38(Rh19Md23No22PoTl35Pd35Hg)41)50";
        String expected = "Ar3233800B3408600Bh12950Bk3914600Ca70300Cd1850Ce2394000Cl27750Cm2815800Cr91200Cu736300Db3598250Ds85100Es3489100Eu1957300F3396150Fe808500Ga2076600Hf155400Hg2050Ho527250I3148700In1660600Ir518000La547200Lu4317900Mc2506350Md539250Mn142450Mt510600Nb89300Nd1900Ni1511350No45100Np765900Og9900Pd71750Po2050Pt93100Pu3961650Ra1652050Re611800Rf2447200Rh4089150Rn423350Ru100350Sb6583650Se3395700Sg2952600Si27750Sr85100Tb1006400Tc2297700Ti1162800Tl83150Tm678200Ts2249600U3395700V64350W85100Yb1748250Zn5729750Zr2115000";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

    @Test
    public void checkTestcase5() { // 15 / 32 testcases passed
        String formula = "((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14";
        String expected = "B18900Be18984C4200H5446He1386Li33894N50106O22638";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

    @Test
    public void checkTestcase6() { // 29 / 32 testcases passed
        String formula = "(H)";
        String expected = "H";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

    @Test
    public void checkTestcase7() { // 30 / 32 testcases passed
        String formula = "Mg(H2O)N";
        String expected = "H2MgNO";
        assertEquals(expected, testingClass.countOfAtoms(formula));
    }

}
