//package com;
//
//import org.neo4j.graphdb.GraphDatabaseService;
//import org.neo4j.graphdb.Label;
//import org.neo4j.graphdb.Node;
//import org.neo4j.graphdb.Transaction;
//import org.neo4j.graphdb.factory.GraphDatabaseFactory;
//
//import java.io.File;
//
//public class DemoNativeJavaAPI {
//    public static void main(String[] args) {
//        GraphDatabaseFactory dbFactory=new GraphDatabaseFactory();
//        //File src=new File("/home/synerzip/codebase/Demo-Neo4j-3/src/db");
//        ///home/synerzip/software/neo4j-community-3.0.1/data/databases/graph.db
//        File src=new File("/home/synerzip/software/neo4j-community-3.0.1/data/databases/graph.db");
//        GraphDatabaseService db=dbFactory.newEmbeddedDatabase(src);
//
//        try (Transaction tx = db.beginTx()) {
//            Node javaNode = db.createNode(Label.label("Java"));
//            javaNode.setProperty("TutorialID", "JAVA001");
//            javaNode.setProperty("Title", "Learn Java");
//            javaNode.setProperty("NoOfChapters", "25");
//            javaNode.setProperty("Status", "Completed");
//
//            Node scalaNode = db.createNode(Label.label("Scala"));
//            scalaNode.setProperty("TutorialID", "SCALA001");
//            scalaNode.setProperty("Title", "Learn Scala");
//            scalaNode.setProperty("NoOfChapters", "20");
//            scalaNode.setProperty("Status", "Completed");
//            tx.success();
//
//            db.shutdown();
//            System.out.println("Done successfully");}
//    }
//}