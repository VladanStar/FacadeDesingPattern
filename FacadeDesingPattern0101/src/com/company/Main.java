package com.company;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String tableName = "student";
        Connection conn = MySQLHelper.getMySQLConnection();
        MySQLHelper mySQLHelper = new MySQLHelper();
        mySQLHelper.generateMySQLHTMLReprt("student",conn);
        mySQLHelper.genereteMySQLPDFReport("student",conn);

        Connection connection = OracleHelper.getOracleConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateHTMLReport("student",connection);

        // generisanje sa FacadePattern

        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL,HelperFacade.ReportTypes.PDF,"student");
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL,HelperFacade.ReportTypes.HTML,"student");


    }
}
