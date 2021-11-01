package spittr.db.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spittr.db.ManagerRepository;
import spittr.domain.Manager;

/**
 * 吐槽者资源库接口的jdbc实现类
 *
 * @author wben
 * @version v1.0
 */
// 注解类作为DAO对象（数据访问对象，Data Access Objects），这些类可以直接对数据库进行操作
// 有这些分层操作的话，代码之间就实现了松耦合，代码之间的调用也清晰明朗，便于项目的管理；
@Repository
public class JdbcManagerRepository implements ManagerRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcManagerRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Manager save(Manager manager) {
        jdbc.update(INSERT_Manager, manager.getUserName(), manager.getPassword(), manager.getFullname(),
                manager.getEmail(), manager.getPhoneNo(), manager.getDelete());
        return manager;
    }

    @Override
    public Manager findByUserName(String userName) {
        Manager manager = null;
        try {
            manager = jdbc.queryForObject(SELECT_Manager + " where username=?", new ManagerRowMapper(), userName);
        } catch (DataAccessException e) {
        }
        return manager;
    }

    @Override
    public Manager findByUserName(String userName, String password) {
        Manager manager = null;
        try {
            manager = jdbc.queryForObject(SELECT_Manager + " where username=? and password=?", new ManagerRowMapper(),
                    userName, password);
        } catch (DataAccessException e) {
        }
        return manager;
    }

    @Override
    public long count() {
        return jdbc.queryForLong("select count(id) from Manager");
    }

    @Override
    public Manager findOne(long id) {
        Manager manager = null;
        try {
            manager = jdbc.queryForObject(SELECT_Manager + " where id=?", new ManagerRowMapper(), id);
        } catch (DataAccessException e) {
        }
        return manager;
    }

    @Override
    public List<Manager> findAll() {
        return jdbc.query(SELECT_Manager + " order by id", new ManagerRowMapper());
    }

    private static class ManagerRowMapper implements RowMapper<Manager> {
        public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Manager(rs.getLong("id"), rs.getString("username"), null, rs.getString("full_name"),
                    rs.getString("email"), rs.getString("phoneNo"), rs.getInt("delete"));
        }
    }

    @Override
    public List<Manager> findRange(int start_index, int offset) {
        return jdbc.query(SELECT_RANGE_MANAGER, new ManagerRowMapper(), start_index * offset, offset);
    }

    @Override
    public void delete(Long id) {
        jdbc.update("update Manager set delete=1 where id =?", id);
    }

    @Override
    public void update(Manager manager) {
        jdbc.update(UPDATE_MANAGER, manager.getUserName(), manager.getFullname(), manager.getPassword(), manager.getEmail(), manager.getPhoneNo(), manager.getId());
    }

    private static final String INSERT_Manager = "insert into Manager (username, password, full_name, email,phoneNo,delete) values (?, ?,?, ?, ?, ?)";

    private static final String SELECT_Manager = "select id,username,full_name, email, phoneNo ,delete from Manager";

    private static final String SELECT_RANGE_MANAGER = "select id,username,full_name, email, phoneNo ,delete from Manager limit ?,?";

    private static final String UPDATE_MANAGER = "update Manager set username=?,full_name=?,password=?,email=?,phoneNo=? where id =?";
}
