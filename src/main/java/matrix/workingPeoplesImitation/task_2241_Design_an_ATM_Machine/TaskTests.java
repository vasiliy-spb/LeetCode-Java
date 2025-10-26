package matrix.workingPeoplesImitation.task_2241_Design_an_ATM_Machine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TaskTests {
    @Test
    public void checkTestcase01() {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 0, 1, 2, 1});
        int[] cash = atm.withdraw(600);
        assertArrayEquals(new int[]{0, 0, 1, 0, 1}, cash);
        atm.deposit(new int[]{0, 1, 0, 1, 1});
        cash = atm.withdraw(600);
        assertArrayEquals(new int[]{-1}, cash);
        cash = atm.withdraw(550);
        assertArrayEquals(new int[]{0, 1, 0, 0, 1}, cash);
    }

    @Test
    public void checkTestcase02() {
        ATM atm = new ATM();
        atm.deposit(new int[]{0, 10, 0, 3, 0});
        int[] cash = atm.withdraw(500);
        assertArrayEquals(new int[]{0, 2, 0, 2, 0}, cash);
    }

    @Test
    public void checkTestcase03() {
        ATM atm = new ATM();
        atm.deposit(new int[]{250796, 638723, 691758, 845522, 938973});
        atm.deposit(new int[]{215317, 848628, 182949, 784609, 30472});

        int[] cash = atm.withdraw(701035245);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(109992310);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(755819795);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(722349970);
        assertArrayEquals(new int[]{1, 1, 0, 1188137, 969445}, cash);

        atm.deposit(new int[]{678816, 841145, 503892, 325349, 204606});
        atm.deposit(new int[]{604328, 586349, 680353, 733891, 136713});
        atm.deposit(new int[]{500950, 53467, 775875, 469508, 668335});
        atm.deposit(new int[]{178876, 500427, 867418, 738121, 80412});

        cash = atm.withdraw(824714410);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(374969115);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(351532175);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(732076765);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{208564, 707512, 566329, 300547, 313109});

        cash = atm.withdraw(774911195);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{742897, 902293, 512670, 863273, 105945});

        cash = atm.withdraw(449705540);
        assertArrayEquals(new int[]{2, 0, 0, 0, 899411}, cash);

        atm.deposit(new int[]{94829, 872976, 822744, 630565, 726268});

        cash = atm.withdraw(981495000);
        assertArrayEquals(new int[]{0, 0, 1, 1567532, 1335977}, cash);

        cash = atm.withdraw(426983925);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(591589125);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(90436530);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(300789750);
        assertArrayEquals(new int[]{0, 1, 1, 1503948, 0}, cash);

        cash = atm.withdraw(544232655);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{333998, 671859, 821084, 678512, 239841});

        cash = atm.withdraw(816423815);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(393272210);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{146335, 604905, 570672, 384321, 645355});

        cash = atm.withdraw(184328925);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(189043175);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{403571, 361640, 202265, 108809, 340899});

        cash = atm.withdraw(630857120);
        assertArrayEquals(new int[]{1, 0, 0, 89048, 1226095}, cash);

        cash = atm.withdraw(521903750);
        assertArrayEquals(new int[]{0, 1, 190313, 2514362, 0}, cash);

        atm.deposit(new int[]{309733, 543710, 227714, 682033, 689707});

        cash = atm.withdraw(409081030);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{140651, 880799, 664632, 684067, 189015});
        atm.deposit(new int[]{653204, 683646, 273200, 738271, 768502});

        cash = atm.withdraw(760807085);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{585693, 749948, 134852, 936077, 496241});

        cash = atm.withdraw(598212970);
        assertArrayEquals(new int[]{1, 1, 0, 2, 1196425}, cash);

        cash = atm.withdraw(609144120);
        assertArrayEquals(new int[]{1, 0, 1, 678120, 947040}, cash);

        cash = atm.withdraw(173711145);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(871970745);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{905672, 917631, 538045, 213759, 467121});
        atm.deposit(new int[]{84394, 842857, 110657, 83685, 396409});

        cash = atm.withdraw(283842105);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{547660, 711399, 37793, 248979, 171209});
        atm.deposit(new int[]{721908, 683510, 507961, 315580, 915329});
        atm.deposit(new int[]{724268, 208639, 86180, 559536, 369337});
        atm.deposit(new int[]{18276, 789197, 268868, 573790, 51430});

        cash = atm.withdraw(666573505);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(402867945);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(141646455);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(989327245);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(63547525);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(793492260);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(469750915);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{514958, 777169, 647876, 692862, 13212});

        cash = atm.withdraw(134587615);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{698672, 953618, 770724, 795084, 787545});
        atm.deposit(new int[]{381744, 405569, 839476, 243652, 173030});
        atm.deposit(new int[]{371633, 758052, 510149, 114478, 847007});

        cash = atm.withdraw(210704305);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{519428, 519225, 244531, 859848, 501054});
        atm.deposit(new int[]{447308, 71049, 586248, 739061, 22236});
        atm.deposit(new int[]{480462, 388981, 61696, 465612, 585484});
        atm.deposit(new int[]{337913, 996104, 569476, 144324, 941825});

        cash = atm.withdraw(875707660);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(57569050);
        assertArrayEquals(new int[]{0, 1, 0, 0, 115138}, cash);

        cash = atm.withdraw(313791115);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{495361, 267828, 569079, 266649, 318023});

        cash = atm.withdraw(910215005);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{11564, 454722, 326554, 617698, 951649});

        cash = atm.withdraw(737599780);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{459779, 367480, 721883, 267540, 616449});

        cash = atm.withdraw(416183255);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{919244, 501903, 797594, 255088, 277900});
        atm.deposit(new int[]{544488, 760, 373644, 587808, 462016});

        cash = atm.withdraw(542186870);
        assertArrayEquals(new int[]{1, 1, 1, 1, 1084373}, cash);

        atm.deposit(new int[]{141787, 245536, 713162, 249389, 360758});
        atm.deposit(new int[]{448335, 140890, 944469, 820805, 953212});
        atm.deposit(new int[]{83472, 483020, 89382, 734004, 496270});
        atm.deposit(new int[]{355454, 592701, 579669, 600758, 935825});
        atm.deposit(new int[]{509278, 123040, 366474, 967560, 94569});
        atm.deposit(new int[]{814617, 106257, 843008, 148633, 281962});

        cash = atm.withdraw(92776780);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(710233240);
        assertArrayEquals(new int[]{2, 0, 0, 1, 1420466}, cash);

        atm.deposit(new int[]{540287, 779680, 232597, 843398, 982588});

        cash = atm.withdraw(943887435);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(83641580);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{641807, 238897, 514709, 878576, 185671});
        atm.deposit(new int[]{788165, 163263, 468077, 187322, 741170});
        atm.deposit(new int[]{403619, 495280, 682590, 976711, 662733});
        atm.deposit(new int[]{790416, 971353, 997540, 833823, 438455});
        atm.deposit(new int[]{519889, 768434, 1186, 576547, 159969});
        atm.deposit(new int[]{87541, 987828, 423814, 667020, 113391});

        cash = atm.withdraw(739876825);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(380847695);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{127434, 690184, 220342, 251031, 510668});

        cash = atm.withdraw(736450270);
        assertArrayEquals(new int[]{1, 1, 0, 1, 1472900}, cash);

        cash = atm.withdraw(660460695);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{674760, 193528, 502970, 437004, 476214});
        atm.deposit(new int[]{624107, 419876, 767550, 454735, 284487});
        atm.deposit(new int[]{362461, 226745, 880847, 364186, 203497});

        cash = atm.withdraw(102135095);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{187479, 420361, 4452, 558218, 944230});

        cash = atm.withdraw(121284120);
        assertArrayEquals(new int[]{1, 0, 1, 0, 242568}, cash);

        atm.deposit(new int[]{109227, 412189, 999147, 755248, 350021});
        atm.deposit(new int[]{698704, 927765, 231972, 325370, 183792});

        cash = atm.withdraw(380738930);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(496198165);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(119768090);
        assertArrayEquals(new int[]{2, 1, 0, 0, 239536}, cash);

        atm.deposit(new int[]{907559, 446837, 965002, 40373, 684480});

        cash = atm.withdraw(26609515);
        assertArrayEquals(new int[]{-1}, cash);

        atm.deposit(new int[]{482552, 665813, 947214, 295057, 531240});
        atm.deposit(new int[]{996330, 771481, 324291, 338518, 643748});
        atm.deposit(new int[]{765310, 513263, 973288, 667581, 27556});
    }

    @Test
    public void checkTestcase03mini() {
        ATM atm = new ATM();
        atm.deposit(new int[]{250796, 638723, 691758, 845522, 938973});
        atm.deposit(new int[]{215317, 848628, 182949, 784609, 30472});

        int[] cash = atm.withdraw(701035245);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(109992310);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(755819795);
        assertArrayEquals(new int[]{-1}, cash);

        cash = atm.withdraw(722349970);
        assertArrayEquals(new int[]{1, 1, 0, 1188137, 969445}, cash);
    }
}
