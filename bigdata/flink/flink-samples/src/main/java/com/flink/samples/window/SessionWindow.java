package com.flink.samples.window;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.timestamps.BoundedOutOfOrdernessTimestampExtractor;
import org.apache.flink.streaming.api.windowing.assigners.EventTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.ProcessingTimeSessionWindows;
import org.apache.flink.streaming.api.windowing.assigners.SlidingProcessingTimeWindows;
import org.apache.flink.streaming.api.windowing.time.Time;

public class SessionWindow {
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
        keyed.window(ProcessingTimeSessionWindows.withGap(Time.seconds(5))).sum(1).print();
        executionEnvironment.execute("SessionWindow");
    }

    public static void EventTimeSessionWinow() throws Exception {
        StreamExecutionEnvironment executionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        executionEnvironment.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
//        提取时间戳，不改变数据的数据结构
        SingleOutputStreamOperator<String> localhost = executionEnvironment.socketTextStream("localhost", 9000).assignTimestampsAndWatermarks(new BoundedOutOfOrdernessTimestampExtractor<String>(Time.seconds(0)) {
            @Override
            public long extractTimestamp(String element) {
                String[] split = element.split(",");
                return Long.valueOf(split[0]);
            }
        });
//        输入1000 spark,3  第一位是时间戳，注意是格林威治时间
//        1291 hadoop,2
        SingleOutputStreamOperator<Tuple2<String, Integer>> maped = localhost.map((String x) -> {
            String[] split = x.split(",");
            return Tuple2.of(split[1], Integer.parseInt(split[2]));
        }).returns(Types.TUPLE(Types.STRING, Types.INT));

        KeyedStream<Tuple2<String, Integer>, Tuple> keyed = maped.keyBy(0);
        keyed.window(EventTimeSessionWindows.withGap(Time.seconds(5))).sum(1).print();
        executionEnvironment.execute("SessionWindow");
    }
}
