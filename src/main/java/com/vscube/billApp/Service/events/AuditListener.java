package com.vscube.billApp.Service.events;

import com.vscube.billApp.Service.exception.VSCubeException;
import com.vscube.billApp.core.AuditHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

@Component
public class AuditListener extends AbstractMongoEventListener<Object> {

    private static final String _SUFFIX = "_audit";

    @Autowired
    private MongoOperations mongoOperations;

    public AuditListener() {
    }

    @Override
    public void onAfterSave(AfterSaveEvent<Object> event) {
        String collectionName = null;



        try{

             collectionName = event.getCollectionName();
             if(collectionName.endsWith(_SUFFIX)) return;

             Object source =  event.getSource();


             Class documentType = source.getClass();

             String auditCollectionName =  getAuditCollectionName(documentType, collectionName);
             final String id= getKeyFromSource(source);
             final long version = getVersionFromSource(source);
             mongoOperations.insert(new AuditHolder(source, id,version), auditCollectionName);
        }
        catch(Exception e){
            throw new VSCubeException("Audit failed or " + collectionName + " ," + e.getMessage());
        }



    }

    private long getVersionFromSource(Object source) {
        try {
            Class aClass = source.getClass();
            Field keyField = aClass.getDeclaredField("version");
            keyField.setAccessible(true);
            Object value = keyField.get(source);
            System.out.println("Value of version :" + value);
            if(Long.class.isInstance(value)) return (long) value;
            else return -1;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            return -1;
        }
    }

    private String getKeyFromSource(Object source) {
        try {
            Class aClass = source.getClass();
            Field keyField = aClass.getDeclaredField("id");
            keyField.setAccessible(true);
            Object value = keyField.get(source);
            if(value instanceof  String) return (String) value;
            if(value instanceof  Long) return ((Long) value).toString();
            if(value instanceof UUID) return ((UUID) value).toString();
            return value.toString();

        } catch (NoSuchFieldException | IllegalAccessException e) {
            final String eventMsgId = UUID.randomUUID().toString();
            return  eventMsgId;
        }
    }

    private <T> String getAuditCollectionName(Class<T> documentType, String collectionName) {
        String finalCollectionName = documentType.getSimpleName().equalsIgnoreCase(collectionName)? documentType.getSimpleName() : collectionName;
        return  converClassNameIntoCamelCase(finalCollectionName).concat(_SUFFIX);
    }

    private String converClassNameIntoCamelCase(String name) {
        return name.substring(0,1).toLowerCase()+ name.substring(1);
    }


}
