<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <h1 style="color:blue;text-align:center"> Result page </h1>
    
    <b>Crickters Profile Information </b>  <br>
        name :: ${profile.nickname }  <br>
        country :: ${profile.country }  <br>
         Id :: ${profile.cricketerId }  <br>
        fullname :: ${profile.fullName }  <br>
         address:: ${profile.addrs }  <br>
        innigs count :: ${profile.innigsCount }  <br>
         mathes count:: ${profile.matchesCount }  <br>
        runs :: ${profile.runs }  <br>
         wicketes count :: ${profile.wicketsCount }  <br>
        DOB :: ${profile.dob }  <br>
        batting avg :: ${profile.battingAvg }  <br>
        bowling avg :: ${profile.bowlingAvg }  <br>
         status :: ${profile.status }  <br>
         <br>
          <a href="get_crickter_details.html">home</a>
        
        
