import java.util.stream.Stream;

import data.Person;

import static data.Person.someone;
import static java.time.LocalDate.now;
import static java.util.Comparator.comparing;

public class Main {

    public static void main(String[] args) {
        Stream<Person> people = Stream.of(
          someone().named("Bingo 1").born(now()).thisTall(1.80).weighing(100),
          someone().named("Bingo 2").born(now()).thisTall(1.80).weighing(90),
          someone().named("Bingo 3").born(now()).thisTall(1.90).weighing(80)
        );

        people.sorted(comparing(Person::name));


        // Predicate builder

        people
          .filter(
            by(Person::name).equalTo("Bingo 3")
            .and(Person::height).greaterThan(2)
            .and(Person::weight).lowerThan(300)
            .and(Person::married).equal(true)::filter
          );


        // Stream wrapper

        from(people)
          .find(by(Person::name).equalTo("Bingo 3")::filter) // find -> filter().findFirst()


        // Idiomatic Time Wrapper

        // date(50, years(), ago())

        // date.yearsAhead(50)

        // date(in(), 50, years())

        /* date(date -> date.in(50, years())) */

        /* date(date -> date.back(50, years())) */

        /*

           date(date -> date
             .range()
             .starting(start -> start.in(50).years())
             .ending(end -> end.in(5).years()
           )

           date(range -> range
             .starting(50, years())
             .ending(5, years())
           )

           date(range -> range
             .startingNow()
             .endingNow()
           )

         */

        // dateTime(50, years(), ago()).formattedAs("")

        // dateAt(50, years(), ago())
        // dateAt(50, years(), fromNow())
    }
}
