package com.flink.samples;

import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

import java.util.Arrays;

public class MapTransforms {

    public static void main(String[] args) {
        final ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        DataSource<Integer> integerDataSource = env.fromElements(1, 2, 3, 4, 5);
        integerDataSource.map(new RichMapFunction<Integer, Integer>() {
            //在构造方法之后，在map方法之前执行，只执行一次，Configuration 拿到全局配置，用于初始化连接，或者用来获取state
            @Override
            public void open(Configuration parameters) throws Exception {
                super.open(parameters);
            }
            //销毁之前执行一次，通常用于释放资源
            @Override
            public void close() throws Exception {
                super.close();
            }

            @Override
            public Integer map(Integer value) throws Exception {
                return null;
            }
        });
        DataSource<String> stringDataSource = env.fromElements("where are you", "i am in scholl");
//      常规写法
        stringDataSource.flatMap(new RichFlatMapFunction<String, String>() {
            @Override
            public void flatMap(String value, Collector<String> out) throws Exception {
                String[] word = value.split(" ");
                for (String s : word) {
                    out.collect(s);
                }
            }
        });
//      lamda
        stringDataSource.flatMap((String sentence, Collector<String> out) -> Arrays.stream(sentence.split(" ")).forEach(out::collect)).returns(Types.STRING);


    }
}
