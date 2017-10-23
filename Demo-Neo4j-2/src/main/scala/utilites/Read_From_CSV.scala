//import java.io.File
//
//import gremlin.scala.Key
//import org.apache.tinkerpop.gremlin.neo4j.structure.Neo4jGraph
//
//object Read_From_CSV extends App {
//  val loader = classOf[Read_From_CSV].getClassLoader
//  val filesList = new File(loader.
//    getResource("model/resources").
//    getPath).list()
//
//  //=========Create Nodes==========
//  val dbGraph = "target/Flight-Location"
//  val graph=Neo4jGraph.open(dbGraph)
//  val name = Key[String]("name")
//  val depLoc = Key[String]("depLoc")
//  val arrLoc = Key[String]("arrLoc")
//  val date = Key[String]("date")
//  val time = Key[Int]("time")
//  val duration = Key[Float]("duration")
//  val fare = Key[Float]("fare")
//  //=======Node Location===========
//
//
//
//  //================================
//}
//
//case class Read_From_CSV()
