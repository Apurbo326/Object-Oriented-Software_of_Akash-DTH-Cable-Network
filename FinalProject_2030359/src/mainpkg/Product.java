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
class Product {
    private int Productid, Quantity;
    private String Productname, Description;
    private LocalDate ExpireDate;
    private float price;

    public Product() {
    }

    public Product(int Productid, int Quantity, String Productname, String Description, LocalDate ExpireDate, float price) {
        this.Productid = Productid;
        this.Quantity = Quantity;
        this.Productname = Productname;
        this.Description = Description;
        this.ExpireDate = ExpireDate;
        this.price = price;
    }

    public int getProductid() {
        return Productid;
    }

    public void setProductid(int Productid) {
        this.Productid = Productid;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String Productname) {
        this.Productname = Productname;
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
        return "Productid : " + Productid + " , Quantity : " + Quantity + " , Productname : " + Productname + " , Description : " + Description + " , ExpireDate : " + ExpireDate + " , price : " + price + "\n";
    }
}
