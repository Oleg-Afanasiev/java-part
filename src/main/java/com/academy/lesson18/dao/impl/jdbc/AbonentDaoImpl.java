package com.academy.lesson18.dao.impl.jdbc;

import com.academy.lesson18.dao.AbonentDao;
import com.academy.lesson18.model.Abonent;
import com.academy.lesson18.model.Gender;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbonentDaoImpl extends BaseDao implements AbonentDao {

    private static final String SQL_SELECT_ALL = "SELECT * FROM abonent";
    private static final String SQL_INSERT = "INSERT INTO abonent (first_name, last_name, age, gender)" +
            " VALUES (?, ?, ?, ?)";

    @Override
    public boolean save(Abonent abonent) {
        try(Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setString(1, abonent.getFirstName());
            ps.setString(2, abonent.getLastName());
            ps.setInt(3, abonent.getAge());
            ps.setString(4, abonent.getGender().toChar().toString());
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(Abonent abonent) {
        return false;
    }

    @Override
    public List<Abonent> getAll() {
        List<Abonent> abonents = new ArrayList<>();
        try(Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Abonent abonent = new Abonent();
                abonent.setAbonentId(rs.getLong("abonent_id"));
                abonent.setFirstName(rs.getString("first_name"));
                abonent.setLastName(rs.getString("last_name"));
                abonent.setAge(rs.getInt("age"));
                abonent.setGender(Gender.valueOf(rs.getString("gender").charAt(0)));

                abonents.add(abonent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return abonents;
    }

    @Override
    public Abonent findById(long id) {
        return null;
    }
}
