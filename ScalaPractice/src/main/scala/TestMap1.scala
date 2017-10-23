
import java.io.File

import org.neo4j.driver.v1.{AuthTokens, Driver, GraphDatabase}

object TestMap1 {
  def main(args: Array[String]) {
    val filesList = new File("/home/synerzip/software/neo4j-community-3.0.2/import/Delete").list().toList
    val driver: Driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "shubham5252"))
    val session = driver.session
    val operationToDo = "Create"

    if (operationToDo.equals("Delete")) {
      filesList.foreach { files => session.run("LOAD CSV FROM \"file:///Delete/" + files.trim + "\" AS row MATCH p=()-[r:FlyingTo{name:row[0]}]->() delete r") }
    }
    else if (operationToDo.equals("Create")) {
      filesList.foreach { files =>
        session.run("LOAD CSV FROM \"file:///Create/" + files.trim + "\" AS row match(from:Location),(to:Location) where (from.locCode=row[1] and to.locCode=row[2]) create (from)-[rel:FlyingTo{name:row[0],duration:row[5],depLoc:row[1],arrLoc:row[2],time:row[4],date:row[3],fare:row[6]}]->(to)")
      }

    }
    else if (operationToDo.equals("Update")) {
      filesList.foreach { files =>
        session.run("LOAD CSV FROM \"file:///Update/" + files.trim + "\" AS row MATCH ()-[r:FlyingTo{name:row[0]}]->() DELETE r")
      }
      filesList.foreach { files =>
        session.run("LOAD CSV FROM \"file:///Update/" + files.trim + "\" AS row MATCH (from:Location),(to:Location) WHERE (from.locCode=row[1] and to.locCode=row[2]) CREATE (from)-[rel:FlyingTo{name:row[0],duration:row[5],depLoc:row[1],arrLoc:row[2],time:row[4],date:row[3],fare:row[6]}]->(to)")
      }

    }


  }
}

