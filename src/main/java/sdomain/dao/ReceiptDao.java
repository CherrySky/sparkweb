package sdomain.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
        List<Receipt> receipts = template.query(sql, dataMapper);
        return receipts;
    }

    @Override
    public Object getByID(int id) {
        return null;
    }

    private RowMapper<Receipt> dataMapper = (rs, i) -> {
        Receipt receipt = new Receipt();
        receipt.setId(rs.getInt("id"));
        receipt.setProductName(rs.getString("productName"));
        return receipt;
    };
}
