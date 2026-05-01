package dao;

import model.Job;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JobDAO extends DAO {
    public JobDAO() {
        super();
    }

    /**
     * Hàm tìm kiếm danh sách đầu việc theo tên
     *
     * @param key
     * @return danh sách đầu việc khớp với @key
     */
    public ArrayList<Job> searchJob(String key) {
        ArrayList<Job> result = new ArrayList<>();
        String sql = "SELECT * FROM tblJob WHERE jobName LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Job(
                        rs.getInt("id"),
                        rs.getString("jobName"),
                        rs.getString("description"),
                        rs.getString("skill")
                ));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Hàm thêm đầu việc mới vào CSDL
     *
     * @param job
     * @return true nếu thêm thành công, false nếu thêm lỗi
     */
    public boolean addJob(Job job) {
        String sql = "INSERT INTO tblJob (jobName, description, skill) VALUE (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, job.getJobName());
            ps.setString(2, job.getDescription());
            ps.setString(3, job.getSkill());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
