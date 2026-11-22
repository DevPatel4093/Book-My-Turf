package com.bookmyturf.app.data;
public class Turf {
 public final String id,name,area,sports,description; public final int pricePerHour; public final double rating;
 public Turf(String id,String name,String area,String sports,int pricePerHour,double rating,String description){this.id=id;this.name=name;this.area=area;this.sports=sports;this.pricePerHour=pricePerHour;this.rating=rating;this.description=description;}
}
