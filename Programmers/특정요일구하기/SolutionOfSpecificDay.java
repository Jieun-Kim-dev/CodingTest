class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        int totalDay = 0;
        for(int month = 1; month < a; month++) {
            totalDay += dayOfMonth(month);
        }
        
        totalDay += b;
        
        switch(totalDay % 7) {
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
            case 0:
                answer = "THU";
                break;
            default:
                break;
        }
        
        return answer;
    }
    
    private int dayOfMonth(int month) {
        int day;
        if(month == 2) {
            day = 29;
        } else if(month == 1 || month == 3 || month == 5 || month == 7 
                  || month == 8 || month == 10 || month == 12) {
            day = 31;
        } else {
            day = 30;
        }
        return day;
    }
}