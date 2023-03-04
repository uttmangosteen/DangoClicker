package io.github.uttmangosteen.dangoclicker;

import java.math.BigInteger;

public class PlayerData {
    public BigInteger stock, dPS, dPC;
    public BigInteger[] priceBuilding, dPSBuilding;
    public int[] amountBuilding, powerBuilding;
    public PlayerData(BigInteger stock, BigInteger dPS, BigInteger dPC, BigInteger[] priceBuilding, BigInteger[] dPSBuilding, int[] amountBuilding, int[] powerBuilding) {
        this.stock = stock;
        this.dPS = dPS;
        this.dPC = dPC;
        this.priceBuilding = priceBuilding;
        this.dPSBuilding = dPSBuilding;
        this.amountBuilding = amountBuilding;
        this.powerBuilding = powerBuilding;
    }
}