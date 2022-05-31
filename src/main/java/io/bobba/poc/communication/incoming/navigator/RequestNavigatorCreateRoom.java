package io.bobba.poc.communication.incoming.navigator;

import io.bobba.poc.BobbaEnvironment;
import io.bobba.poc.communication.incoming.IIncomingEvent;
import io.bobba.poc.communication.protocol.ClientMessage;
import io.bobba.poc.core.gameclients.GameClient;
import io.bobba.poc.core.users.User;

public class RequestNavigatorCreateRoom implements IIncomingEvent {
    @Override
    public void handle(GameClient client, ClientMessage request) {
    	User user = client.getUser();
        if (user != null){
        	String roomName = request.popString();
        	String modelId = request.popString();
        	
        	BobbaEnvironment.getGame().getRoomManager().createRoom(user, roomName, modelId);
        }
    }
}