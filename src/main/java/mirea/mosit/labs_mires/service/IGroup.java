package mirea.mosit.labs_mires.service;

import mirea.mosit.labs_mires.bean.Group;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class IGroup {

    private final JdbcTemplate jdbcTemplate;

    public IGroup(JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }

    public Group getGrop(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM study_group WHERE id = ?", this::mapGroup, id);
    }

    private Group mapGroup(ResultSet rs, int i) throws SQLException {
        Group group = new Group(
                rs.getInt("id"),
                rs.getString("name")
        );
        return group;
    }

    //Delete group
    public int deleteGroup(int id) {
        return jdbcTemplate.update("DELETE FROM study_group WHERE id = ?", id);
    }

    //Show all members of group
    public List<Group> showAllGroups() {
        return jdbcTemplate.query("SELECT * FROM study_group", this::mapGroup);
    }
}
