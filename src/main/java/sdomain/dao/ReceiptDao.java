package sdomain.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import sdomain.domain.Receipt;

import javax.sql.DataSource;
import java.util.List;

public class ReceiptDao implements Dao {

    private NamedParameterJdbcTemplate template;

    public ReceiptDao(DataSource ds) {
        template = new NamedParameterJdbcTemplate(ds);
    }

    @Override
    public List getAll() {
        String sql = "SELECT * FROM Receipt";
        List<Receipt> receipts = template.query(sql, new ReceiptMapper());
        return receipts;
    }

    @Override
    public Receipt getByID(String id) {
        String sql = "SELECT * FROM Receipt where id = :id";
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        return template.queryForObject(sql, namedParameters, new ReceiptMapper());
    }

    @Override
    public void update(Object receipt) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void create(Object receipt) {

    }

    public List search(String searchText) {
        String sql = "SELECT * FROM Receipt where productName like '%" + searchText + "%'";
        List<Receipt> receipts = template.query(sql, new ReceiptMapper());

        if (receipts.size() == 0) {
            sql = "SELECT * FROM Receipt where category like '%" + searchText + "%'";
            receipts = template.query(sql, new ReceiptMapper());
        }
        return receipts;
    }
}