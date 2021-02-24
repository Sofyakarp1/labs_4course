package mirea.mosit.labs_mires.service;

import mirea.mosit.labs_mires.bean.Mark;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IMark {

    private final JdbcTemplate jdbcTemplate;

    public IMark(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public Mark getMark(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM mark WHERE id = ?", this::mapMark, id);
    }

    private Mark mapMark(ResultSet rs, int i) throws SQLException {
        Mark mark = new Mark(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("value")
        );
        return mark;
    }

    //Show all marks
    public List<Mark> showAllMarks() {
        return jdbcTemplate.query("SELECT * FROM mark", this::mapMark);
    }
}
