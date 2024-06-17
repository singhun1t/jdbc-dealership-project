package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        // TODO: Implement the logic to add a lease contract
            try(Connection connection = dataSource.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            """
                                INSERT INTO lease_contracts (VIN, lease_start, lease_end, monthly_payment)
                                VALUES (?, ?, ?, ? )
                               
                                """
                    )){
                preparedStatement.setString(1,leaseContract.getVin());
                preparedStatement.setDate(2, Date.valueOf(leaseContract.getLeaseStart()));
                preparedStatement.setDate(3, Date.valueOf(leaseContract.getLeaseEnd()));
                preparedStatement.setDouble(4, leaseContract.getMonthlyPayment());

                preparedStatement.executeUpdate();
            }catch (Exception ex){
                ex.printStackTrace();
            }
    }
}
