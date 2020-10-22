package by.shibaev.task7.model.dao;

public class DataBaseRequest {

    public static final String ADD = "INSERT INTO film(title,producer,year) VALUES (?,?,?)";
    public static final String SELECT_ALL = "SELECT title,producer,year FROM film";

    private DataBaseRequest(){
    }
}
