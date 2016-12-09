package com.mycompany.dambasquet;

public class Estadisticas {
    private String posicion;
    private int maxCanastas;
    private int minCanastas;
    private int sumaCanastas;
    private int total;
    private int maxAsistencias;
    private int minAsistencias;
    private int sumaAsistencias;
    private int maxRebotes;
    private int minRebotes;
    private int sumaRebotes;
    private double avgCanastas;
    private double avgAsistencias;
    private double avgRebotes;
    
    public Estadisticas(String posicion, int canastas, int asistencias, int rebotes) {
        this.posicion = posicion;
        this.maxCanastas = canastas;
        this.minCanastas = canastas;
        this.sumaCanastas = canastas;
        this.total = 1;
        this.maxAsistencias = asistencias;
        this.minAsistencias = asistencias;
        this.sumaAsistencias = asistencias;
        this.maxRebotes = rebotes;
        this.minRebotes = rebotes;
        this.sumaRebotes = rebotes;
        this.avgCanastas =  canastas;
        this.avgAsistencias = asistencias;
        this.avgRebotes = rebotes;
    }

    public double getAvgCanastas() {return avgCanastas; }
    public void setAvgCanastas(double avgCanastas) {this.avgCanastas = avgCanastas;}
    public double getAvgAsistencias() { return avgAsistencias; }
    public void setAvgAsistencias(double avgAsistencias) { this.avgAsistencias = avgAsistencias; }
    public double getAvgRebotes() {  return avgRebotes; }
    public void setAvgRebotes(double avgRebotes) { this.avgRebotes = avgRebotes;}
    public String getPosicion() {return posicion;}
    public void setPosicion(String posicion) {this.posicion = posicion;}
    public int getMaxCanastas() {return maxCanastas;}
    public void setMaxCanastas(int maxCanastas) {this.maxCanastas = maxCanastas;}
    public int getMinCanastas() {return minCanastas;}
    public void setMinCanastas(int minCanastas) {this.minCanastas = minCanastas;}
    public int getSumaCanastas() {return sumaCanastas;}
    public void setSumaCanastas(int sumaCanastas) {this.sumaCanastas = sumaCanastas;}
    public int getTotal() {return total;}
    public void setTotal(int total) { this.total = total;}
    public int getMaxAsistencias() {return maxAsistencias; }
    public void setMaxAsistencias(int maxAsistencias) { this.maxAsistencias = maxAsistencias;}
    public int getMinAsistencias() {return minAsistencias;}
    public void setMinAsistencias(int minAsistencias) { this.minAsistencias = minAsistencias;}
    public int getSumaAsistencias() {  return sumaAsistencias; }
    public void setSumaAsistencias(int sumaAsistencias) { this.sumaAsistencias = sumaAsistencias; }
    public int getMaxRebotes() {  return maxRebotes; }
    public void setMaxRebotes(int maxRebotes) { this.maxRebotes = maxRebotes;}
    public int getMinRebotes() {   return minRebotes;  }
    public void setMinRebotes(int minRebotes) { this.minRebotes = minRebotes; }
    public int getSumaRebotes() {   return sumaRebotes; }
    public void setSumaRebotes(int sumaRebotes) {  this.sumaRebotes = sumaRebotes;}
  
}
