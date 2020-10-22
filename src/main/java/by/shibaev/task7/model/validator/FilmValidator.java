package by.shibaev.task7.model.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilmValidator {
    private final static String NAME_PATTERN = "\\w{1,30}";
    private final static String PRODUCER_PATTERN = "\\w+\\s\\w+";
    private final static int MAX_YEAR = 2021;
    private final static int MIN_YEAR = 1900;

    public boolean isNameValid(String name){
        return Pattern.matches(NAME_PATTERN,name);
    }

    public boolean isProducerValid(String name){
        boolean result = Pattern.matches(PRODUCER_PATTERN,name);
        if (name.length() > 30){
            result = false;
        }
        return result;
    }

    public boolean isYearValid(String year){
        boolean result = true;
        try {
            int value= Integer.parseInt(year);
            if(value < MIN_YEAR || value > MAX_YEAR){
                result = false;
            }
        }catch (NumberFormatException e){
            result = false;
        }
        return result;
    }
}
