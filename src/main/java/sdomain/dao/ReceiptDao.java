package sdomain.dao;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import sdomain.domain.Receipt;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    private ResultSetExtractor<Receipt> resultSetExtractor = (rs) -> {
        Receipt receipt = new Receipt();
        receipt.setId(rs.getInt("id"));
        receipt.setProductName(rs.getString("productName"));
        receipt.setCurrency(rs.getString("currency"));
        receipt.setPrice(rs.getBigDecimal("price"));
        receipt.setPurchaseDate(rs.getDate("purchaseDate"));
        receipt.setWarrantyDate(rs.getDate("warrantyDate"));
        receipt.setCategory(rs.getString("category"));
        receipt.setShopName(rs.getString("shopName"));
        receipt.setShopInvoice(rs.getString("shopInvoice"));
        receipt.setShopAddress(rs.getString("shopAddress"));
        receipt.setShopPhone(rs.getString("shopPhone"));
        receipt.setRemarks(rs.getString("remarks"));
        return receipt;
    };

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