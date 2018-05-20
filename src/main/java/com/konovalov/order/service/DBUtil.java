package com.konovalov.order.service;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private Connection connection=null;
    private DbProperties properties=new DbProperties();


    public DBUtil() {
        try {
            connection= DriverManager.getConnection(properties.getUrl(),properties.getUser(),properties.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        try {
            connection=DriverManager.getConnection(properties.getUrl(),properties.getUser(),properties.getPassword());
            System.out.println("Connect On");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connect error");
        }
        return connection;
    }

    public void createTable() {
        try (Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE `cafe`.`goods` (\n" +
                    "  `idgoods` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name_goods` VARCHAR(45) NOT NULL,\n" +
                    "  `weight` INT NOT NULL,\n" +
                    "  `price` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idgoods`),\n" +
                    "  UNIQUE INDEX `idgoods_UNIQUE` (`idgoods` ASC))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            st.execute("CREATE TABLE `cafe`.`clients` (\n" +
                    "  `idclients` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `money` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idclients`),\n" +
                    "  UNIQUE INDEX `idclients_UNIQUE` (`idclients` ASC))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;\n");
            st.execute("CREATE TABLE `cafe`.`orders` (\n" +
                    "  `idorders` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `idclient` INT NULL,\n" +
                    "  `idgoods` INT NULL,\n" +
                    "  PRIMARY KEY (`idorders`),\n" +
                    "  UNIQUE INDEX `idorders_UNIQUE` (`idorders` ASC))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            System.out.println("create table");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("dont create table");
        }
    }
}
