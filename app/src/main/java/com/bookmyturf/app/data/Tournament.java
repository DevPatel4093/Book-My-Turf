package com.bookmyturf.app.data;
public class Tournament {
 public final String name,sport,venue,date; public final int playersPerTeam,maxTeams,entryFee,prizePool;
 public Tournament(String name,String sport,String venue,String date,int playersPerTeam,int maxTeams,int entryFee,int prizePool){this.name=name;this.sport=sport;this.venue=venue;this.date=date;this.playersPerTeam=playersPerTeam;this.maxTeams=maxTeams;this.entryFee=entryFee;this.prizePool=prizePool;}
}
