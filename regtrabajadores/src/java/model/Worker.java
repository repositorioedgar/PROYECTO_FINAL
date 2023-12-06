package model;

import java.io.Serializable;

public class Worker implements Serializable{
    private String run;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double sueldoBase;
    private double afp;/*13%*/
    private double salud; /*7%*/
    private double sueldoLiquido;
    private int aguinaldo;
    public final int BONO_PRODUCCION = 30000;

    public Worker(String run, String nombre, String apellidoPaterno, String apellidoMaterno, double sueldoBase) {
        this.run = run;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.sueldoBase = sueldoBase;
        
        afp = sueldoBase * 0.13;
        salud =  sueldoBase * 0.07;
        sueldoLiquido = (sueldoBase + BONO_PRODUCCION - afp - salud);
        
        if(sueldoBase <= 200000){
            aguinaldo = 80000;
        }else if(sueldoBase > 200000 && sueldoBase <= 500000){
            aguinaldo = 40000;
        }else{
            aguinaldo = 5000;
        }
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getSueldoBase() {
        return (int)sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getAfp() {
        return (int)afp;
    }

    public void setAfp(double afp) {
        this.afp = afp;
    }

    public int getSalud() {
        return (int)salud;
    }

    public void setSalud(double salud) {
        this.salud = salud;
    }

    public int getSueldoLiquido() {
        return (int)sueldoLiquido;
    }

    public void setSueldoLiquido(double sueldoLiquido) {
        this.sueldoLiquido = sueldoLiquido;
    }

    public int getAguinaldo() {
        return aguinaldo;
    }

    public void setAguinaldo(int aguinaldo) {
        this.aguinaldo = aguinaldo;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "sueldoBase=" + sueldoBase + ", afp=" + getAfp() + ", salud=" + getSalud() + ", sueldoLiquido=" + getSueldoLiquido() + ", aguinaldo=" + getAguinaldo() + ", BONO_PRODUCCION=" + BONO_PRODUCCION + '}';
    }
    
    
    
//    public static void main(String[] args){
//        Trabajador t1, t2;
//        
//        t1 = new Trabajador(null, null, null, null, 100000);
//        t2 = new Trabajador(null, null, null, null, 600000);
//        
//        System.out.println(t2);
//    }
}
