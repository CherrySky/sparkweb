package sdomain.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sdomain.domain.Receipt;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Date;
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
        List<Receipt> receipts = template.query(sql, dataMapper);

        if (receipts.size() == 0) {
            sql = "SELECT * FROM Receipt where category like '%" + searchText + "%'";
            receipts = template.query(sql, dataMapper);
        }
        return receipts;
    }
}