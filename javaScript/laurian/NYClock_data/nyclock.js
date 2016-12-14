// JavaScript source code for new year Clock Web Page
/*1.showDate() - returns the currunt date in the format mm/dd/yyyy
 * 2. showTime() -  returns the currunt time in the format hh;mm;ss
 * 3.calcDays() - returns the current date and january 1st of the next year
 * 4. 
 * 
 * 
 * 
 * 
 */

//showdate() - retuns the curretn date in the format mm/dd/yyy
function showDate(dateObj) {
    //extract date parts
    var theDate = dateObj.getDate();

    var theMonth = dateObj.getMonth() + 1;

    var theYear = dateObj.getFullYear();


    return theMonth + "/" + theDate + "/" + theYear;


}

//* 2. showTime() -  returns the currunt time in the format hh;mm;ss
function showTime(dateObj) {
    var thisSecond = dateObj.getSeconds();
    var thisMinute = dateObj.getMinutes();
    var thisHour = dateObj.getHours();

    //change this hour from 24 hour time format to 12 hour time by
    //1) if this hour is less than 12 , then set ampm to "pm"
    //otherwise set it to "pm"

    var ampm = (thisHour < 12) ? "am" : "pm";
    //2) substract 12 from thisHour

    thisHour = (thisHour > 12) ? (thisHour - 12) : thisHour;

    //3) if this hour equals zero, change it to 12

    thisHour = (thisHour === 0) ? 12 : thisHour;
    //add leading zeros to the minutes and seconds less than 10
    thisMinute = (thisMinute < 10) ? ("0" + thisMinute) : thisMinute;
    thisSecond = (thisSecond < 10) ? ("0" + thisSecond) : thisSecond;

    return thisHour + ":" + thisMinute + ":" + thisSecond + " " + ampm;
} //end shoshowTime() function
// * 3.calcDays() - returns the currunt date and january 1st of the next year

function calcDays(currentDate) {
    
    //create a date object for January 1st of the next year
    var nextYear = currentDate.getFullYear() + 1;

    //Set the newYear to the nextYear
    //insert a temporary date from January 1 st
        var newYear = new Date("January 1,2017");

    
    //Set the newYear to the nextYear
    
    
    //newYear.setFullYear(nextYear);
    
    /* calculate the difference between the current date and January 1 st of the next year*/
    //convert the milliseconds to days
    var m2D = (1000*60*60*24);
    var theDays = (newYear - currentDate)/m2D;


    return theDays;
    
}
