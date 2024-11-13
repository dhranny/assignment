package com.assignment;

import com.assignment.FeyisayoCompetitor.Level;
import java.util.Scanner;
public class Feyisayo {


    public static void main(String[] args) {
        System.out.println("Welcome to Feyisayo competition\n\n");
        System.out.println("Please input the id number of the candidate\t:");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        sc.close();
        MysqlCli.getCompetitor(id);
        System.out.println(MysqlCli.getCompetitor(id).getFullDetails());
        Report.reportAll(MysqlCli.getAllCompetitors());
    }
}
