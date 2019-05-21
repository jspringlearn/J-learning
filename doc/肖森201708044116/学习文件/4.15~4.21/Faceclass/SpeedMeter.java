package Faceclass;

public abstract  class SpeedMeter {
    private double turnRate;  //转速
    public SpeedMeter(){};
    public abstract double calgirth();
    public void setTurnRate(double turnRate) {
        this.turnRate = turnRate;
    }
    public double getspeed()
    {
        return turnRate*calgirth();
    }
}
