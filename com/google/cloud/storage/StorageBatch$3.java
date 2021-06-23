package com.google.cloud.storage;

import com.google.cloud.storage.spi.v1.*;
import com.google.api.services.storage.model.*;
import com.google.api.client.googleapis.json.*;

class StorageBatch$3 implements RpcBatch.Callback<StorageObject> {
    final /* synthetic */ StorageBatchResult val$result;
    final /* synthetic */ StorageOptions val$serviceOptions;
    final /* synthetic */ StorageBatch this$0;
    
    StorageBatch$3(final StorageBatch a1, final StorageBatchResult val$result, final StorageOptions val$serviceOptions) {
        this.this$0 = a1;
        this.val$result = val$result;
        this.val$serviceOptions = val$serviceOptions;
        super();
    }
    
    @Override
    public void onSuccess(final StorageObject a1) {
        this.val$result.success((a1 == null) ? null : Blob.fromPb((Storage)this.val$serviceOptions.getService(), a1));
    }
    
    @Override
    public void onFailure(final GoogleJsonError a1) {
        this.val$result.error(new StorageException(a1));
    }
    
    @Override
    public /* bridge */ void onSuccess(final Object o) {
        this.onSuccess((StorageObject)o);
    }
}