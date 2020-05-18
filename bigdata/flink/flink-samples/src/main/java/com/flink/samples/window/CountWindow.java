package com.flink.samples.window;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

// 每个分组的数据量达到数量之后才会触发
public class CountWindow {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> localhost = executionEnvironment.socketTextStream("localhost", 9000);
//        输入 spark,3
//        hadoop,2
        SingleOutputStreamOperator<Tuple2<String, Integer>> maped = localhost.map((String x) -> {
            String[] split = x.split(",");
            return Tuple2.of(split[0], Integer.parseInt(split[1]));
        }).returns(Types.TUPLE(Types.STRING, Types.INT));

        KeyedStream<Tuple2<String, Integer>, Tuple> keyed = maped.keyBy(0);
        keyed.countWindow(5).sum(1).print();

        executionEnvironment.execute("countwindow");

    }
}
