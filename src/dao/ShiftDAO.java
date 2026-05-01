package dao;

import model.Shift;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;

public class ShiftDAO extends DAO {
    public ShiftDAO() {
    }

    public ArrayList<Shift> searchShift(Shift shift) {
        ArrayList<Shift> result = new ArrayList<>();
        String sql = "SELECT * FROM tblShift WHERE workingDate = ? AND startTime < ? AND endTime > ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(shift.getWorkingDate()));
            ps.setTime(2, Time.valueOf(shift.getEndTime()));
            ps.setTime(3, Time.valueOf(shift.getStartTime()));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Shift(
                        rs.getInt("id"),
                        rs.getDate("workingDate").toLocalDate(),
                        rs.getTime("startTime").toLocalTime(),
                        rs.getTime("endTime").toLocalTime()
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
