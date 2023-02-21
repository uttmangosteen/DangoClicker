package io.github.uttmangosteen.dangoclicker;

import java.math.BigInteger;

public class PlayerData {
    public BigInteger stock, DPC, DPS, amountCursor, priseCursor, amountGrandma, priseGrandma, amountFactory, priseFactory, amountMine, priseMine, amountShipment, priseShipment, amountAlchemyLab, priseAlchemyLab, amountPortal, prisePortal, amountTimeMachine, priseTimeMachine;
    public PlayerData(BigInteger stock, BigInteger dpc, BigInteger dps, BigInteger amountCursor, BigInteger priseCursor, BigInteger amountGrandma, BigInteger priseGrandma, BigInteger amountFactory, BigInteger priseFactory, BigInteger amountMine, BigInteger priseMine, BigInteger amountShipment, BigInteger priseShipment, BigInteger amountAlchemyLab, BigInteger priseAlchemyLab, BigInteger amountPortal, BigInteger prisePortal, BigInteger amountTimeMachine, BigInteger priseTimeMachine){
        this.stock = stock;
        this.DPC = dpc;
        this.DPS = dps;
        this.amountCursor = amountCursor;
        this.priseCursor = priseCursor;
        this.amountGrandma = amountGrandma;
        this.priseGrandma = priseGrandma;
        this.amountFactory = amountFactory;
        this.priseFactory = priseFactory;
        this.amountMine = amountMine;
        this.priseMine = priseMine;
        this.amountShipment = amountShipment;
        this.priseShipment = priseShipment;
        this.amountAlchemyLab = amountAlchemyLab;
        this.priseAlchemyLab = priseAlchemyLab;
        this.amountPortal = amountPortal;
        this.prisePortal = prisePortal;
        this.amountTimeMachine = amountTimeMachine;
        this.priseTimeMachine = priseTimeMachine;
    }
}
