/*
 * Copyright 2017-2019 original authors
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
package io.micronaut.security.authentication.providers;

/**
 * Represents the state of a user after authentication.
 *
 * @author Sergio del Amo
 * @since 1.0
 */
public interface UserState {

    /**
     *
     * @return The username
     */
    String getUsername();

    /**
     *
     * @return The encrypted password
     * @deprecated Use {@link #getPasswordArray()} instead
     */
    @Deprecated
    String getPassword();

    /**
     *
     * @return The encrypted password
     */
    default char[] getPasswordArray() {
        return this.getPassword().toCharArray();
    }

    /**
     *
     * @return true if the user account is enabled
     */
    boolean isEnabled();

    /**
     *
     * @return true if the user account is expired
     */
    boolean isAccountExpired();

    /**
     *
     * @return true if the user account is locked
     */
    boolean isAccountLocked();

    /**
     *
     * @return true if the user has an expired password
     */
    boolean isPasswordExpired();
}
