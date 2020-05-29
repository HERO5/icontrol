// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Test.proto

package com.mrl.network.protobuf;

public final class Test {
  private Test() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ProtoTestOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required int32 id = 1;
    /**
     * <code>required int32 id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required int32 id = 1;</code>
     */
    int getId();

    // optional string title = 2;
    /**
     * <code>optional string title = 2;</code>
     */
    boolean hasTitle();
    /**
     * <code>optional string title = 2;</code>
     */
    String getTitle();
    /**
     * <code>optional string title = 2;</code>
     */
    com.google.protobuf.ByteString
        getTitleBytes();

    // optional string content = 3;
    /**
     * <code>optional string content = 3;</code>
     */
    boolean hasContent();
    /**
     * <code>optional string content = 3;</code>
     */
    String getContent();
    /**
     * <code>optional string content = 3;</code>
     */
    com.google.protobuf.ByteString
        getContentBytes();
  }
  /**
   * Protobuf type {@code com.example.user.nettydemo.ProtoTest}
   */
  public static final class ProtoTest extends
      com.google.protobuf.GeneratedMessage
      implements ProtoTestOrBuilder {
    // Use ProtoTest.newBuilder() to construct.
    private ProtoTest(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private ProtoTest(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final ProtoTest defaultInstance;
    public static ProtoTest getDefaultInstance() {
      return defaultInstance;
    }

    public ProtoTest getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private ProtoTest(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readInt32();
              break;
            }
            case 18: {
              bitField0_ |= 0x00000002;
              title_ = input.readBytes();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              content_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Test.internal_static_com_example_user_nettydemo_ProtoTest_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Test.internal_static_com_example_user_nettydemo_ProtoTest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ProtoTest.class, Builder.class);
    }

    public static com.google.protobuf.Parser<ProtoTest> PARSER =
        new com.google.protobuf.AbstractParser<ProtoTest>() {
      public ProtoTest parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ProtoTest(input, extensionRegistry);
      }
    };

    @Override
    public com.google.protobuf.Parser<ProtoTest> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required int32 id = 1;
    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>required int32 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    // optional string title = 2;
    public static final int TITLE_FIELD_NUMBER = 2;
    private Object title_;
    /**
     * <code>optional string title = 2;</code>
     */
    public boolean hasTitle() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional string title = 2;</code>
     */
    public String getTitle() {
      Object ref = title_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          title_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string title = 2;</code>
     */
    public com.google.protobuf.ByteString
        getTitleBytes() {
      Object ref = title_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        title_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // optional string content = 3;
    public static final int CONTENT_FIELD_NUMBER = 3;
    private Object content_;
    /**
     * <code>optional string content = 3;</code>
     */
    public boolean hasContent() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional string content = 3;</code>
     */
    public String getContent() {
      Object ref = content_;
      if (ref instanceof String) {
        return (String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          content_ = s;
        }
        return s;
      }
    }
    /**
     * <code>optional string content = 3;</code>
     */
    public com.google.protobuf.ByteString
        getContentBytes() {
      Object ref = content_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (String) ref);
        content_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      id_ = 0;
      title_ = "";
      content_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getTitleBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getContentBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getTitleBytes());
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getContentBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @Override
    protected Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static ProtoTest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoTest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoTest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ProtoTest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ProtoTest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ProtoTest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static ProtoTest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static ProtoTest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static ProtoTest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static ProtoTest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(ProtoTest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @Override
    protected Builder newBuilderForType(
        BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.example.user.nettydemo.ProtoTest}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements ProtoTestOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Test.internal_static_com_example_user_nettydemo_ProtoTest_descriptor;
      }

      protected FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Test.internal_static_com_example_user_nettydemo_ProtoTest_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ProtoTest.class, Builder.class);
      }

      // Construct using com.example.user.nettydemo.Test.ProtoTest.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        id_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        title_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        content_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Test.internal_static_com_example_user_nettydemo_ProtoTest_descriptor;
      }

      public ProtoTest getDefaultInstanceForType() {
        return ProtoTest.getDefaultInstance();
      }

      public ProtoTest build() {
        ProtoTest result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public ProtoTest buildPartial() {
        ProtoTest result = new ProtoTest(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.title_ = title_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.content_ = content_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ProtoTest) {
          return mergeFrom((ProtoTest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ProtoTest other) {
        if (other == ProtoTest.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasTitle()) {
          bitField0_ |= 0x00000002;
          title_ = other.title_;
          onChanged();
        }
        if (other.hasContent()) {
          bitField0_ |= 0x00000004;
          content_ = other.content_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ProtoTest parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ProtoTest) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required int32 id = 1;
      private int id_ ;
      /**
       * <code>required int32 id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder setId(int value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0;
        onChanged();
        return this;
      }

      // optional string title = 2;
      private Object title_ = "";
      /**
       * <code>optional string title = 2;</code>
       */
      public boolean hasTitle() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional string title = 2;</code>
       */
      public String getTitle() {
        Object ref = title_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          title_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string title = 2;</code>
       */
      public com.google.protobuf.ByteString
          getTitleBytes() {
        Object ref = title_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          title_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string title = 2;</code>
       */
      public Builder setTitle(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        title_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string title = 2;</code>
       */
      public Builder clearTitle() {
        bitField0_ = (bitField0_ & ~0x00000002);
        title_ = getDefaultInstance().getTitle();
        onChanged();
        return this;
      }
      /**
       * <code>optional string title = 2;</code>
       */
      public Builder setTitleBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        title_ = value;
        onChanged();
        return this;
      }

      // optional string content = 3;
      private Object content_ = "";
      /**
       * <code>optional string content = 3;</code>
       */
      public boolean hasContent() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional string content = 3;</code>
       */
      public String getContent() {
        Object ref = content_;
        if (!(ref instanceof String)) {
          String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          content_ = s;
          return s;
        } else {
          return (String) ref;
        }
      }
      /**
       * <code>optional string content = 3;</code>
       */
      public com.google.protobuf.ByteString
          getContentBytes() {
        Object ref = content_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (String) ref);
          content_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string content = 3;</code>
       */
      public Builder setContent(
          String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string content = 3;</code>
       */
      public Builder clearContent() {
        bitField0_ = (bitField0_ & ~0x00000004);
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      /**
       * <code>optional string content = 3;</code>
       */
      public Builder setContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        content_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.example.user.nettydemo.ProtoTest)
    }

    static {
      defaultInstance = new ProtoTest(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.example.user.nettydemo.ProtoTest)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_user_nettydemo_ProtoTest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_example_user_nettydemo_ProtoTest_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\nTest.proto\022\032com.example.user.nettydemo" +
      "\"7\n\tProtoTest\022\n\n\002id\030\001 \002(\005\022\r\n\005title\030\002 \001(\t" +
      "\022\017\n\007content\030\003 \001(\t"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_example_user_nettydemo_ProtoTest_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_example_user_nettydemo_ProtoTest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_example_user_nettydemo_ProtoTest_descriptor,
              new String[] { "Id", "Title", "Content", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
