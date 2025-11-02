package org.example;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class WebCrawler {
    private static Phaser phaser;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your url");
        String url=sc.nextLine();

        System.out.println("Enter depth of crawler");
        final int maxDepth=sc.nextInt();

        System.out.println("Enter the number of workers");
        final int maxThreads=sc.nextInt();


        URLStore urlStore=new URLStore();
        URLFetcher urlFetcher=new URLFetcher();

        phaser=new Phaser(1);

        executorService= Executors.newFixedThreadPool(maxThreads);

        urlStore.addUrl(url);

        submitTask(urlStore,urlFetcher,0,maxDepth);

        phaser.awaitAdvance(phaser.getPhase());

        executorService.shutdown();


    }

    public static void submitTask(URLStore urlStore,URLFetcher urlFetcher,int currentDepth,int maxDepth){
        executorService.submit(new CrawlerTask(urlStore,urlFetcher,currentDepth,maxDepth,phaser));
    }

}
