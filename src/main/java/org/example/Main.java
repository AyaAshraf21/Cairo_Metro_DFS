package org.example;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        String startStation, endStation;
        PriorityQueue<ArrayList<String>> pq;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start station: ");
        startStation = sc.nextLine();
        System.out.print("Enter end station: ");
        endStation = sc.nextLine();
        DFS.DFSAlgo(startStation, endStation);

    }
}