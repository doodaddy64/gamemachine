
package GameMachine.Messages;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.io.UnsupportedEncodingException;

import com.dyuproject.protostuff.ByteString;
import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.ProtobufOutput;

import java.io.ByteArrayOutputStream;
import com.dyuproject.protostuff.JsonIOUtil;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import com.game_machine.util.LocalLinkedBuffer;

import java.nio.charset.Charset;

import org.javalite.activejdbc.Model;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.UninitializedMessageException;

@SuppressWarnings("unused")
public final class GameConfig implements Externalizable, Message<GameConfig>, Schema<GameConfig>
{

    public static Schema<GameConfig> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static GameConfig getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final GameConfig DEFAULT_INSTANCE = new GameConfig();
    static final String defaultScope = GameConfig.class.getSimpleName();

		public String config;

		public Integer version;

		public String gameId;

    public GameConfig()
    {
        
    }

	public static void clearModel(Model model) {

    	model.set("game_config_config",null);

    	model.set("game_config_version",null);

    	model.set("game_config_game_id",null);
    	
    }
    
	public void toModel(Model model) {

    	if (config != null) {
    		model.setString("game_config_config",config);
    	}

    	if (version != null) {
    		model.setInteger("game_config_version",version);
    	}

    	if (gameId != null) {
    		model.setString("game_config_game_id",gameId);
    	}

    }
    
	public static GameConfig fromModel(Model model) {
		boolean hasFields = false;
    	GameConfig message = new GameConfig();

    	String configField = model.getString("game_config_config");
    	if (configField != null) {
    		message.setConfig(configField);
    		hasFields = true;
    	}

    	Integer versionField = model.getInteger("game_config_version");
    	if (versionField != null) {
    		message.setVersion(versionField);
    		hasFields = true;
    	}

    	String gameIdField = model.getString("game_config_game_id");
    	if (gameIdField != null) {
    		message.setGameId(gameIdField);
    		hasFields = true;
    	}

    	if (hasFields) {
    		return message;
    	} else {
    		return null;
    	}
    }

    public Boolean hasConfig()  {
        return config == null ? false : true;
    }

	public String getConfig() {
		return config;
	}
	
	public GameConfig setConfig(String config) {
		this.config = config;
		return this;
	}

    public Boolean hasVersion()  {
        return version == null ? false : true;
    }

	public Integer getVersion() {
		return version;
	}
	
	public GameConfig setVersion(Integer version) {
		this.version = version;
		return this;
	}

    public Boolean hasGameId()  {
        return gameId == null ? false : true;
    }

	public String getGameId() {
		return gameId;
	}
	
	public GameConfig setGameId(String gameId) {
		this.gameId = gameId;
		return this;
	}

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<GameConfig> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public GameConfig newMessage()
    {
        return new GameConfig();
    }

    public Class<GameConfig> typeClass()
    {
        return GameConfig.class;
    }

    public String messageName()
    {
        return GameConfig.class.getSimpleName();
    }

    public String messageFullName()
    {
        return GameConfig.class.getName();
    }

    public boolean isInitialized(GameConfig message)
    {
        return true;
    }

    public void mergeFrom(Input input, GameConfig message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                
            	case 1:

                	message.config = input.readString();
                	break;

            	case 2:

                	message.version = input.readInt32();
                	break;

            	case 3:

                	message.gameId = input.readString();
                	break;

                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }

    public void writeTo(Output output, GameConfig message) throws IOException
    {

    	if(message.config == null)
            throw new UninitializedMessageException(message);

    	if(message.config != null)
            output.writeString(1, message.config, false);

    	if(message.version == null)
            throw new UninitializedMessageException(message);

    	if(message.version != null)
            output.writeInt32(2, message.version, false);

    	if(message.gameId == null)
            throw new UninitializedMessageException(message);

    	if(message.gameId != null)
            output.writeString(3, message.gameId, false);

    }

    public String getFieldName(int number)
    {
        switch(number)
        {
        	
        	case 1: return "config";
        	
        	case 2: return "version";
        	
        	case 3: return "gameId";
        	
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
    	
    	__fieldMap.put("config", 1);
    	
    	__fieldMap.put("version", 2);
    	
    	__fieldMap.put("gameId", 3);
    	
    }
   
   public static List<String> getFields() {
	ArrayList<String> fieldNames = new ArrayList<String>();
	String fieldName = null;
	Integer i = 1;
	
    while(true) { 
		fieldName = GameConfig.getSchema().getFieldName(i);
		if (fieldName == null) {
			break;
		}
		fieldNames.add(fieldName);
		i++;
	}
	return fieldNames;
}

public static GameConfig parseFrom(byte[] bytes) {
	GameConfig message = new GameConfig();
	ProtobufIOUtil.mergeFrom(bytes, message, GameConfig.getSchema());
	return message;
}

public static GameConfig parseFromJson(String json) throws IOException {
	byte[] bytes = json.getBytes(Charset.forName("UTF-8"));
	GameConfig message = new GameConfig();
	JsonIOUtil.mergeFrom(bytes, message, GameConfig.getSchema(), false);
	return message;
}

public GameConfig clone() {
	byte[] bytes = this.toByteArray();
	GameConfig gameConfig = GameConfig.parseFrom(bytes);
	return gameConfig;
}
	
public byte[] toByteArray() {
	return toProtobuf();
	//return toJson();
}

public String toJson() {
	boolean numeric = false;
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	try {
		JsonIOUtil.writeTo(out, this, GameConfig.getSchema(), numeric);
	} catch (IOException e) {
		e.printStackTrace();
		throw new RuntimeException("Json encoding failed");
	}
	String json = new String(out.toByteArray(), Charset.forName("UTF-8"));
	return json;
}

public byte[] toPrefixedByteArray() {
	LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
  Schema<GameConfig> schema = GameConfig.getSchema();
    
	final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final ProtobufOutput output = new ProtobufOutput(buffer);
    try
    {
    	schema.writeTo(output, this);
        final int size = output.getSize();
        ProtobufOutput.writeRawVarInt32Bytes(out, size);
        final int msgSize = LinkedBuffer.writeTo(out, buffer);
        assert size == msgSize;
        
        buffer.clear();
        return out.toByteArray();
    }
    catch (IOException e)
    {
        throw new RuntimeException("Serializing to a byte array threw an IOException " + 
                "(should never happen).", e);
    }
 
}

public byte[] toProtobuf() {
	LinkedBuffer buffer = LocalLinkedBuffer.get();
	byte[] bytes = null;

	try {
		bytes = ProtobufIOUtil.toByteArray(this, GameConfig.getSchema(), buffer);
		buffer.clear();
	} catch (Exception e) {
		buffer.clear();
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bytes;
}

public ByteBuf toByteBuf() {
	ByteBuf bb = Unpooled.buffer(512, 2048);
	LinkedBuffer buffer = LinkedBuffer.use(bb.array());

	try {
		ProtobufIOUtil.writeTo(buffer, this, GameConfig.getSchema());
	} catch (Exception e) {
		e.printStackTrace();
		throw new RuntimeException("Protobuf encoding failed");
	}
	return bb;
}

}