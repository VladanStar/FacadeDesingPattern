package com.company;



import java.sql.Connection;

public class HelperFacade {
    public static enum DBTypes {MYSQL, ORACLE};
    public static enum ReportTypes{HTML,PDF};

    public static void generateReport(DBTypes dbTypes, ReportTypes reportTypes, String tableName){

        Connection conn = null;
        switch (dbTypes){
            case MYSQL:
                conn = MySQLHelper.getMySQLConnection();
                MySQLHelper mySQLHelper = new MySQLHelper();
                switch (reportTypes){

                    case HTML:
                        mySQLHelper.generateMySQLHTMLReprt(tableName,conn);
                    case PDF:
                        mySQLHelper.genereteMySQLPDFReport(tableName,conn);
                        break;
                }
                break;
            case ORACLE:
                conn = OracleHelper.getOracleConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportTypes){
                    case HTML:
                        oracleHelper.generateHTMLReport(tableName,conn);
                        break;
                    case PDF:
                        oracleHelper.generatePDFReport(tableName,conn);
                        break;
                }
        }

    }
}
