public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year){
        if(year < 1 || year > 9999){
            return false;
        }
        boolean hold = false;
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 ==0){
                    hold = true;
                }
            }
            else{
                hold = true;
            }
        }
        return hold;
    }
    public static int getDaysInMonth(int month , int year){
        int days;
        if((month < 1 || month >12) || (year < 1 || year > 9999)){
            return -1;
        }
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 2:
                boolean hold = isLeapYear(year);
                if(hold == true){
                    days = 29;
                    break;
                }
                days = 28;
                break;
            default:
                days = 30;
        }
        return days;
    }
}
