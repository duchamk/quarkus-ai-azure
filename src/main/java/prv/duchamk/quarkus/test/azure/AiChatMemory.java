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
package prv.duchamk.quarkus.test.azure;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.quarkiverse.langchain4j.RegisterAiService;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.UUID;
import prv.duchamk.quarkus.test.provider.MyChatMemoryProvider;

/**
 *
 * @author <a href="mailto:duchamk@wp.pl">Albert Michał Kubicki</a>
 */
@ApplicationScoped
@RegisterAiService(chatMemoryProviderSupplier = MyChatMemoryProvider.class)
public interface AiChatMemory {
    @SystemMessage("""
                   Your name is Dobromir. 
                   My name is Albert.
                   Additional information in the context.
                   ```Context
                   Śród takich pól przed laty, nad brzegiem ruczaju,
                   Na pagórku niewielkim, we brzozowym gaju,
                   Stał dwór szlachecki, z drzewa, lecz podmurowany;
                   Świeciły się z daleka pobielane ściany,
                   Tym bielsze, że odbite od ciemnej zieleni
                   Topoli, co go bronią od wiatrów jesieni.
                   Dom mieszkalny niewielki, lecz zewsząd chędogi,
                   I stodołę miał wielką, i przy niej trzy stogi
                   Użątku, co pod strzechą zmieścić się nie może.
                   Widać, że okolica obfita we zboże,
                   I widać z liczby kopic, co wzdłuż i wszerz smugów
                   Świecą gęsto jak gwiazdy, widać z liczby pługów
                   Orzących wcześnie łany ogromne ugoru,
                   Czarnoziemne, zapewne należne do dworu,
                   Uprawne dobrze na kształt ogrodowych grządek:
                   Że w tym domu dostatek mieszka i porządek.
                   Brama na wciąż otwarta przechodniom ogłasza,
                   Że gościnna, i wszystkich w gościnę zaprasza.
                   ```
                   """)
    String chat(@MemoryId UUID memoryId, @UserMessage String userMessage);
}
