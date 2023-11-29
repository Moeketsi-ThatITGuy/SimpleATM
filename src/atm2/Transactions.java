package atm2;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class Transactions {

    String type;
    Frames frame;
    Date date;

    Transactions(String type) {

      this.type = type;
      date = new Date();

        if (this.type.equals("Deposit")) {
            updatedTransaction(this.date , LoginWindow.accountNumber , DepositWindow.verifiedAmmount , "Deposit" ,DepositWindow.newAmount );
        }
        else if(this.type.equals("Withdrawal"))
            updatedTransaction(this.date , LoginWindow.accountNumber , WithdrawalWindow.verifiedAmmount , "Withdrawal" , WithdrawalWindow.newAmount);
        else
            updatedTransaction(this.date , LoginWindow.accountNumber , WithdrawalWindow.verifiedAmmount , "Transefer" , TransferWindow.getFinalValueOfAccount1);
    }






    public void updatedTransaction(Date date, String accountNumber, int amount, String type , int balanceLeft) {
        Connection getConnection = DatabaseConnection.dbConnection();
        Connection connection = DatabaseConnection.conn;

        String sql = "insert into transaction values('" + date + "' , '" + accountNumber + "' , '" + amount + "' , '" + type + "' + '"+ DepositWindow.newAmount +"') ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            int count = st.executeUpdate();


        } catch (Exception e) {
            System.out.println("Couldnt update Transactions");
        }

    }
}