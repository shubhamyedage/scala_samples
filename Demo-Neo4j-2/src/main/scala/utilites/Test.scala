import org.neo4j.driver.v1._

object Test extends App {
  val driver: Driver = GraphDatabase.driver("bolt://localhost", AuthTokens.basic("neo4j", "shubham5252"))
  val session: Session = driver.session

  //val rs=session.run("match path=(from:Location{locCode:\"FRA\"})-[rel1:FlyingTo{date:\"20/11/2010\"}]->(conn:Location)-[rel2:FlyingTo{date:\"20/11/2010\"}]->(to:Location{locCode:\"LHR\"})\nwhere (toInt(rel1.time)+toFloat(rel1.duration)*100) < toInt(rel2.time)\nreturn path")
  val rs = session.run("match path=(from:Location{locCode:\"FRA\"})-[rel1:FlyingTo{date:\"20/11/2010\"}]->(conn:Location)-[rel2:FlyingTo{date:\"20/11/2010\"}]->(to:Location{locCode:\"LHR\"})\nwhere (toInt(rel1.time)+toFloat(rel1.duration)*100) < toInt(rel2.time)\nreturn rel1.name as fl1Name, rel2.name as fl2Name\norder by (rel1.duration+rel2.duration)")

  //  val shubham = "John"
  //  //val rs = session.run("match(p:Person)where(p.name='John') return p.name as name, p.userId as id")
  ////  val rs = session.run("match (f:Flight),(loc:Location) "
  ////                        +"where (f.depLoc='FRA' or f.arrLoc='LHR' and f.date='20/11/2010') "
  ////                         //+"with distinct f.date as date, f.duration as duration, f.fare as fare, f.flightNum as name, f.arrLoc as arrLoc, f.depLoc as depLoc, f.time as time "
  ////                        +"return  date, duration, fare, name, arrLoc, depLoc, time ")
  //////                        +"order by fare, duration")
  //  val rs = session.run("match (f:Flight),(loc:Location) "
  //    +"where (f.depLoc='FRA' or f.arrLoc='LHR' and f.date='20/11/2010') "
  //    +"return distinct f.date as date, f.duration as duration, f.fare as fare, f.flightNum as name, f.arrLoc as arrLoc, f.depLoc as depLoc, f.time as time ")
  //

  val connFlightList=scala.collection.mutable.ListBuffer
  while (rs.hasNext) {
val record=rs.next()
    println(record.get("fl1Name")+""+record.get("fl2Name"))
  }

}
