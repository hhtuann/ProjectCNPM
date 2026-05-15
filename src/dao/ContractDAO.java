package dao;

import model.Contract;
import model.ContractJob;
import model.ContractJobShift;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContractDAO extends DAO {
    public ContractDAO() {
        super();
    }

    public boolean addContract(Contract contract) {
        String sqlContract = "INSERT INTO tblContract (contractDate, paymentMethod, status, customerId, userId) VALUES (?, ?, ?, ?, ?)";

        try {
            con.setAutoCommit(false);

            PreparedStatement psContract = con.prepareStatement(sqlContract, Statement.RETURN_GENERATED_KEYS);
            psContract.setDate(1, Date.valueOf(contract.getContractDate()));
            psContract.setString(2, contract.getPaymentMethod());
            psContract.setString(3, contract.getStatus());
            psContract.setInt(4, contract.getCustomer().getId());
            psContract.setInt(5, contract.getUser().getId());
            psContract.executeUpdate();

            ResultSet rsContract = psContract.getGeneratedKeys();
            if (rsContract.next()) {
                int contractId = rsContract.getInt(1);
                String sqlJob = "INSERT INTO tblContractJob (contractId, jobId) VALUES (?, ?)";
                for (ContractJob cj : contract.getContractJobs()) {
                    PreparedStatement psJob = con.prepareStatement(sqlJob, Statement.RETURN_GENERATED_KEYS);
                    psJob.setInt(1, contractId);
                    psJob.setInt(2, cj.getJob().getId());
                    psJob.executeUpdate();

                    ResultSet rsJob = psJob.getGeneratedKeys();
                    if (rsJob.next()) {
                        int contractJobId = rsJob.getInt(1);
                        String sqlShift = "INSERT INTO tblContractJobShift (requiredWorkers, agreedWage, shiftId, contractJobId) VALUES (?, ?, ?, ?)";
                        for (ContractJobShift cjs : cj.getContractJobShifts()) {
                            PreparedStatement psShift = con.prepareStatement(sqlShift);
                            psShift.setInt(1, cjs.getRequiredWorkers());
                            psShift.setDouble(2, cjs.getAgreedWage());
                            psShift.setInt(3, cjs.getShift().getId());
                            psShift.setInt(4, contractJobId);
                            psShift.executeUpdate();
                            psShift.close();
                        }
                    }
                    rsJob.close();
                    psJob.close();
                }
            }
            rsContract.close();
            psContract.close();
            con.commit();
            return true;
        } catch (Exception e1) {
            e1.printStackTrace();
            try {
                con.rollback();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }
}
