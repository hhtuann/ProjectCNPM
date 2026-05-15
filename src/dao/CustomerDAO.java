package dao;

import model.Customer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerDAO extends DAO {
    public CustomerDAO() {
        super();
    }

    /**
     * Hàm tìm kiếm danh sách khách hàng theo tên hoặc CCCD
     *
     * @param key
     * @return danh sách khách hàng khớp với @key
     */
    public ArrayList<Customer> searchCustomer(String key) {
        ArrayList<Customer> result = new ArrayList<>();
        String sql = "SELECT * FROM tblCustomer WHERE fullName LIKE ? OR idCard LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ps.setString(2, "%" + key + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("fullName"),
                        rs.getDate("dateOfBirth").toLocalDate(),
                        rs.getString("idCard"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("type")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Hàm thêm khách hàng mới vào CSDL
     *
     * @param customer
     * @return true nếu thêm thành công, false nếu thêm lỗi
     */
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO tblCustomer (fullName, dateOfBirth, idCard, phone, email, address, type) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getFullName());
            ps.setDate(2, Date.valueOf(customer.getDateOfBirth()));
            ps.setString(3, customer.getIdCard());
            ps.setString(4, customer.getPhone());
            ps.setString(5, customer.getEmail());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getType());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Hàm kiểm tra tồn tại số CCCD của khách hàng mới trong CSDL
     *
     * @param idCard
     * @return true nếu đã tồn tại, false nếu không tồn tại
     */
    public boolean isIdCardExisted(String idCard) {
        String sql = "SELECT COUNT(*) FROM tblCustomer WHERE idCard = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, idCard);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
