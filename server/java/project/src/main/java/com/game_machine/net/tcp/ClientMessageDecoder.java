package com.game_machine.net.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

import GameMachine.Messages.ClientMessage;

import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

@Sharable
public class ClientMessageDecoder extends MessageToMessageDecoder<ByteBuf> {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
		final byte[] array;
		final int offset;
		final int length = msg.readableBytes();
		if (msg.hasArray()) {
			array = msg.array();
			offset = msg.arrayOffset() + msg.readerIndex();
		} else {
			array = new byte[length];
			msg.getBytes(msg.readerIndex(), array, 0, length);
			offset = 0;
		}

		ClientMessage message = new ClientMessage();
		ProtobufIOUtil.mergeFrom(array, offset, length, message, RuntimeSchema.getSchema(ClientMessage.class));
		out.add(message);
	}
}
