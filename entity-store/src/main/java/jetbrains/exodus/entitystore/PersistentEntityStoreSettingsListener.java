/**
 * Copyright 2010 - 2017 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.exodus.entitystore;

import jetbrains.exodus.ConfigSettingChangeListener;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

class PersistentEntityStoreSettingsListener extends ConfigSettingChangeListener.Adapter {

    @NotNull
    private final PersistentEntityStoreImpl store;

    PersistentEntityStoreSettingsListener(@NotNull final PersistentEntityStoreImpl store) {
        this.store = store;
    }


    @Override
    public void afterSettingChanged(@NotNull String key, @NotNull Object value, @NotNull Map<String, Object> context) {
        if (PersistentEntityStoreConfig.CACHING_DISABLED.equals(key)) {
            // if caching is switched on/off then clear EntityIterableCache
            store.getEntityIterableCache().clear();
        }
    }
}
