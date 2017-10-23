import org.neo4j.graphdb.{Label, Transaction}
import org.neo4j.graphdb.factory.GraphDatabaseFactory

object MyObject2 {
  def main(args: Array[String]) {
    val db = new GraphDatabaseFactory().newEmbeddedDatabase("/home/synerzip/software/neo4j-community-3.0.1/data")
    val tx: Transaction = db.beginTx()

    val node = db.createNode(myLabel)
    node.setProperty("name", "AI890")
    node.setProperty("depLoc", "JPA")
    node.setProperty("arrLoc", "IND")
    node.setProperty("date", "01/04/2016")
    node.setProperty("time", 2400)
    node.setProperty("duration", 2.3)
    node.setProperty("fare", 550.0)
    tx.success()
    println("Done!")
  }
}
object myLabel extends Label {
  override def name(): String = "Flight"
}