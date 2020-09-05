package org.examples.spark.rdd.file

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object LocalFileWordCount {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("word-count").setMaster("local[*]")
    val context = new SparkContext(conf)
    val rdd = context.textFile(args(0))
    val words = rdd.flatMap(line => {
      line.split(" ")
    })
    val value:RDD[(String,Int)] = words.map((_, 1))
    val reduceRdd = value.reduceByKey(_ + _)
    val sortRdd = reduceRdd.sortBy(_._2, false)
    sortRdd.saveAsTextFile("D:\\devtools\\testdata\\count")

  }
}
