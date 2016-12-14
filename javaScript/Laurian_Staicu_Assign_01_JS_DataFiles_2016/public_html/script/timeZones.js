/*
 JavaScript & AJAX Assignment 01 
 Developed By: Laurian Staicu 
 Developed Date:   L13 dec 2016
 
 Function List:
 addTime(oldtime, milliseconds)
 Used to add a specified number of milliseconds to a date object named oldtime.
 A new date object with the new time value is returned by the function.
 
 showTime(time)
 Displays a time value in the format:
 hh:mm AM/PM
 */


function addTime(oldTime, milliseconds) {
    var newTime = new Date();
    var newValue = oldTime.getTime() + milliseconds;

    newTime.setTime(newValue);


    return newTime;
}

function showTime(time){
    //hour:minute AM/PM 12h format
    var thisMinute = time.getMinutes();
    var thisHour = time.getHours();

    //change this hour from 24 hour time format to 12 hour time by
    //1) if this hour is less than 12 , then set ampm to "pm"
    //otherwise set it to "pm"

    var ampm = (thisHour < 12) ? "AM" : "PM";
    //2) substract 12 from thisHour

    thisHour = (thisHour > 12) ? (thisHour - 12) : thisHour;

    //3) if this hour equals zero, change it to 12

    thisHour = (thisHour === 0) ? 12 : thisHour;
    //add leading zeros to the minutes and seconds less than 10
    thisMinute = (thisMinute < 10) ? ("0" + thisMinute) : thisMinute;

    return thisHour + ":" + thisMinute + ":" + ampm;
    
}


