package com;
import org.neo4j.driver.v1.*;
public class DemoNeo4jConnect {
    public static void main(String[] args)
    {
        Driver driver=GraphDatabase.driver("bolt://localhost",AuthTokens.basic("neo4j","shubham5252"));
        Session session=driver.session();
        StatementResult rs=session.run("match (n:Person) return n");

        while(rs.hasNext())
        {
            System.out.println(rs.next().get("name"));
        }
    }
}
