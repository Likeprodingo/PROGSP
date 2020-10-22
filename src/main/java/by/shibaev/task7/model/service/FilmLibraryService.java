package by.shibaev.task7.model.service;

import by.shibaev.task7.model.dao.FilmDao;
import by.shibaev.task7.model.entity.Film;
import by.shibaev.task7.model.exception.DaoException;
import by.shibaev.task7.model.exception.ServiceException;
import by.shibaev.task7.model.validator.FilmValidator;

import java.util.ArrayList;
import java.util.List;

public class FilmLibraryService {
    public final static FilmLibraryService INSTANCE = new FilmLibraryService();

    private FilmLibraryService(){}

    public void add(String name, String producer, String year) throws ServiceException {
        FilmValidator filmValidator = new FilmValidator();
        if(!filmValidator.isNameValid(name) || !filmValidator.isProducerValid(producer) || !filmValidator.isYearValid(year)){
            throw new ServiceException("not valid input");
        }
        try {
            FilmDao dao = FilmDao.getInstance();
            int yearValue = Integer.parseInt(year);
            Film film = new Film(name,producer,yearValue);
            dao.add(film);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    public List<Film> selectAll() throws ServiceException {
        List<Film> films;
        try {
            FilmDao dao = FilmDao.getInstance();
            films = dao.selectAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        if (films == null){
            films = new ArrayList<>();
        }
        return films;
    }

    public List<Film> selectByProducer(String producer) throws ServiceException {
        List<Film> films = new ArrayList<>();
        FilmValidator filmValidator = new FilmValidator();
        if(filmValidator.isProducerValid(producer)){
            try {
                FilmDao dao = FilmDao.getInstance();
                for (Film film : dao.selectAll()){
                    if (film.getProducer().equals(producer)){
                        films.add(film);
                    }
                }
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return films;
    }
    public List<Film> selectByName(String name) throws ServiceException {
        List<Film> films = new ArrayList<>();
        FilmValidator filmValidator = new FilmValidator();
        if(filmValidator.isNameValid(name)){
            try {
                FilmDao dao = FilmDao.getInstance();
                for (Film film : dao.selectAll()){
                    if (film.getName().equals(name)){
                        films.add(film);
                    }
                }
            } catch (DaoException e) {
                throw new ServiceException(e);
            }
        }
        return films;
    }
}
