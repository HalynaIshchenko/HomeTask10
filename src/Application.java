import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    /*
    Написати консольну програму для роботи з Enums.
Створити енум Сезони, в якому оголосити такі константи : Зима , Весна, Літо, Осінь.
Створити енум Місяці, в якому створити 12 констант- місяці року(Січень , Лютий.. Грудень ), оголосити змінну дні, та змінну сезон типу Сезон , як поле енума . Створити конструктор з визначеними параметрами в енумі Місяці, в який як параметри передати змінну дні та сезон.
Описати getters до даних полів (дні, сезони). Створити консольне меню, в якому реалізувати наступні пункти :
- Перевірити чи є такий місяць (місяць вводимо з консолі, передбачити, щоб регістр
букв був не важливим ).
- Вивести всі місяці з такою ж порою року.
- Вивести всі місяці які мають таку саму кількість днів.
- Вивести на екран всі місяці які мають меншу кількість днів.
- Вивести на екран всі місяці які мають більшу кількість днів.
- Вивести на екран наступну пору року.
- Вивести на екран попередню пору року.
- Вивести на екран всі місяці які мають парну кількість днів.
- Вивести на екран всі місяці які мають непарну кількість днів.
- Вивести на екран чи введений з консолі місяць має парну кількість днів.
     */


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month:");
        String month = sc.next();
        // - Перевірити чи є такий місяць (місяць вводимо з консолі, передбачити, щоб регістр букв був не важливим ).
        Months foundMonth = Months.getMonth(month);
        System.out.printf("found the month: %s\n", foundMonth);
        // Вивести всі місяці з такою ж порою року.
        Season foundMonthSeason = foundMonth.getSeason();
        System.out.printf("\nfound the months: %s by the season: %s",
                Arrays.stream(
                        Months.values()).filter(
                        m -> m.getSeason().equals(foundMonthSeason)
                ).collect(Collectors.toList()),
                foundMonthSeason);
        // - Вивести всі місяці які мають таку саму кількість днів.
        int foundDaysInMonth = foundMonth.getDays();
        System.out.printf("\nfound the months: %s by the same days: %s",
                Arrays.stream(
                        Months.values()).filter(
                        m -> m.getDays() == foundDaysInMonth
                ).collect(Collectors.toList()),
                foundDaysInMonth);

        //- Вивести на екран всі місяці які мають меншу кількість днів.
        System.out.printf("\nfound the months: %s that has less: %s days",
                Arrays.stream(
                        Months.values()).filter(
                        m -> m.getDays() < foundDaysInMonth
                ).collect(Collectors.toList()),
                foundDaysInMonth);


        //  - Вивести на екран всі місяці які мають більшу кількість днів.
        System.out.printf("\nfound the months: %s that has more: %s days",
                Arrays.stream(
                        Months.values()).filter(
                        m -> m.getDays() > foundDaysInMonth
                ).collect(Collectors.toList()),
                foundDaysInMonth);

        //  - Вивести на екран наступну пору року.
        System.out.printf("\nfound the month: %s, has the season: %s, that has next season: %s",
                foundMonth,
                foundMonth.getSeason(),
                foundMonth.getSeason().getNextSeason());
        //  - Вивести на екран попередню пору року.
        System.out.printf("\nfound the month: %s, has the season: %s, that has previous season: %s",
                foundMonth,
                foundMonth.getSeason(),
                foundMonth.getSeason().getPreviousSeason());
        //  - Вивести на екран всі місяці які мають парну кількість днів.
        System.out.printf("\nfound the months that have an even number of days: %s",
                Arrays.stream(Months.values()).filter(m -> m.getDays() % 2 == 0).collect(Collectors.toList()));
        //  - Вивести на екран всі місяці які мають непарну кількість днів.
        System.out.printf("\nfound the months that have not even number of days: %s",
                Arrays.stream(Months.values()).filter(m -> m.getDays() % 2 == 1).collect(Collectors.toList()));

        //  - Вивести на екран чи введений з консолі місяць має парну кількість днів.
        final String msg = foundMonth.getDays() % 2 == 0
                ? String.format("\nfound the month: %s have even number of days: %s", foundMonth, foundMonth.getDays())
                : String.format("\nfound the month: %s have not even number of days: %s", foundMonth, foundMonth.getDays());
        System.out.println(msg);

    }
}
