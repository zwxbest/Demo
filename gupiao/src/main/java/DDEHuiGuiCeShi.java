import java.time.DayOfWeek;
import java.time.LocalDate;

public class DDEHuiGuiCeShi {

    public static void main(String[] args) {

        //10天内涨停次数等于2，3天内涨停次数等于2，
//        String template = "%s到%s的dde散户数量小于0的次数大于1，%s到%s换手率大于2%%的次数大于1,非st，主板，%s到%s主力增仓占比大于0%%的次数大于1,%s涨幅大于-11%%,%s最高涨幅大于-11%%";
        String template = "%s到%s的dde散户数量小于-10的次数大于2，%s到%s换手率大于2%%的次数大于1,非st，主板，%s到%s主力增仓占比大于0%%的次数大于1,%s涨幅大于-11%%,%s最高涨幅大于-11%%，上市天数大于300天";
//        String template = "%s涨幅小于9.95%%,%s到%s涨停次数等于2,%s开盘涨幅大于-2%%小于2%%,主板,非st,上市天数大于365天,%s实体涨幅大于-11%%,%s开盘涨幅大于-11%%,%s最高涨幅大于-11%%";


        LocalDate today = LocalDate.of(2021, 9, 16);
        today = getNearestWorkDay(today);

        LocalDate days15 = minusWorkDays(today,15);


        //3天前
        LocalDate days3 = minusWorkDays(today, 3);

        LocalDate yesterday = minusWorkDays(today, 1);


        LocalDate nextDay = plusWorkDays(today, 1);

        String days15str = days15.getMonthValue() + "月" + days15.getDayOfMonth() + "日";
        String days3Str = days3.getMonthValue() + "月" + days3.getDayOfMonth() + "日";
        String yesStr = yesterday.getMonthValue() + "月" + yesterday.getDayOfMonth() + "日";
        String todayStr = today.getMonthValue() + "月" + today.getDayOfMonth() + "日";
        String nextDayStr = nextDay.getMonthValue() + "月" + nextDay.getDayOfMonth() + "日";

        System.out.println(String.format(template, days3Str,yesStr, days3Str,yesStr,days3Str,yesStr,todayStr,todayStr));
    }

    private static LocalDate plusWorkDays(LocalDate date, int day) {

        int count = 0;
        while (true) {
            //如果是周六或者周日就跳过
            date = date.plusDays(1);
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY) {

            } else {
                count++;
            }
            if (count == day) {
                break;
            }
        }
        return date;

    }

    private static LocalDate getNearestWorkDay(LocalDate a) {
        while (true) {
            if (a.getDayOfWeek() == DayOfWeek.SUNDAY || a.getDayOfWeek() == DayOfWeek.SATURDAY) {
                a = a.minusDays(1);
            } else {
                break;
            }
        }
        return a;
    }

    private static LocalDate minusWorkDays(LocalDate date, int day) {

        int count = 0;
        while (true) {
            //如果是周六或者周日就跳过
            date = date.minusDays(1);
            if (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY) {

            } else {
                count++;
            }
            if (count == day) {
                break;
            }
        }
        return date;

    }
}
