/*
 * Copyright 2024 <a href="mailto:duchamk@wp.pl">Albert Michał Kubicki</a>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package prv.duchamk.quarkus.test.provider;

import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import java.util.function.Supplier;

/**
 *
 * @author <a href="mailto:duchamk@wp.pl">Albert Michał Kubicki</a>
 */
public class MyChatMemoryProvider implements Supplier<ChatMemoryProvider> {

    private final InMemoryChatMemoryStore store = new InMemoryChatMemoryStore();

    @Override
    public ChatMemoryProvider get() {
        return (Object memoryId) -> MessageWindowChatMemory.builder()
            .maxMessages(20)
            .id(memoryId)
            .chatMemoryStore(store)
            .build();
    }
}
