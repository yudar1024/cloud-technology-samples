package org.example.sparksql.hive

import org.apache.spark.sql.SparkSession

/**
 * 添加spark-hive_2.12 3.0 maven 依赖
 * 添加 mysql-connector-java 8.0.20 依赖
 * 需要把hive-site.xml 的文件放到本地工程文件的classpath里，如果是集群，还需要core-site.xml 与 hdfs-site.xml
 */
object HiveExample {
  def main(args: Array[String]): Unit = {
    val session = SparkSession.builder().appName(this.getClass.getSimpleName).master("local[*]").enableHiveSupport().getOrCreate()
    val dataFrame = session.sql("select * from person")
    dataFrame.show()
    dataFrame.printSchema()
  }
}
