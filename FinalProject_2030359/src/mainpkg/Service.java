/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author apurb
 */
class Service {
    private int Serviceid, Quantity;
    private String Servicename, Description;
    private LocalDate ExpireDate;
    private float price;

    public Service() {
    }

    public Service(int Serviceid, int Quantity, String Servicename, String Description, LocalDate ExpireDate, float price) {
        this.Serviceid = Serviceid;
        this.Quantity = Quantity;
        this.Servicename = Servicename;
        this.Description = Description;
        this.ExpireDate = ExpireDate;
        this.price = price;
    }

    public int getServiceid() {
        return Serviceid;
    }

    public void setServiceid(int Serviceid) {
        this.Serviceid = Serviceid;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getServicename() {
        return Servicename;
    }

    public void setServicename(String Servicename) {
        this.Servicename = Servicename;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public LocalDate getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(LocalDate ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Serviceid : " + Serviceid + " , Quantity : " + Quantity + " , Servicename : " + Servicename + " , Description : " + Description + " , ExpireDate : " + ExpireDate + " , price : " + price + "\n";
    }
}

