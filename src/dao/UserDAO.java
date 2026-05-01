package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO extends DAO {
    public UserDAO() {
        super();
    }

    /**
     * Hàm kiểm tra thông tin đăng nhập của người dùng
     *
     * @param user
     * @return true nếu đăng nhập thành công, false nếu đăng nhập lỗi
     */
    public boolean checkLogin(User user) {
        String sql = "SELECT * FROM tblUser WHERE username = ? AND password = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setFullName(rs.getString("fullName"));
                user.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
                user.setIdCard(rs.getString("idCard"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getString("role"));
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
