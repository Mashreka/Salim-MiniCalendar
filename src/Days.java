import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.temporal.TemporalAdjusters;
public class Days {
    LocalDate today = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    DateTimeFormatter nameOfTheDays = DateTimeFormatter.ofPattern("EEEE");




    //crerating theinitiation of the days in a week panels
    public void getThisWeekDate(JPanel[] calendarPanels, JLabel[] calendarLabels){ // calendarPanels can be used or not, to initiate the place later on in the Calendar
        LocalDate startOfWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // You can change it into Tuesday or anything you like since it says it's an adjustment

        for (int i = 0; i < 7; i++) {
            LocalDate date = startOfWeek.plusDays(i); // to generate the days after monday forward, thats why we use plusDays
            String formattedDate = date.format(formatter); // You take the formatter from up above
            calendarLabels[i].setText(formattedDate); //calendarLabels are given to the bracket above, which will take the space for the Labels inside the GUI once its called

            if (date.equals(today)) {
                calendarLabels[i].setOpaque(true);
                calendarLabels[i].setBackground(Color.GREEN);
            } else {
                calendarLabels[i].setOpaque(false);
            }
        }
    }

    public void getThisWeekDaysOnly(JLabel[] nameOfTheDaysLabels){ // calendarPanels can be used or not, to initiate the place later on in the Calendar
        LocalDate startOfTheDay = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY)); // You can change it into Tuesday or anything you like since it says it's an adjustment

        for (int i = 0; i < 7; i++) {
            LocalDate date = startOfTheDay.plusDays(i);
            String dayName = date.format(nameOfTheDays);
            nameOfTheDaysLabels[i].setText(dayName);

            if (date.equals(today)) {
                nameOfTheDaysLabels[i].setOpaque(true);
                nameOfTheDaysLabels[i].setBackground(Color.GREEN);
            } else {
                nameOfTheDaysLabels[i].setOpaque(false);
            }
            /*LocalDate date = stratOfTheDay.plusDays(i); // to generate the days after monday forward, thats why we use plusDays
            String formattedDate = date.format(formatter); // You take the formatter from up above
            calendarLabels[i].setText(formattedDate); //calendarLabels are given to the bracket above, which will take the space for the Labels inside the GUI once its called

            if (date.equals(today)) {
                calendarLabels[i].setOpaque(true);
                calendarLabels[i].setBackground(Color.GREEN);
            } else {
                calendarLabels[i].setOpaque(false);
            }*/
        }

    }
    public LocalDate getStartOfWeek() {
        return today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
}