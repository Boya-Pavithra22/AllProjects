package com.wipro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.wipro.model.*;

public class PersonRowMapper6 implements RowMapper<person> {
    @Override
    public person mapRow(ResultSet rs, int rowNum) throws SQLException {
        person person = new person();
        person.setId(rs.getInt("id"));
        person.setAge(rs.getInt("age"));
        person.setFirstName(rs.getString("first_name"));
        person.setLastName(rs.getString("last_name"));
        return person;
    }
}
