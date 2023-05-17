package time;

import java.util.Date;

public class TimeUtils {
    public static boolean isTimeIntervalOver(Date createdOn, int sameSmsRepeatTime) {
        long diff = new Date().getTime() - (createdOn.getTime()-120000);
        System.out.println("Diff ==> "+diff);
        System.out.println("MOD ==> "+(60 * 1000) % 60);
        long dat = (diff/(60*1000))%60;
        System.out.println("ddddd i=i=> "+dat);
        long diffMinutes = diff / (60 * 1000) % 60;
        System.out.println("diffMinutes ==> "+diffMinutes);
        return diffMinutes > sameSmsRepeatTime;
    }
}
