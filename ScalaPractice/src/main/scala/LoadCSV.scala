//package utilties
//
//import java.io.File
//import org.neo4j.driver.v1.{AuthTokens, Driver, GraphDatabase, Session}
//
//object LoadCSV extends App {
//  //operateOnDb("Create")
//  val operationToDo="Create"
//  //  def operateOnDb(operationToDo: String): Unit = {
//  val listFiles =  new File("/home/synerzip/software/neo4j-community-3.0.2/import/" + operationToDo).list().toList
//  val driver: Driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "shubh"))
//  val session =   driver.session
//  val listIt = listFiles.iterator
//  //    while (listIt.hasNext) {
//  val file = listIt.next()
//
//  //      if (operationToDo.equals("Delete")) {
//  //        session.run(s"LOAD CSV FROM \"file:///Delete/"+file+"\" AS row match ()-[rel:FlyingTo{flight:row[0]}]->() delete rel")
//  //      }
//  //      else if (operationToDo.equals("Create")) {
//  session.run(s"LOAD CSV FROM \"file:///Create/$file\" AS row match(from:Location),(to:Location) where (from.locCode=row[1] and to.locCode=row[2]) create (from)-[rel:FlyingTo{name:row[0],duration:row[5],depLoc:row[1],arrLoc:row[2],time:row[4],date:row[3],fare:row[6]}]->(to)")
//  //      }
//  //      else if (operationToDo.equals("Update")) {
//  //        session.run(s"LOAD CSV FROM \"file:///Update/"+file+"\" AS row match ()-[rel:FlyingTo{flight:row[0]}]->() delete rel")
//  //      }
//  //    }
//
//  //  }
//
//}
