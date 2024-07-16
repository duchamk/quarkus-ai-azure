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
package prv.duchamk.quarkus.test.rest;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import prv.duchamk.quarkus.test.dto.Statement;
import prv.duchamk.quarkus.test.azure.AiChatEasyRag;

/**
 *
 * @author <a href="mailto:duchamk@wp.pl">Albert Michał Kubicki</a>
 */
@Path("/rag")
public class ChatEasyRag {

    @Inject
    AiChatEasyRag aiChatEasyRag;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Statement conversation(Statement statement) {
        Log.infof("--->>> %s", statement.getUser());
        var ai = aiChatEasyRag.chat(statement.getUser());
        return statement.NewStatement(ai);
    }
}
