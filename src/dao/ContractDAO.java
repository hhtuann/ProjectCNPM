package dao;

import model.Contract;
import model.ContractJob;
import model.ContractJobShift;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContractDAO extends DAO {
    public ContractDAO() {
        super();
    }

    public boolean addContract(Contract contract) {
        String sqlContract = "INSERT INTO tblContract (contractDate, paymentMethod, status, salesManagerId, customerId) VALUES (?, ?, ?, ?, ?)";

        try {
            con.setAutoCommit(false);

            PreparedStatement psContract = con.prepareStatement(sqlContract, PreparedStatement.RETURN_GENERATED_KEYS);
            psContract.setDate(1, Date.valueOf(contract.getContractDate()));
            psContract.setString(2, contract.getPaymentMethod());
            psContract.setString(3, contract.getStatus());
            psContract.setInt(4, contract.getUser().getId());
            psContract.setInt(5, contract.getCustomer().getId());
            psContract.executeUpdate();

            ResultSet rsContract = psContract.getGeneratedKeys();
            if (rsContract.next()) {
                int contractId = rsContract.getInt(1);

                String sqlContractJob = "INSERT INTO tblContractJob (contractId, jobId) VALUES (?, ?)";
                for (ContractJob cj : contract.getContractJobs()) {
                    PreparedStatement psContractJob = con.prepareStatement(sqlContractJob, PreparedStatement.RETURN_GENERATED_KEYS);
                    psContractJob.setInt(1, contractId);
                    psContractJob.setInt(2, cj.getJob().getId());
                    psContractJob.executeUpdate();

                    ResultSet rsContractJob = psContractJob.getGeneratedKeys();
                    if (rsContractJob.next()) {
                        int contractJobId = rsContractJob.getInt(1);

                        String sqlContractJobShift = "INSERT INTO tblContractJobShift (requiredWorkers, agreedWage, shiftId, contractJobId) VALUE (?, ?, ?, ?)";
                        for (ContractJobShift cjs : cj.getContractJobShifts()) {
                            PreparedStatement psContractJobShift = con.prepareStatement(sqlContractJobShift);
                            psContractJobShift.setInt(1, cjs.getRequiredWorkers());
                            psContractJobShift.setDouble(2, cjs.getAgreedWage());
                            psContractJobShift.setInt(3, cjs.getShift().getId());
                            psContractJobShift.setInt(4, contractJobId);
                            psContractJobShift.executeUpdate();
                        }
                    }

                }
            }

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
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        return false;
    }
}
