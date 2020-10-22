package by.shibaev.task7.model.dao;

import by.shibaev.task7.model.entity.Film;
import by.shibaev.task7.model.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FilmDao {

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/filmlibrary?useUnicode=true&serverTimezone=UTC";

    private Logger logger = LogManager.getLogger();
    private static FilmDao instance;
    private Connection connection;

    public static FilmDao getInstance() throws DaoException {
        if (instance == null){
            instance = new FilmDao();
        }
        return instance;
    }

    private FilmDao() throws DaoException {
        try {
            Class.forName(DATABASE_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DaoException("Driver wasn't found");
        }
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "root");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        try {
            connection = DriverManager.getConnection(URL, properties);
        }
        catch (SQLException e){
            logger.log(Level.ERROR,e);
            throw new DaoException("Connection wasn't got " + e);
        }
    }

    public void add(Film film){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DataBaseRequest.ADD);
            statement.setString(1, film.getName());
            statement.setString(2, film.getProducer());
            statement.setInt(3, film.getYear());
            statement.execute();
        } catch (SQLException e) {
            //log
        }
    }

    public List<Film> selectAll(){
        List<Film> films =  new ArrayList<>();
        String name;
        int year;
        String producer;
        Film film;
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(DataBaseRequest.SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                name = resultSet.getString(1);
                producer = resultSet.getString(2);
                year = resultSet.getInt(3);
                films.add(new Film(name, producer, year));
            }
        } catch (SQLException e) {
            //log
        }
        return films;
    }
}
