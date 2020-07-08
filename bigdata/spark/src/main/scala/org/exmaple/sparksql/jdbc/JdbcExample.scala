package org.exmaple.sparksql.jdbc

import java.util.Properties

import org.apache.spark.sql.SparkSession

object JdbcExample {
  def main(args: Array[String]): Unit = {
    val session = SparkSession.builder().appName("jdbc-exmpale").master("local[*]").getOrCreate()
    val properties = new Properties()
    properties.put("user","root")
    properties.put("password","openstack")
    val frame = session.read.jdbc("jdbc:mysql://localhost:3306/demodb", "order", properties)
    frame.printSchema()
    frame.show()
    frame.where("create_time> '2019-09-09 00:00:00'")
  }

}
