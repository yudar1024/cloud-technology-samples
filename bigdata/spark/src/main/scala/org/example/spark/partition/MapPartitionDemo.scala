package org.example.spark.partition

import org.apache.spark.{SparkConf, SparkContext}

object MapPartitionDemo {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("map-partition").setMaster("local[*]")
    val context = new SparkContext(conf)
    val rdd = context.makeRDD(List(1, 2, 3, 4, 5, 6), 2)
    val rdd2 = rdd.mapPartitions(it => it.map(item => item * 2))
    val ints = rdd.collect()

    ints.foreach(print(_))
  }

}
