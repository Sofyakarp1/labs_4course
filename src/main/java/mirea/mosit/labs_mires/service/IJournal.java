package mirea.mosit.labs_mires.service;

import mirea.mosit.labs_mires.bean.Journal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class IJournal {
    private final JdbcTemplate jdbcTemplate;

    public IJournal(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public Journal getJournal(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM journal WHERE id = ?", this::mapJournal, id);
    }

    private Journal mapJournal(ResultSet rs, int i) throws SQLException {
        Journal journal = new Journal(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan_id"),
                rs.getInt("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id")
        );
        return journal;
    }
}
