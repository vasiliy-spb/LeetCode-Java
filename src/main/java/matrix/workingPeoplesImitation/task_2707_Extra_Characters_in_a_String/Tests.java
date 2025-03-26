package matrix.workingPeoplesImitation.task_2707_Extra_Characters_in_a_String;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {
    private final Solution testingClass = new Solution();
//    private final Solution2 testingClass = new Solution2();

    @Test
    public void checkTestcase01() {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        int expected = 1;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase02() {
        String s = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int expected = 3;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase03() {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = {"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"};
        int expected = 7;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase04() {
        String s = "ecolloycollotkvzqpdaumuqgs";
        String[] dictionary = {"flbri", "uaaz", "numy", "laper", "ioqyt", "tkvz", "ndjb", "gmg", "gdpbo", "x", "collo", "vuh", "qhozp", "iwk", "paqgn", "m", "mhx", "jgren", "qqshd", "qr", "qpdau", "oeeuq", "c", "qkot", "uxqvx", "lhgid", "vchsk", "drqx", "keaua", "yaru", "mla", "shz", "lby", "vdxlv", "xyai", "lxtgl", "inz", "brhi", "iukt", "f", "lbjou", "vb", "sz", "ilkra", "izwk", "muqgs", "gom", "je"};
        int expected = 2;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase05() {
        String s = "nwlztjn";
        String[] dictionary = {"a", "f", "v", "me", "m", "bv", "g", "ss", "tu", "jm", "z", "kg", "l", "go", "cn", "uj", "kx", "w", "qz", "e", "ut", "tf", "zn", "ha", "ke", "af", "aj", "ls", "r", "no", "pm", "qn", "yw", "cs", "oz", "b"};
        int expected = 4;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase06() {
        String s = "kbmguskrhhfejwrizbbwplpdeaztvpeemc";
        String[] dictionary = {"fil", "sjkwc", "fd", "rgex", "rjnzg", "gyxcr", "ahahm", "twpl", "bffkb", "mugap", "w", "kbsp", "dh", "iy", "kxzcd", "b", "wpn", "hfejw", "uskr", "nfa", "kos", "h", "muky", "pl", "yqabj", "oazr", "emw", "pde", "ile", "f", "ztv", "gt", "wx", "emc", "v", "iomk", "ljrnk", "blc", "se", "k", "nnna", "perc", "ojkz", "jen"};
        int expected = 8;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase07() {
        String s = "kevlplxozaizdhxoimmraiakbak";
        String[] dictionary = {"yv", "bmab", "hv", "bnsll", "mra", "jjqf", "g", "aiyzi", "ip", "pfctr", "flr", "ybbcl", "biu", "ke", "lpl", "iak", "pirua", "ilhqd", "zdhx", "fux", "xaw", "pdfvt", "xf", "t", "wq", "r", "cgmud", "aokas", "xv", "jf", "cyys", "wcaz", "rvegf", "ysg", "xo", "uwb", "lw", "okgk", "vbmi", "v", "mvo", "fxyx", "ad", "e"};
        int expected = 9;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }

    @Test
    public void checkTestcase08() {
        String s = "metzeaencgpgvsckjrqafkxgyzbe";
        String[] dictionary = {"zdzz", "lgrhy", "r", "ohk", "zkowk", "g", "zqpn", "anoni", "ka", "qafkx", "t", "jr", "xdye", "mppc", "bqqb", "encgp", "yf", "vl", "ctsxk", "gn", "cujh", "ce", "rwrpq", "tze", "zxhg", "yzbe", "c", "o", "hnk", "gv", "uzbc", "xn", "kk", "ujjd", "vv", "mxhmv", "ugn", "at", "kumr", "ensv", "x", "uy", "gb", "ae", "jljuo", "xqkgj"};
        int expected = 5;
        assertEquals(expected, testingClass.minExtraChar(s, dictionary));
    }
}
