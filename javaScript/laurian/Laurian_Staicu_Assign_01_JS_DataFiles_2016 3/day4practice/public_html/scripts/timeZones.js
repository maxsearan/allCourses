/*
   JavaScript & AJAX Assignment 01 
   Developed By: Elmira Amanollahi  
   Developed Date:    

   Function List:
   addTime(oldTime, milliseconds)
      Used to add a specified number of milliseconds to a date object named oldtime.
      A new date object with the new time value is returned by the function.
      var newTime;
      var newValue = oldTime.getTime() + milliSeconds.getTime();
      newTime = newValue.setTime();
      return ( newTime );

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


function showTime(time) {
    var thisMinute = time.getMinutes();
    var thisHour = time.getHours();
    var ampm = (thisHour < 12) ? " AM" : " PM";
    thisHour = (thisHour > 12) ? (thisHour - 12) : thisHour;
    thisHour = (thisHour === 0) ? 12 : thisHour;
    thisMinute = (thisMinute < 10) ? ("0" + thisMinute) : thisMinute;
    return thisHour + ":" + thisMinute + ampm;
}


