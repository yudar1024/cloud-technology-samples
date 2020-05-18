package com.flink.samples.window;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.datastream.AllWindowedStream;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;

public class CountWindowAll {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<String> localhost = env.socketTextStream("localhost", 9000);
        SingleOutputStreamOperator<String> maped = localhost.map(x -> String.valueOf(x)).returns(Types.STRING);
        AllWindowedStream<String, GlobalWindow> stringGlobalWindowAllWindowedStream = localhost.countWindowAll(5);
        SingleOutputStreamOperator<String> sum = stringGlobalWindowAllWindowedStream.sum(0);
        sum.print();
        env.execute("CountWindowAll");

    }
}
