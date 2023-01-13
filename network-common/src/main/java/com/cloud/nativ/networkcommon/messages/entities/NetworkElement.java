/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.cloud.nativ.networkcommon.messages.entities;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class NetworkElement extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8153797099755853058L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NetworkElement\",\"namespace\":\"com.cloud.nativ.networkcommon.messages.entities\",\"fields\":[{\"name\":\"ipAddress\",\"type\":\"string\"},{\"name\":\"area\",\"type\":\"int\"},{\"name\":\"elementType\",\"type\":\"string\"},{\"name\":\"connections\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"Connection\",\"fields\":[{\"name\":\"ipAddress\",\"type\":\"string\"},{\"name\":\"cost\",\"type\":\"int\"}]}}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<NetworkElement> ENCODER =
      new BinaryMessageEncoder<NetworkElement>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NetworkElement> DECODER =
      new BinaryMessageDecoder<NetworkElement>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<NetworkElement> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<NetworkElement> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<NetworkElement> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NetworkElement>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this NetworkElement to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a NetworkElement from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a NetworkElement instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static NetworkElement fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence ipAddress;
  private int area;
  private java.lang.CharSequence elementType;
  private java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> connections;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NetworkElement() {}

  /**
   * All-args constructor.
   * @param ipAddress The new value for ipAddress
   * @param area The new value for area
   * @param elementType The new value for elementType
   * @param connections The new value for connections
   */
  public NetworkElement(java.lang.CharSequence ipAddress, java.lang.Integer area, java.lang.CharSequence elementType, java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> connections) {
    this.ipAddress = ipAddress;
    this.area = area;
    this.elementType = elementType;
    this.connections = connections;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ipAddress;
    case 1: return area;
    case 2: return elementType;
    case 3: return connections;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ipAddress = (java.lang.CharSequence)value$; break;
    case 1: area = (java.lang.Integer)value$; break;
    case 2: elementType = (java.lang.CharSequence)value$; break;
    case 3: connections = (java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection>)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'ipAddress' field.
   * @return The value of the 'ipAddress' field.
   */
  public java.lang.CharSequence getIpAddress() {
    return ipAddress;
  }


  /**
   * Sets the value of the 'ipAddress' field.
   * @param value the value to set.
   */
  public void setIpAddress(java.lang.CharSequence value) {
    this.ipAddress = value;
  }

  /**
   * Gets the value of the 'area' field.
   * @return The value of the 'area' field.
   */
  public int getArea() {
    return area;
  }


  /**
   * Sets the value of the 'area' field.
   * @param value the value to set.
   */
  public void setArea(int value) {
    this.area = value;
  }

  /**
   * Gets the value of the 'elementType' field.
   * @return The value of the 'elementType' field.
   */
  public java.lang.CharSequence getElementType() {
    return elementType;
  }


  /**
   * Sets the value of the 'elementType' field.
   * @param value the value to set.
   */
  public void setElementType(java.lang.CharSequence value) {
    this.elementType = value;
  }

  /**
   * Gets the value of the 'connections' field.
   * @return The value of the 'connections' field.
   */
  public java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> getConnections() {
    return connections;
  }


  /**
   * Sets the value of the 'connections' field.
   * @param value the value to set.
   */
  public void setConnections(java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> value) {
    this.connections = value;
  }

  /**
   * Creates a new NetworkElement RecordBuilder.
   * @return A new NetworkElement RecordBuilder
   */
  public static com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder newBuilder() {
    return new com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder();
  }

  /**
   * Creates a new NetworkElement RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NetworkElement RecordBuilder
   */
  public static com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder newBuilder(com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder other) {
    if (other == null) {
      return new com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder();
    } else {
      return new com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder(other);
    }
  }

  /**
   * Creates a new NetworkElement RecordBuilder by copying an existing NetworkElement instance.
   * @param other The existing instance to copy.
   * @return A new NetworkElement RecordBuilder
   */
  public static com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder newBuilder(com.cloud.nativ.networkcommon.messages.entities.NetworkElement other) {
    if (other == null) {
      return new com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder();
    } else {
      return new com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder(other);
    }
  }

  /**
   * RecordBuilder for NetworkElement instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NetworkElement>
    implements org.apache.avro.data.RecordBuilder<NetworkElement> {

    private java.lang.CharSequence ipAddress;
    private int area;
    private java.lang.CharSequence elementType;
    private java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> connections;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ipAddress)) {
        this.ipAddress = data().deepCopy(fields()[0].schema(), other.ipAddress);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.area)) {
        this.area = data().deepCopy(fields()[1].schema(), other.area);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.elementType)) {
        this.elementType = data().deepCopy(fields()[2].schema(), other.elementType);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.connections)) {
        this.connections = data().deepCopy(fields()[3].schema(), other.connections);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing NetworkElement instance
     * @param other The existing instance to copy.
     */
    private Builder(com.cloud.nativ.networkcommon.messages.entities.NetworkElement other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.ipAddress)) {
        this.ipAddress = data().deepCopy(fields()[0].schema(), other.ipAddress);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.area)) {
        this.area = data().deepCopy(fields()[1].schema(), other.area);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.elementType)) {
        this.elementType = data().deepCopy(fields()[2].schema(), other.elementType);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.connections)) {
        this.connections = data().deepCopy(fields()[3].schema(), other.connections);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'ipAddress' field.
      * @return The value.
      */
    public java.lang.CharSequence getIpAddress() {
      return ipAddress;
    }


    /**
      * Sets the value of the 'ipAddress' field.
      * @param value The value of 'ipAddress'.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder setIpAddress(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.ipAddress = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'ipAddress' field has been set.
      * @return True if the 'ipAddress' field has been set, false otherwise.
      */
    public boolean hasIpAddress() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ipAddress' field.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder clearIpAddress() {
      ipAddress = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'area' field.
      * @return The value.
      */
    public int getArea() {
      return area;
    }


    /**
      * Sets the value of the 'area' field.
      * @param value The value of 'area'.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder setArea(int value) {
      validate(fields()[1], value);
      this.area = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'area' field has been set.
      * @return True if the 'area' field has been set, false otherwise.
      */
    public boolean hasArea() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'area' field.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder clearArea() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'elementType' field.
      * @return The value.
      */
    public java.lang.CharSequence getElementType() {
      return elementType;
    }


    /**
      * Sets the value of the 'elementType' field.
      * @param value The value of 'elementType'.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder setElementType(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.elementType = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'elementType' field has been set.
      * @return True if the 'elementType' field has been set, false otherwise.
      */
    public boolean hasElementType() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'elementType' field.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder clearElementType() {
      elementType = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'connections' field.
      * @return The value.
      */
    public java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> getConnections() {
      return connections;
    }


    /**
      * Sets the value of the 'connections' field.
      * @param value The value of 'connections'.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder setConnections(java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> value) {
      validate(fields()[3], value);
      this.connections = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'connections' field has been set.
      * @return True if the 'connections' field has been set, false otherwise.
      */
    public boolean hasConnections() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'connections' field.
      * @return This builder.
      */
    public com.cloud.nativ.networkcommon.messages.entities.NetworkElement.Builder clearConnections() {
      connections = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NetworkElement build() {
      try {
        NetworkElement record = new NetworkElement();
        record.ipAddress = fieldSetFlags()[0] ? this.ipAddress : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.area = fieldSetFlags()[1] ? this.area : (java.lang.Integer) defaultValue(fields()[1]);
        record.elementType = fieldSetFlags()[2] ? this.elementType : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.connections = fieldSetFlags()[3] ? this.connections : (java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection>) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NetworkElement>
    WRITER$ = (org.apache.avro.io.DatumWriter<NetworkElement>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NetworkElement>
    READER$ = (org.apache.avro.io.DatumReader<NetworkElement>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.ipAddress);

    out.writeInt(this.area);

    out.writeString(this.elementType);

    long size0 = this.connections.size();
    out.writeArrayStart();
    out.setItemCount(size0);
    long actualSize0 = 0;
    for (com.cloud.nativ.networkcommon.messages.entities.Connection e0: this.connections) {
      actualSize0++;
      out.startItem();
      e0.customEncode(out);
    }
    out.writeArrayEnd();
    if (actualSize0 != size0)
      throw new java.util.ConcurrentModificationException("Array-size written was " + size0 + ", but element count was " + actualSize0 + ".");

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.ipAddress = in.readString(this.ipAddress instanceof Utf8 ? (Utf8)this.ipAddress : null);

      this.area = in.readInt();

      this.elementType = in.readString(this.elementType instanceof Utf8 ? (Utf8)this.elementType : null);

      long size0 = in.readArrayStart();
      java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> a0 = this.connections;
      if (a0 == null) {
        a0 = new SpecificData.Array<com.cloud.nativ.networkcommon.messages.entities.Connection>((int)size0, SCHEMA$.getField("connections").schema());
        this.connections = a0;
      } else a0.clear();
      SpecificData.Array<com.cloud.nativ.networkcommon.messages.entities.Connection> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.cloud.nativ.networkcommon.messages.entities.Connection>)a0 : null);
      for ( ; 0 < size0; size0 = in.arrayNext()) {
        for ( ; size0 != 0; size0--) {
          com.cloud.nativ.networkcommon.messages.entities.Connection e0 = (ga0 != null ? ga0.peek() : null);
          if (e0 == null) {
            e0 = new com.cloud.nativ.networkcommon.messages.entities.Connection();
          }
          e0.customDecode(in);
          a0.add(e0);
        }
      }

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.ipAddress = in.readString(this.ipAddress instanceof Utf8 ? (Utf8)this.ipAddress : null);
          break;

        case 1:
          this.area = in.readInt();
          break;

        case 2:
          this.elementType = in.readString(this.elementType instanceof Utf8 ? (Utf8)this.elementType : null);
          break;

        case 3:
          long size0 = in.readArrayStart();
          java.util.List<com.cloud.nativ.networkcommon.messages.entities.Connection> a0 = this.connections;
          if (a0 == null) {
            a0 = new SpecificData.Array<com.cloud.nativ.networkcommon.messages.entities.Connection>((int)size0, SCHEMA$.getField("connections").schema());
            this.connections = a0;
          } else a0.clear();
          SpecificData.Array<com.cloud.nativ.networkcommon.messages.entities.Connection> ga0 = (a0 instanceof SpecificData.Array ? (SpecificData.Array<com.cloud.nativ.networkcommon.messages.entities.Connection>)a0 : null);
          for ( ; 0 < size0; size0 = in.arrayNext()) {
            for ( ; size0 != 0; size0--) {
              com.cloud.nativ.networkcommon.messages.entities.Connection e0 = (ga0 != null ? ga0.peek() : null);
              if (e0 == null) {
                e0 = new com.cloud.nativ.networkcommon.messages.entities.Connection();
              }
              e0.customDecode(in);
              a0.add(e0);
            }
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










