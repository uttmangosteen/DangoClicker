package io.github.uttmangosteen.dangoclicker;

import org.bukkit.configuration.file.FileConfiguration;

import java.math.BigInteger;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Global {
    public static FileConfiguration config = Main.config.getConfig();
    public static ConcurrentHashMap<UUID, PlayerData> saveData = new ConcurrentHashMap<>();
    public static final BigInteger[] buildingStandardDPS = {BigInteger.valueOf(1), BigInteger.valueOf(10), BigInteger.valueOf(80), BigInteger.valueOf(470), BigInteger.valueOf(2600), BigInteger.valueOf(14000), BigInteger.valueOf(78000), BigInteger.valueOf(440000), BigInteger.valueOf(2600000), BigInteger.valueOf(16000000), BigInteger.valueOf(100000000), BigInteger.valueOf(650000000), BigInteger.valueOf(4300000000L), BigInteger.valueOf(29000000000L), BigInteger.valueOf(21000000000000L), BigInteger.valueOf(150000000000000L), BigInteger.valueOf(1100000000000000000L)};
    public static final BigInteger[] buildingStandardPrice = {BigInteger.valueOf(150), BigInteger.valueOf(1000), BigInteger.valueOf(11000), BigInteger.valueOf(120000), BigInteger.valueOf(1300000), BigInteger.valueOf(14000000), BigInteger.valueOf(200000000), BigInteger.valueOf(3300000000L), BigInteger.valueOf(51000000000L), BigInteger.valueOf(750000000000L), BigInteger.valueOf(10000000000000L), BigInteger.valueOf(140000000000000L), BigInteger.valueOf(1700000000000000L), BigInteger.valueOf(21000000000000000L), BigInteger.valueOf(2600000000000000000L), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(31)), BigInteger.valueOf(1000000000000000000L).multiply(BigInteger.valueOf(7100))};
    public static final BigInteger[] upGradeStandardPrice = {BigInteger.TEN, BigInteger.valueOf(50), BigInteger.valueOf(500), BigInteger.valueOf(50000), BigInteger.valueOf(5000000), BigInteger.valueOf(500000000), BigInteger.valueOf(500000000000L), BigInteger.valueOf(500000000000000L), BigInteger.valueOf(500000000000000000L), BigInteger.valueOf(5000000000000000000L).multiply(BigInteger.valueOf(100))};
    public static final BigInteger[] upGradeCursorPrice = {BigInteger.valueOf(1000), BigInteger.valueOf(5000), BigInteger.valueOf(100000), BigInteger.valueOf(1000000), BigInteger.valueOf(100000000), BigInteger.valueOf(1000000000), BigInteger.valueOf(10000000000L), BigInteger.valueOf(100000000000L), BigInteger.valueOf(100000000000000L), BigInteger.valueOf(1000000000000000L)};
    public static final int[] amountUnLockUpGrade = {1, 5, 25, 50, 100, 150, 200, 250, 300, 350};
    public static final int[] amountUnLockUpGradeCursor = {1, 1, 10, 25, 50, 100, 150, 200, 250, 300};

    public static boolean playable;

}

