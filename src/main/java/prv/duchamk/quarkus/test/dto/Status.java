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
package prv.duchamk.quarkus.test.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

/**
 *
 * @author <a href="mailto:duchamk@wp.pl">Albert Michał Kubicki</a>
 */
@RegisterForReflection
public class Status {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
