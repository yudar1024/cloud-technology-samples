// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test_grpc.proto

package com.mycompany.proto.dto;

public interface TestReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.mycompany.proto.dto.TestReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 age = 1;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>.google.protobuf.Timestamp currentTIme = 2;</code>
   * @return Whether the currentTIme field is set.
   */
  boolean hasCurrentTIme();
  /**
   * <code>.google.protobuf.Timestamp currentTIme = 2;</code>
   * @return The currentTIme.
   */
  com.google.protobuf.Timestamp getCurrentTIme();
  /**
   * <code>.google.protobuf.Timestamp currentTIme = 2;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCurrentTImeOrBuilder();

  /**
   * <code>string name = 3;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 3;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
