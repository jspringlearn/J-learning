package Faceclass;

public class motorbike extends SpeedMeter{
    private double rad;
    public motorbike(double rad)
    {
        this.rad=rad;
    }
    public double calgirth(){
        return rad*2*Math.PI;
    }
    public static void main(String []arg ){
        motorbike mo=new motorbike(0.5);
        mo.setTurnRate(1000);
        System.out.println(mo.getspeed());
    }
}
