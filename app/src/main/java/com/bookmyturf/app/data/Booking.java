package com.bookmyturf.app.data;
public class Booking {
 public final String id,turfName,slots,status; public final int amount;
 public Booking(String id,String turfName,String slots,int amount,String status){this.id=id;this.turfName=turfName;this.slots=slots;this.amount=amount;this.status=status;}
}
