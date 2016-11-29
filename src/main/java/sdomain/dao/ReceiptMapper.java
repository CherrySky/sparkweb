package sdomain.dao;

import org.springframework.jdbc.core.RowMapper;
import sdomain.domain.Receipt;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiptMapper implements RowMapper<Receipt> {
    @Override
    public Receipt mapRow(ResultSet resultSet, int i) throws SQLException {
        Receipt receipt = new Receipt();
        receipt.setId(resultSet.getInt("id"));
        receipt.setProductName(resultSet.getString("productName"));
        receipt.setCurrency(resultSet.getString("currency"));
        receipt.setPrice(resultSet.getBigDecimal("price"));
        receipt.setPurchaseDate(resultSet.getDate("purchaseDate"));
        receipt.setWarrantyDate(resultSet.getDate("warrantyDate"));
        receipt.setCategory(resultSet.getString("category"));
        receipt.setShopName(resultSet.getString("shopName"));
        receipt.setShopInvoice(resultSet.getString("shopInvoice"));
        receipt.setShopAddress(resultSet.getString("shopAddress"));
        receipt.setShopPhone(resultSet.getString("shopPhone"));
        receipt.setRemarks(resultSet.getString("remarks"));
        return receipt;
    }
}
