import java.util.Arrays;
import java.util.stream.Collectors;

public enum Months {
    JANUARY(31,Season.WINTER),
    FEBRUARY(28, Season.WINTER),
    MARCH(31,Season.SPRING),
    APRIL(30,Season.SPRING),
    MAY(31, Season.SPRING),
    JUNE(30, Season.SUMMER),
    JULY(31, Season.SUMMER),
    AUGUST(30, Season.SUMMER),
    SEPTEMBER(31,Season.AUTUMN),
    OCTOBER(30, Season.AUTUMN),
    NOVEMBER(31, Season.AUTUMN),
    DECEMBER(30,Season.WINTER);

    private int days;
    private Season season;

    Months(int days, Season season) {
        this.days = days;
        this.season = season;
    }

    public int getDays() {
        return days;
    }

    public Season getSeason() {
        return season;
    }

    public static Months getMonth(String month){
        return Arrays.stream(Months.values()).filter(
                m -> m.name().equalsIgnoreCase(month)).findFirst().
                orElseThrow(
                        () -> new RuntimeException(
                                String.format(
                                        "Enum Months does not support: '%s' month,\nsupported months: %s",
                                        month,
                                        Arrays.stream(Months.values()).map(Months::name).collect(Collectors.toList()))));

    }
}
