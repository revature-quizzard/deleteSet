package com.revature.delete_set;

import com.revature.exceptions.InvalidRequestException;
import com.revature.exceptions.ResourceNotFoundException;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.DeleteItemEnhancedRequest;
import software.amazon.awssdk.enhanced.dynamodb.model.ScanEnhancedRequest;
import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.List;
import java.util.Map;

public class SetRepo {
    private final DynamoDbTable<Set> setTable;

    public SetRepo(){
        DynamoDbClient db = DynamoDbClient.builder().httpClient(ApacheHttpClient.create()).build();
        DynamoDbEnhancedClient dbClient = DynamoDbEnhancedClient.builder().dynamoDbClient(db).build();
        setTable = dbClient.table("Sets", TableSchema.fromBean(Set.class));
    }

    /**
     * Deletes a set from the Sets table by id
     * @Authors Jack Raney and Alfonso Holmes
     * @param id
     */
    public boolean deleteSetById(String id ) {
        //creating new set_document for query
        Set s = new Set();
        s.setId(id);
        System.out.println(id);

        setTable.deleteItem(s);
        //System.out.println(setTable.deleteItem(request));
        return true;

    }
}
