package com.flink.samples.common;

import org.apache.flink.api.common.restartstrategy.RestartStrategies;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class ExecutionEnvUtil {

   public static ParameterTool createParameterTool(final String[] args) throws Exception {
        return ParameterTool
                .fromPropertiesFile(ExecutionEnvUtil.class.getResourceAsStream(FlinkProperties.PROPERTIES_FILE_NAME))
                .mergeWith(ParameterTool.fromArgs(args))
                .mergeWith(ParameterTool.fromSystemProperties());
    }

    public static final ParameterTool PARAMETER_TOOL = createParameterTool();

    private static ParameterTool createParameterTool() {
        try {
            return ParameterTool
                    .fromPropertiesFile(ExecutionEnvUtil.class.getResourceAsStream(FlinkProperties.PROPERTIES_FILE_NAME))
                    .mergeWith(ParameterTool.fromSystemProperties());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ParameterTool.fromSystemProperties();
    }

    public static StreamExecutionEnvironment prepare(ParameterTool parameterTool) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        env.setParallelism(parameterTool.getInt(FlinkProperties.STREAM_PARALLELISM, 5));
        env.getConfig().disableSysoutLogging();
        env.getConfig().setRestartStrategy(RestartStrategies.fixedDelayRestart(4, 60000));
        if (parameterTool.getBoolean(FlinkProperties.STREAM_CHECKPOINT_ENABLE, true)) {
            env.enableCheckpointing(parameterTool.getLong(FlinkProperties.STREAM_CHECKPOINT_INTERVAL, 10000));
        }
        env.getConfig().setGlobalJobParameters(parameterTool);
        env.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        return env;
    }
    
}