//import com.tinkerpop.blueprints.{Edge, Vertex}
//import com.tinkerpop.blueprints.impls.neo4j2.Neo4j2Graph
//import org.neo4j.cypher.{ExecutionEngine, ExecutionResult}
//import org.neo4j.graphdb.{Node, Transaction}
//
//object MyObject {
//  def main(args: Array[String]) {
//    // get embedded blueprint neo4j graph
//    val graph: Neo4j2Graph = new Neo4j2Graph("neo4j-community-3.0.1/data/databases/graph.db")
//    //  Create nodes -vertex in Blueprint
//    val a: Vertex = graph.addVertex(null)
//    val b: Vertex = graph.addVertex("Person")
//    val c: Vertex = graph.addVertex("Person")
//
//    //Set Property
//    a.setProperty("name", "Oliver")
//    a.setProperty("age", 10)
//    b.setProperty("name", "Alen")
//    b.setProperty("age", 32)
//    c.setProperty("name", "Nora")
//    c.setProperty("age", 30)
//
//    graph.commit()
//
//    val vvv = graph.getVertices
//    println(vvv)
//
//    //Add relationship Relationship in Blueprint
//    val aTob: Edge = graph.addEdge("Person", a, b, "Married")
//    aTob.setProperty("date", "01/02/1995")
//    val aToc: Edge = graph.addEdge("Person", a, c, "Child")
//    aToc.setProperty("bdate", "02/02/2005")
//    val bToc: Edge = graph.addEdge(null, a, c, "Child")
//    bToc.setProperty("bdate", "02/02/2005")
//
//    //Query to get data
//    val engine = new ExecutionEngine(graph.getRawGraph)
//    val result: ExecutionResult = engine.execute("match (n) return n")
//    val it = result.columnAs[Node]("n")
//    val lst = it.toList
//    result.close()
//    val tx: Transaction = graph.getRawGraph.beginTx()
//
//    for (node <- lst) {
//      println(node)
//    }
//    // close connection to graph, important!
//    graph.shutdown()
//    println("Done!")
//
//  }
//}
//
