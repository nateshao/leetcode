package com.nateshao.source.code.serializable.msgpack_Serializable;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.msgpack.packer.Packer;
import org.msgpack.template.CharacterTemplate;
import org.msgpack.template.Template;
import org.msgpack.unpacker.Unpacker;
/**
 * @date Created by 邵桐杰 on 2023/2/25 23:11
 * @微信公众号 程序员千羽
 * @博客 https://nateshao.gitlab.io
 * @GitHub https://github.com/nateshao
 * Description:
 */
public abstract class MsgPackTemplate <T> implements Template<T> {

    public void write(Packer pk, T v) throws IOException {
        write(pk, v, false);
    }

    public T read(Unpacker u, T to) throws IOException {
        return read(u, to, false);
    }

    public BigDecimal readBigDecimal(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }

        String temp = u.readString();
        if (temp != null) {
            return new BigDecimal(temp);
        }
        return null;
    }

    public Date readDate(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }

        long temp = u.readLong();
        if (temp > 0) {
            return new Date(temp);
        }
        return null;
    }

    public String readString(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readString();
    }

    public Integer readInteger(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readInt();
    }

    public Byte readByte(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readByte();
    }

    public Short readShort(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readShort();
    }

    public Float readFloat(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readFloat();
    }

    public Double readDouble(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readDouble();
    }

    public Character readCharacter(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.read(CharacterTemplate.getInstance());

    }

    public Long readLong(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readLong();
    }

    public Boolean readBoolean(Unpacker u) throws IOException {
        if (u.trySkipNil()) {
            return null;
        }
        return u.readBoolean();
    }




    public void writeBigDecimal(Packer pk, BigDecimal v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.toString());
        }
    }

    public void writeDate(Packer pk, Date v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.getTime());
        }
    }

    public void writeString(Packer pk, String v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v);
        }
    }

    public void writeInt(Packer pk, int v) throws IOException {
        pk.write(v);
    }

    public void writeInteger(Packer pk, Integer v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.intValue());
        }
    }

    public void writeByte(Packer pk, Byte v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.byteValue());
        }
    }

    public void writeShort(Packer pk, Short v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.shortValue());
        }
    }

    public void writeFloat(Packer pk, Float v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.floatValue());
        }
    }

    public void writeDouble(Packer pk, Double v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.doubleValue());
        }
    }

    public void writeCharacter(Packer pk, Character v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.charValue());
        }

    }

    public void writeLong(Packer pk, Long v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.longValue());
        }
    }

    public void writeLong(Packer pk, long v) throws IOException {
        pk.write(v);
    }

    public void writeBoolean(Packer pk, Boolean v) throws IOException {
        if (v == null) {
            pk.writeNil();
        } else {
            pk.write(v.booleanValue());
        }
    }
}
