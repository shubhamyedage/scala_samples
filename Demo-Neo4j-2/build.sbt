name := "Demo-Neo4j-2"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.neo4j.driver" % "neo4j-java-driver" % "1.0.0"

libraryDependencies ++=Seq("com.michaelpollmeier" %% "gremlin-scala" % "3.1.0-incubating",
  "org.apache.tinkerpop" % "neo4j-gremlin" % "3.1.0-incubating",
  "org.neo4j" % "neo4j-tinkerpop-api-impl" % "0.3-2.3.0",
  "org.slf4j" % "slf4j-simple" % "1.7.12")